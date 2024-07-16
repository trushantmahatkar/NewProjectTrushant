package TestClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.Admin_IP_POM__Class;

import POMClasses.TestBaseClass;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class Admin_IP_Test_Class extends TestBaseClass
{
public SoftAssert soft;
	
	@Test(enabled=true,priority=0)
	public void verifyAddNewAdminIP() throws InterruptedException, IOException
	{
		Admin_IP_POM__Class ip = new Admin_IP_POM__Class(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickAdminIPTab();
		ip.clickClientDropdownButton();
		ip.sendClientDropdown(15,3);
		ip.clickSearchButton();
		Thread.sleep(500);
		ip.clickAddNewButton();
		ip.sendAdminIP(15,0);
		ip.clickSubmitButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"New Admin IP Added");
		String expected = excelSheetCode.testData(driver,15,0);
		soft.assertEquals(ip.getMasterIP(),expected,"Add New Admin IP fails");
		soft.assertAll();
	}
	@Test(enabled=true,priority=1)
	public void verifyAddSameAdminIP() throws InterruptedException, IOException
	{
		Admin_IP_POM__Class ip = new Admin_IP_POM__Class(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickAddNewButton();
		ip.sendAdminIP(15,0);
		ip.clickSubmitButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Add Same Admin IP Added");
		soft.assertTrue(true,"Add No Admin IP fails");
		soft.assertAll();
		ip.clickCloseButton();
		Thread.sleep(1000);
	}
	@Test(enabled=true,priority=2)
	public void verifyAddNoAdminIP() throws InterruptedException, IOException
	{
		Admin_IP_POM__Class ip = new Admin_IP_POM__Class(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickAddNewButton();
		ip.clickSubmitButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"New No Admin IP Added");
		soft.assertTrue(ip.checkError(),"Add No Admin IP fails");
		soft.assertAll();
		ip.clickCloseButton();
		Thread.sleep(1000);

	}
	@Test(enabled=true,priority=3)
	public void verifyDeleteAdminIP() throws InterruptedException, IOException
	{
		Admin_IP_POM__Class ip = new Admin_IP_POM__Class(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickDeleteButton();
		Thread.sleep(1000);
		ip.clickDeletePopupButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Delete Admin IP");
		soft.assertTrue(true,"delete Admin IP fails");
		soft.assertAll();
	}
	@Test(enabled=true,priority=4)
	public void verifyClientSelected() throws InterruptedException, IOException
	{
		Admin_IP_POM__Class ip = new Admin_IP_POM__Class(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickAdminIPTab();
		ip.clickSearchButton();
		Thread.sleep(500);
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"No client selected");
		soft.assertTrue(ip.checkError(),"No client selected fails");
		soft.assertAll();
	}
}
