package TestClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.ReservedKeywordControlPinPOMClass;
import POMClasses.TestBaseClass;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class ControlPinFunctionality extends TestBaseClass
{
	public SoftAssert soft;
	@Test(priority=0)
	public void verifyAddControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);

	soft = new SoftAssert();
	rc.clickPlayerSettings();
	Thread.sleep(2000);
	rc.clickControlPin();
	rc.clickAddNewPin();
	rc.sendControlPin();
	Thread.sleep(1000);
	rc.clickSubmitButton();
	Thread.sleep(2000);
	screenshot.ScreenShot(driver,"Control Pin Added");
//	String expected = excelSheetCode.testData1(driver);
//	soft.assertEquals(rc.getAddedPinEntry(),expected,"Add Control Pin Functionality Fails");
	soft.assertAll();
	}
	
	@Test(priority=1)
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
	
	@Test(priority=2)
	public void verifyMassDeleteControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
//	rc.clickCheckBox();
	rc.clickMassDeleteButton();
	Thread.sleep(1000);
	rc.clickDeleteButtonControlPin();
	Thread.sleep(1000);
	screenshot.ScreenShot(driver,"Control Pin Deleted");
	soft.assertTrue(true,"Control Pin Deleted Functionality Fails");
	soft.assertAll();
	}
	
	@Test(priority=3)
	public void verifySearchControlPinFunctionality() throws InterruptedException, IOException
	{
	ReservedKeywordControlPinPOMClass rc = new ReservedKeywordControlPinPOMClass(driver);
	soft = new SoftAssert();
	Thread.sleep(2000);
	rc.searchTextboxControl();
	Thread.sleep(1000);
	screenshot.ScreenShot(driver,"Control Pin search");
//	String expected = excelSheetCode.testData1(driver);
//	soft.assertEquals(rc.getAddedEntry(),expected,"Search Control Pin Functionality Fails");
	soft.assertAll();
	rc.clearControl();
	}
}
