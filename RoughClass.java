package TestRunner;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RoughClass {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
        driver.get("https://my.autobill.com/");
        driver.findElement(By.linkText("Retrieve Password")).click();
        driver.findElement(By.id("email")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".login-button")).click();
       
//        JavascriptExecutor js=null ;
//        if (driver instanceof JavascriptExecutor) {
//            js = (JavascriptExecutor)driver;
//        }
//        System.out.println("test +++");
//        js.executeScript("console.log('i am in')");
//        js.executeScript("document.getElementById('email').validationMessage)");
//        js.executeScript("console.log('i am out')");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
       // driver.findElement(By.cssSelector("input[type='email']")).sendKeys("asd");
        Object s=js.executeScript("return document.getElementById('email').validationMessage");
        System.out.println(s);
//        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("asd@gmail.com");
//        s=js.executeScript("return document.getElementById(\"a\").validity.valid");
//        System.out.println(s);
}
}