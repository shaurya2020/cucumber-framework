package step_definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

	WebDriver driver;

	@Given("user should login SauceDemo page")
	public void user_should_login_SauceDemo_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Then("user should be redirected to the products page")
	public void verify_products_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
		Assert.assertEquals("Products", driver.findElement(By.className("title")).getText());
	}

	@When("user adds {string} to the cart")
	public void add_product_to_cart(String productName) {
		List<WebElement> products = driver.findElements(By.className("inventory_item"));

		boolean productFound = false;

		for (WebElement product : products) {
			String name = product.findElement(By.className("inventory_item_name")).getText();

			if (name.equals(productName)) {
				product.findElement(By.cssSelector("button.btn_inventory")).click();

				productFound = true;
				break;
			}
		}

		Assert.assertTrue(productFound, "Product not found: " + productName);
	}

	@Then("the cart badge should display {string}")
	public void verify_cart_badge(String expectedCount) {
		String actualCount = driver.findElement(By.className("shopping_cart_badge")).getText();

		Assert.assertEquals(expectedCount, actualCount);
	}

	@Then("the shopping cart should contain {string}")
	public void verify_product_in_cart(String productName) {
		driver.findElement(By.className("shopping_cart_link")).click();

		List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));

		boolean itemFound = false;

		for (WebElement item : cartItems) {
			if (item.getText().equals(productName)) {
				itemFound = true;
				break;
			}
		}

//		Assert.assertTrue("Product is missing from the cart: " + productName, itemFound);
	}

	@When("user removes {string} from the cart")
	public void remove_product_from_cart(String productName) {
		driver.findElement(By.className("shopping_cart_link")).click();

		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

		for (WebElement item : cartItems) {
			String name = item.findElement(By.className("inventory_item_name")).getText();

			if (name.equals(productName)) {
				item.findElement(By.cssSelector("button.cart_button")).click();

				return;
			}
		}

//		Assert.fail("Product not found in cart: " + productName);
	}

	@Then("the cart badge should not be displayed")
	public void verify_cart_badge_not_displayed() {
		List<WebElement> badges = driver.findElements(By.className("shopping_cart_badge"));

//		Assert.assertTrue("Cart badge should not be displayed", badges.isEmpty());

		driver.quit();
	}
}
