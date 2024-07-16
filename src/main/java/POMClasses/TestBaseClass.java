package POMClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UtilityClass.screenshot;

public class TestBaseClass 
{
	public WebDriver driver;
//	public Logger log=Logger.getLogger("WL_2.0");
	@BeforeTest
	public void setup() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Users\\trushantmahatkar\\Downloads\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
		driver = new ChromeDriver();
//		PropertyConfigurator.configure("log4j.properties");
//		"D:\Users\trushantmahatkar\Downloads\chromedriver.exe"
		System.out.println("Browser is Opened");
		driver.manage().window().maximize();
		System.out.println("Browser is Maximized");
		driver.get("http://master.test.api-hkbgaming88.com/");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//		driver.navigate().refresh();
		System.out.println("URL is Opened");
		screenshot.ScreenShot(driver,"Login Page");
		LoginPomClass lp = new LoginPomClass(driver);
		lp.sendUserName();
		System.out.println("UserName Entered");
		lp.sendPassword();
		Thread.sleep(10000);
		System.out.println("Password Entered");
		lp.clickLoginButton();
		System.out.println("Login Button Clicked");
	}
	
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//	}

}