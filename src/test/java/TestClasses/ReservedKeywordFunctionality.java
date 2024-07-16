package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.ReservedKeywordControlPinPOMClass;
import POMClasses.TestBaseClass;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class ReservedKeywordFunctionality extends TestBaseClass 
{
	public SoftAssert soft;
	@Test(priority=0,enabled=true)
	public void verifyAddKeywordFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	rc.clickPlayerSettings();
	rc.clickReservedKeywords();
	rc.clickAddNewButton();
	Thread.sleep(1000);
	rc.sendKeyword();
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Add New Keyword");
	String expected = excelSheetCode.testData(driver,0,0);
	soft.assertEquals(rc.getAddedEntry(),expected,"Add New Keyword Functionality Fails");
	soft.assertAll();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyAddNoKeywordFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	Thread.sleep(3000);
	soft = new SoftAssert();
	rc.clickAddNewButton();
	Thread.sleep(2000);
	rc.clickSubmitButton();
	screenshot.ScreenShot(driver,"Add No Keyword");
	String expected ="The name field is required.";
	soft.assertEquals(rc.getErrorMessage1(),expected,"Add No Keyword Functionality Fails");
	soft.assertAll();
	Thread.sleep(1000);
	rc.clickCloseButton();
	}
	
	@Test(priority=2,enabled=true)
	public void verifyExistingKeywordFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	Thread.sleep(2000);
	soft = new SoftAssert();
	rc.clickAddNewButton();
	rc.sendKeyword();
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Add Existing Keyword");
	String expected ="The name has already been taken.";
	soft.assertEquals(rc.getErrorMessage2(),expected,"Add Existing Keyword Functionality Fails");
	soft.assertAll();
	rc.clickCloseButton();
	}
	
	@Test(priority=3,enabled=true)
	public void verifySearchKeywordFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	Thread.sleep(2000);
	soft = new SoftAssert();
	rc.searchTextboxReserve();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Search Keyword");
	String expected = excelSheetCode.testData(driver,0,0);
	soft.assertEquals(rc.getAddedEntry(),expected,"Search Keyword Functionality Fails");
	soft.assertAll();
	rc.clearKeyword();
	}
	
	@Test(priority=4,enabled=true)
	public void verifyDeleteKeywordFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	Thread.sleep(2000);
	soft = new SoftAssert();
	rc.clickdeleteButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Delete Popup Keyword");
	rc.clickdeleteNowButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Keyword Deleted");
	soft.assertTrue(true,"Delete Keyword Functionality Fails");
	soft.assertAll();
	}
	
	@Test(priority=5)
	public void verifyAddControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);

	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.clickPlayerSettings();
	rc.clickControlPin();
	rc.clickAddNewPin();
	System.out.println("clicked add new pin");
	rc.sendControlPin();
	System.out.println("send pin");
	Thread.sleep(1000);
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Control Pin Added");
	int expected = (int)excelSheetCode.testData1(driver,0,0);
	soft.assertEquals(Integer.parseInt(rc.getAddedPinEntry()),expected,"Add Control Pin Functionality Fails");
	soft.assertAll();
	}
	
	@Test(priority=6)
	public void verifyNoControlPinAddFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.clickAddNewPin();
	Thread.sleep(1000);
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Control Pin Not Added");
	String expected = "The pin field is required.";
	soft.assertEquals(rc.getEmptyPinErrorMessage(),expected,"No Pin Added Functionality Fails");
	soft.assertAll();
	rc.clickCloseButton();
	}
	
	@Test(priority=7)
	public void verifyExistingControlPinAddFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.clickAddNewPin();
	System.out.println("clicked add new pin");
	rc.sendControlPin();
	Thread.sleep(2000);
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Control Pin Already exist");
	String expected = "The pin has already been taken.";
	soft.assertEquals(rc.getExistErrorMessage(),expected,"Add Control Pin Functionality Fails");
	soft.assertAll();
	rc.clickCloseButton();
	}
	
	@Test(priority=8)
	public void verifySearchControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.searchTextboxControl();
	Thread.sleep(1000);
	screenshot.ScreenShot(driver,"Control Pin search");
	int expected = (int)excelSheetCode.testData1(driver,0,0);
	soft.assertEquals(Integer.parseInt(rc.getAddedPinEntry()),expected,"Search Control Pin Functionality Fails");
	soft.assertAll();
	rc.clearControl();
	}
	
	@Test(priority=9)
	public void verifyMassDeleteControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.clickMassCheckBox();
	rc.clickMassDeleteButton();
	Thread.sleep(1000);
	rc.clickDeleteButtonControlPin();
	Thread.sleep(1000);
	screenshot.ScreenShot(driver,"Control Pin Deleted");
	soft.assertTrue(true,"Control Pin Deleted Functionality Fails");
	soft.assertAll();
	}
	
	
	
}
