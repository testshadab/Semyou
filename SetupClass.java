//package TestRunner;
//
//import java.io.FileReader;
//import java.net.URL;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class SetupClass {
//	public static WebDriver driver;
//	public static String baseURL;
//	public static Properties property = new Properties(System.getProperties());
//	public static String browserName;
//	public static String platformVersion;
//	public static String platform;
//	public static DesiredCapabilities capabilities;
//    public static String Local;
//
//	@BeforeClass
//	public static void beforeClass() throws Exception {
//
//		property.load(new FileReader(
//				"C:\\Users\\Uday\\workspace\\ZPvnSivvi\\src\\main\\resources\\config.properties"));
//
//			
//		String browser = property.getProperty("browser");
//		System.out.println(browser);
//		baseURL = property.getProperty("baseURL");
//		driver = new FirefoxDriver();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(baseURL);
//	}
//		
//	@AfterClass
//	public static void afterClass() {
//		driver.close();
//		driver.quit();
//	}
//}

package TestRunner;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import GenericAction.ReusableActions;
import TestHelper.LoginHelper;

public class SetupClass {
	public static WebDriver driver;
	public static String baseURL;
	public static String appiumVersion;
	public static Properties property = new Properties(System.getProperties());
	public static String sauceURL;
	public static String browserName;
	public static String platformVersion;
	public static String platform;
	public static String platformName;
	public static String deviceName;
	public static String deviceOrientation;
	public static String oncloud;
	public static String onMobile;
	public static Logger log;
	public static DesiredCapabilities capabilities;
	public static ReusableActions reusableMethods = new ReusableActions();
	public static LoginHelper loginHelper = new LoginHelper();

	@BeforeClass
	public static void beforeClass() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader(
				"C:\\Users\\Uday\\workspace\\AutoBill\\src\\main\\resources\\config.properties"));

		baseURL = property.getProperty("base_url");
		sauceURL = property.getProperty("sauce_url");
		deviceName = property.getProperty("device_name");
		browserName = property.getProperty("browser");
		appiumVersion = property.getProperty("appium_version");
		platformVersion = property.getProperty("platform_version");
		platformName = property.getProperty("platform_name");
		platform = property.getProperty("platform");
		oncloud = property.getProperty("oncloud");
		onMobile = property.getProperty("onmobile");

		/*** To run desktop project condition if onMobile is equal to "no" then */

		if ((oncloud.equals("no")) && (onMobile.equals("no"))) {
		//if (oncloud.equals("no")) {
			/*** To run desktop project on local */
			System.out.print("Awesome!");
			String browser = property.getProperty("browser");
			System.out.println(browser);
			//baseURL = property.getProperty("base_url");
			
			String hub = property.getProperty("hubAddress");
			String ieDriverExe = property.getProperty("ieDriverPath");
			String chromeDriverExe = property.getProperty("chromeDriverPath");
			System.out.println(baseURL);

			if (browser.equals("firefox")) {
				// driver = new RemoteWebDriver(new
				// URL(hub),DesiredCapabilities.firefox());
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverExe);
				driver = new RemoteWebDriver(new URL(hub),
						DesiredCapabilities.chrome());
			} else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver", ieDriverExe);
				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
				// dc.setCapability(CapabilityType.VERSION, "10");
				// dc.setCapability(CapabilityType.PLATFORM, "WINDOWS");
				driver = new RemoteWebDriver(new URL(hub), dc);
			}

		} else  {
			System.out.println("test");
			browserName = System.getenv("SELENIUM_BROWSER");
			platform = System.getenv("SELENIUM_PLATFORM");
			platformVersion = System.getenv("SELENIUM_VERSION");

			System.out.println("browserName======"+browserName);
			System.out.println("platform======"+platform);
			System.out.println("platformVersion===="+platformVersion);

			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("platform", platform);
			capability.setBrowserName(browserName);
		    //capability.setCapability("browser", browserName);
		    capability.setCapability("version", platformVersion);
		    capability.setCapability("name", "My Desktop automation test******************");
			
		    
			driver = new RemoteWebDriver(new URL(sauceURL), capability);
			System.out.println("after run");
		}
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void afterClass() {
		 //driver.close();
		driver.quit();
	}
}