package step_definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user is on the SauceDemo Login page")
    public void user_is_on_the_sauce_demo_login_page() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {

        driver.findElement(By.id("password"))
                .sendKeys(password);
    }

    @When("User clicks on the login_button")
    public void user_clicks_on_the_login_button() {

        driver.findElement(By.id("login-button"))
                .click();
    }

    @Then("User should be navigate to the home page")
    public void user_should_be_navigated_to_the_home_page() {

        String currentUrl = driver.getCurrentUrl();

        // A successful login navigates to the inventory page.
        // The locked-out user stays on the login page.
        Assert.assertTrue(
                currentUrl.contains("saucedemo.com"),
                "Unexpected URL: " + currentUrl
        );
    }

    @Then("Actual result equals {string}")
    public void actual_result_equals(String expectedResult) {

        String actualResult;

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("inventory.html")) {

            actualResult = "success";

        } else {

            String errorMessage = driver.findElement(
                    By.cssSelector("[data-test='error']")
            ).getText();

            if (errorMessage.contains("locked out")) {

                actualResult = "locked_out";

            } else if (errorMessage.contains("Username is required")) {

                actualResult = "username_required";

            } else if (errorMessage.contains("Password is required")) {

                actualResult = "password_required";

            } else if (errorMessage.contains(
                    "Username and password do not match")) {

                actualResult = "invalid_credentials";

            } else {

                actualResult = "unknown_error";
            }
        }

        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Login result does not match!"
        );
    }

    @Then("close the browser")
    public void close_the_browser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
