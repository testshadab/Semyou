package TestRunner.loginSteps;

import ObjectRepository.LoginObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends SetupClass {

	@Given("^Application login page$")
	public void Application_login_page() throws Throwable {
		driver.get(baseURL);
		Thread.sleep(5000);
	}

	@Then("^enter email in \"([^\"]*)\" field$")
	public void enter_email_in_field(String arg1) throws Throwable {
		driver.findElement(LoginObject.EmailField).sendKeys(arg1);
	}

	@Then("^enter password in \"([^\"]*)\" field$")
	public void enter_password_in_field(String arg2) throws Throwable {
		driver.findElement(LoginObject.Passfield).sendKeys(arg2);
	}

	@Then("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		driver.findElement(LoginObject.LoginBtn).click();
	
	}

	@Then("^click on user icon drop down button$")
	public void click_on_user_icon_drop_down_button() throws Throwable {
	    driver.findElement(LoginObject.Usericon).click();
	}

	@Then("^click on Logout icon$")
	public void click_on_Logout_icon() throws Throwable {
	   driver.findElement(LoginObject.Logout).click();
	}
	@Then("^verify Login button$")
	public void verify_Login_button() throws Throwable {
		reusableMethods.verifElementVisible(5, LoginObject.LoginBtn);
	}
	//Verify Validation Steps
	
	@Then("^Verify \"([^\"]*)\" for \"([^\"]*)\" validation message for username$")
	public void Verify_for_validation_message_for_username(String arg1, String arg2) throws Throwable {
	    
	}

	@Then("^Verify \"([^\"]*)\" for \"([^\"]*)\" validation message for password$")
	public void Verify_for_validation_message_for_password(String arg1, String arg2) throws Throwable {
	    
	}

	@Then("^Verify \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\" validation for all invalid credentials$")
	public void Verify_for_and_validation_for_all_invalid_credentials(String loginErrorMsg, String Email, String Password) throws Throwable {
		loginHelper.verifyCommonLoginValMessage(loginErrorMsg, Email, Password);
	}
	
}