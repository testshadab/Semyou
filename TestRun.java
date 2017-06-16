package TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" }, features = { "." }, tags = {"@Fogotpass"})
public class TestRun {

	@BeforeClass
	public static void beforeClass() throws Exception {
		SetupClass.beforeClass();
	}

	@AfterClass
	public static void afterClass() {
		SetupClass.afterClass();
	}
}