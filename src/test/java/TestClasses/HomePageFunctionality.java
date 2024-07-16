package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMClasses.HomePagePOMClass;
import POMClasses.TestBaseClass;
import UtilityClass.screenshot;

public class HomePageFunctionality extends TestBaseClass
{
	@Test(enabled=true,priority=0)
	public void verifyHeaderFunctionality() throws IOException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		String actualNews = hp.get_News();
		System.out.println(actualNews);	
		Assert.assertTrue(hp.verifyHeaderNews(),"Internal News Functionality Fails");
		screenshot.ScreenShot(driver,"Header");
	}
	
	@Test(enabled=true,priority=1)
	public void verifyDateTimeFunctionality() throws IOException 
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		String dateTime=hp.checkDateTime();
		System.out.println(dateTime);	
		Assert.assertTrue(hp.verifyDate_Time(),"Date & Time Functionality Fails");
		screenshot.ScreenShot(driver,"Date & Time");
	}
	
	@Test(enabled=true,priority=2)
	public void verifyMultilingualLogoFunctionality() throws IOException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		hp.change_Language();
		screenshot.ScreenShot(driver,"Multilingual");
		System.out.println("Language is changed");
		Assert.assertTrue(hp.verifyMultilingual(),"Multilingual Funtionality Fails");
	}
	
	@Test(enabled=true,priority=3)
	public void verifyProfileFunctionality() throws IOException, InterruptedException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		hp.clickonProfileIcon();
		System.out.println("Profile Icon is Clicked");
		System.out.println("Profile is Clicked");
		System.out.println("My Profile Page is Opened");
		Assert.assertTrue(true,"My Profile Functionality Fails");
	}
	@Test(enabled=true,priority=4)	
	public void verifyNOChangePasswordFunctionality() throws IOException, InterruptedException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		hp.notpassingdataChangePasswordSetting();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"No Change Password");
		String expectedCurrent="The old password field is required.";
		String expectedNew="The new password field is required.";
		System.out.println("Profile Icon is Clicked");	
		Assert.assertEquals(expectedCurrent,hp.getCurrentError(),"Change Password Functionality Fails");
		Assert.assertEquals(expectedNew,hp.getNewError(),"Change Password Functionality Fails");
		System.out.println("Please Provide Password");
		hp.clickChangePasswordCloseButton();
	}
	
	@Test(enabled=true,priority=5)	
	public void verifyWrongPasswordFunctionality() throws IOException, InterruptedException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		hp.wrongDataChangePasswordSetting();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Wrong Change Password");
		String expectedNew="The new password confirmation does not match.";
		System.out.println("Profile Icon is Clicked");
		Assert.assertEquals(expectedNew,hp.getWrongNewError(),"Change Password Functionality Fails");
		System.out.println("New Password is not Matched");
		hp.clickChangePasswordCloseButton();
	}
	
	@Test(enabled=true,priority=6)	
	public void verifyChangePasswordFunctionality() throws IOException, InterruptedException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		hp.clickonChangePasswordSetting();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Change Password");
		System.out.println("Profile Icon is Clicked");
		System.out.println("Change Password is Clicked");
		System.out.println("Password Change Successfully");
		Assert.assertTrue(true,"Change Password Functionality Fails");
	}
	
	@Test(enabled=true,priority=7)
	public void verifyLogoutFunctionality() throws IOException, InterruptedException
	{
		HomePagePOMClass hp = new HomePagePOMClass(driver);
		Thread.sleep(4000);
		hp.clickonLogout();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Logout done came to Login Page");
		System.out.println("Profile Icon is Clicked");
		System.out.println("Logout is Clicked");
		System.out.println("Logout Successfully");
		String expectedURL= "http://master.test.api-hkbgaming88.com/login";
		String actualURL =hp.getURL();
		Assert.assertEquals(actualURL,expectedURL,"Logout Fnctionality Fails");
	}
}
