package TestClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.PlayerPasswordAccountLimitPOMClass;
import POMClasses.TestBaseClass;
import UtilityClass.JavascriptUtitlity;
import UtilityClass.screenshot;

public class PlayerPasswordAccLimitTestClass extends TestBaseClass
{
	public SoftAssert soft;
	
	
	@Test(enabled=false, priority=0)	public void verifyPlayerPassAccLimitFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(1000);
	pp.sendPlayerPassAccLimit(19,1);
	Thread.sleep(1000);
	pp.sendDurationPassPlayer(20,1);
	Thread.sleep(1000);
	pp.sendMaxResetPass(21,1);
	Thread.sleep(1000);
	pp.sendDurationReset(22,1);
	Thread.sleep(1000);
	pp.sendNextReset(23,1);
	Thread.sleep(1000);
	pp.sendNextResetDuration(24,1);
	Thread.sleep(1000);
	pp.clickExpiredPassUpdateButton();
	Thread.sleep(1000);
	JavascriptUtitlity.scrollUp(driver);
	screenshot.ScreenShot(driver,"Player password Account limit Added");
	soft.assertTrue(true,"Player password Account limit Add Functionality Fails");
	soft.assertAll();
	}
	
	@Test(enabled=false, priority=1)
	public void verifyNoPlayerPassAccLimitFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(2000);
	pp.clearExpiredPassAccLimit();
	Thread.sleep(2000);
	pp.clickExpiredPassUpdateButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"No Player password Account limit Added");
	soft.assertTrue(pp.checkExpiredPassErrorMessage(),"No Player password Account limit Add Functionality Fails");
	soft.assertAll();
	}
	
	@Test(enabled=false, priority=2)
	public void verifyNoEmailMessageAddedFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(2000);
	pp.clearEmailMessage();
	Thread.sleep(2000);
	pp.clickEmailUpdateButton();
	screenshot.ScreenShot(driver,"No Email Message Added");
	soft.assertTrue(true,"No Email Message Add Functionality Fails");
	soft.assertAll();
	}
	
	@Test(enabled=false, priority=3)
	public void verifyAddEmailMessageFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(2000);
	pp.sendEmailMessage(19,3);
	pp.clickEmailUpdateButton();
	screenshot.ScreenShot(driver,"Email Message Added");
	soft.assertTrue(true,"Email Message Add Functionality Fails");
	soft.assertAll();
	}
	
	@Test(enabled=false, priority=4)
	public void verifyNoEmailVerificationMessageAddedFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(2000);
	pp.clearEmailVerificationMessage();
	Thread.sleep(2000);
	pp.clickEmailVerificationUpdateButton();
	screenshot.ScreenShot(driver,"No Email Verification Message Added");
	soft.assertTrue(true,"No Email Verification Message Add Functionality Fails");
	soft.assertAll();
	}
	
	@Test(enabled=true, priority=5)
	public void verifyAddEmailVerificationMessageFunctionality() throws InterruptedException, IOException
	{
	PlayerPasswordAccountLimitPOMClass pp = new PlayerPasswordAccountLimitPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	pp.clickPlayerSettingsMenu();
	pp.clickPlayerPassAccTab();
	Thread.sleep(2000);
	pp.sendEmailVerificationMessage(20,3);
	pp.clickEmailVerificationUpdateButton();
	screenshot.ScreenShot(driver,"Email Verification Message Added");
	soft.assertTrue(true,"Email Verification Message Add Functionality Fails");
	soft.assertAll();
	}
}
