package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerTest {
	@CucumberOptions(features = "src/test/resources/features",
			glue = "step_definitions",
			tags="login"
			)
	
	public class TestRunner extends AbstractTestNGCucumberTests {
		
	}
}
