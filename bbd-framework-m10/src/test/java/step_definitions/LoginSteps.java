package step_definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
WebDriver driver;

@Given("user is on the SauceDemo Login page")
public void user_is_on_the_sauce_demo_login_page() {
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  
}

@When("user enters username and password")
public void user_enters_username_and_password() {
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
}

@When("User clicks on the  login_button")
public void user_clicks_on_the_login_button() {
	driver.findElement(By.id("login-button")).click();
}

@Then("User should be navigate to the home page")
public void user_should_be_navigate_to_the_home_page() {
//	System.out.println("itsdone");
//	Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
	Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
}

@Then("close the browser")
public void close_the_browser() {
	driver.quit();
}
}
