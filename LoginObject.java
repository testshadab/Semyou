package ObjectRepository;

import org.openqa.selenium.By;

public class LoginObject {
	// Login Object

	public static By EmailField = By.id("email");
	public static By Passfield = By.id("password");
	public static By LoginBtn = By.cssSelector(".login-button");
	public static By Usericon = By.cssSelector(".create-new");
	public static By Logout = By.cssSelector(".icon.fa.fa-power-off");
	public static By LoginError = By.cssSelector(".error");	
}