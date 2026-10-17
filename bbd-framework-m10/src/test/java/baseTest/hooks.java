package baseTest;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class hooks {
	  WebDriver driver;

	    public hooks(WebDriver driver) {
	        this.driver = driver;
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}