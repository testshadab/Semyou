package TestRunner.loginSteps;

import cucumber.api.java.en.Then;
import ObjectRepository.ForgotPasswordObject;
import TestRunner.SetupClass;

public class ForgotPassSteps extends SetupClass{
	
	@Then("^click on RetrievePassword link$")
	public void click_on_RetrievePassword_link() throws Throwable {
	driver.findElement(ForgotPasswordObject.ForgotLink).click();
	}

	@Then("^click on Fogotpass button$")
	public void click_on_Fogotpass_button() throws Throwable {
	 driver.findElement(ForgotPasswordObject.FPLoginBtn).click(); 
	}

	@Then("^Verify \"([^\"]*)\" for \"([^\"]*)\" validation message for Forgotpassword$")
	public void Verify_for_validation_message_for_Forgotpassword(String FPEmailVal, String FPEmail) throws Throwable {
	loginHelper.verifyCommonForgotValMessage(FPEmailVal, FPEmail);
	}
	
	@Then("^enter fpemail in \"([^\"]*)\" field$")
	public void enter_fpemail_in_field(String arg1) throws Throwable {
	   driver.findElement(ForgotPasswordObject.FPEmailField).sendKeys(arg1);
	}
}
