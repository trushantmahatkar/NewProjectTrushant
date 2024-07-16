package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.LevelControlPOMClass;
import POMClasses.TestBaseClass;
import UtilityClass.JavascriptUtitlity;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class LevelControlFunctionality extends TestBaseClass 
{
	public SoftAssert soft;
	@Test(enabled=true,priority=0)
	public void verifyAddLevelFunctionality() throws IOException, InterruptedException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		soft = new SoftAssert();
		Thread.sleep(1000);
		System.out.println("came to operator settings");
		lc.clickOperatorSettings();
		Thread.sleep(1000);
		System.out.println("click operator setting");
		lc.clickAddLevelButton();
		System.out.println("click add level button");
		Thread.sleep(1000);
		lc.sendLevelName(26,1);
		Thread.sleep(1000);
		System.out.println("send level name");
		lc.clickCheckbox();
		System.out.println("click checkboxes");
		Thread.sleep(2000);
		JavascriptUtitlity.scrollDown(driver);
		Thread.sleep(1000);
		JavascriptUtitlity.scrollUp(driver);
		Thread.sleep(500);
		lc.clickSaveButton();
		System.out.println("click save");
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Add Level");
		String expected = excelSheetCode.testData(driver,26,1);
		soft.assertEquals(expected,lc.getLevel(),"Add Level Funtionality Fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=1)
	public void verifyAddSameLevelNameFunctionality() throws IOException, InterruptedException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		soft = new SoftAssert();
		Thread.sleep(2000);
		lc.clickAddLevelButton();
		Thread.sleep(1000);
		lc.sendLevelName(26,1);
		Thread.sleep(1000);
		lc.clickCheckbox();
		Thread.sleep(2000);
		JavascriptUtitlity.scrollDown(driver);
		Thread.sleep(2000);
		JavascriptUtitlity.scrollUp(driver);
		Thread.sleep(1000);
		lc.clickSaveButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Same Level Name");
		String expected = "The name has already been taken.";
		Thread.sleep(2000);
		soft.assertEquals(expected,lc.getErrorMessage1(),"Add Same Level Name Funtionality Fails");
		soft.assertAll();
		lc.clickBackButton();
		Thread.sleep(2000);
		lc.clickRefreshButton();
	}
	
	@Test(enabled=true,priority=2)
	public void verifyNoLevelNameFunctionality() throws IOException, InterruptedException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		soft = new SoftAssert();
		Thread.sleep(3000);
		lc.clickAddLevelButton();
		Thread.sleep(2000);
		lc.clickCheckbox();
		Thread.sleep(2000);
		JavascriptUtitlity.scrollDown(driver);
		Thread.sleep(2000);
		JavascriptUtitlity.scrollUp(driver);
		Thread.sleep(1000);
		lc.clickSaveButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"No Level Name");
		String expected = "The name field is required.";
		Thread.sleep(2000);
		soft.assertEquals(expected, lc.getErrorMessage2(),"No Level Name Funtionality Fails");
		soft.assertAll();
		lc.clickBackButton();
	}
	
	@Test(enabled=true,priority=3)
	public void verifyEditLevelFunctionality() throws InterruptedException, IOException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		Thread.sleep(2000);
		soft = new SoftAssert();
		lc.clickeditLevel();
		System.out.println("click edit level");
		Thread.sleep(2000);
		lc.clickEditCheckbox();
		System.out.println("click edit level button");
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Changed Level Permission");
		JavascriptUtitlity.scrollDown(driver);
		lc.clickSaveButton();
		JavascriptUtitlity.scrollUp(driver);
		Thread.sleep(1000);
		System.out.println("Click save button");	
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Successfully updated");
		soft.assertTrue(true,"Edit Level Functionality Fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=4)
	public void verifycloseFunctionality() throws InterruptedException, IOException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		Thread.sleep(2000);
		soft = new SoftAssert();
		lc.clickDeleteButton();
		System.out.println("click delete icon");
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"DeleteNow Pop-up");
		lc.clickCloseButton();
		System.out.println("click close button");
		Thread.sleep(2000);
		soft.assertTrue(true,"Close Functionality Fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=5)
	public void verifyLevelDeleteFunctionality() throws InterruptedException, IOException
	{
		LevelControlPOMClass lc = new LevelControlPOMClass(driver);
		Thread.sleep(2000);
		soft = new SoftAssert();
		lc.clickDeleteButton();
		System.out.println("click delete level");
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"DeleteNow Pop-up");
		System.out.println("click delete icon");
		Thread.sleep(2000);
		lc.clickDeleteNowButton();
		System.out.println("click DeleteNow button");
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Level Deleted Successfully");
		soft.assertTrue(true,"Delete Level Functionality Fails");
		soft.assertAll();
	}

}
