package UtilityClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptUtitlity 
{
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-3000)");
	}
public static void scrollUp(WebDriver driver)
	
	{
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0)");
	}
public static void littleScrollDown(WebDriver driver)
{
	JavascriptExecutor js  = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,-2000)");
}
}
