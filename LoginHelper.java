package TestHelper;

import org.junit.Assert;
import org.openqa.selenium.By;

import ObjectRepository.ForgotPasswordObject;
import ObjectRepository.LoginObject;
import TestRunner.SetupClass;

public class LoginHelper extends SetupClass {

	public void compareTextForLoginValidations(String fieldValue, String expected, By locator) {
		/*if (fieldValue=="" || fieldValue== null) {*/
		if (fieldValue.trim().equals("")) {
			System.out.println("feild value is = "+fieldValue);
			reusableMethods.verifElementVisible(5, locator);
			String getText = driver.findElement(locator).getText();
			System.out.println("***************val mssg is = " + getText);
			Assert.assertEquals(expected, getText);
		}else{
			reusableMethods.verifElementInVisible(2, locator);
		}			
	}
	
	public void verifyCommonLoginValMessage(String commonVal, String uName, String pwd){
		if(!(uName.isEmpty()) && !(pwd.isEmpty())){
			System.out.println("&&&&&&&&&&&&&&");
			
			reusableMethods.verifElementVisible(10, LoginObject.LoginError);
			String actualCommonErrMsg = driver.findElement(LoginObject.LoginError).getText();
			System.out.println("Common error======="+actualCommonErrMsg);
			Assert.assertEquals(commonVal, actualCommonErrMsg);
			
		}
		}
	
	public void verifyCommonForgotValMessage(String FPEmailVal, String FPEmail){
		if (!(FPEmail.isEmpty()) ){
			System.out.println("&&&&&&&&&&&&&&");
			reusableMethods.verifElementVisible(10, ForgotPasswordObject.FPError);
			String actualCommonErrMsg = driver.findElement(ForgotPasswordObject.FPError).getText();
			System.out.println("Common error======="+actualCommonErrMsg);
			Assert.assertEquals(FPEmailVal, actualCommonErrMsg);
			
		}
		}

}
