package ObjectRepository;

import org.openqa.selenium.By;

public class ForgotPasswordObject {
//	public static By RetrivePassLink = By.cssSelector(".lost-password>a");
	public static By ForgotLink = By.linkText("Retrieve Password");
	public static By FPEmailField = By.id("email");
	public static By FPLoginBtn = By.cssSelector(".login-button");
	public static By FPError = By.cssSelector(".error");	
	public static By FPCancelBtn = By.cssSelector(".lost-password>a");
	
}
