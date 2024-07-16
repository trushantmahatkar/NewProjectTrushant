package TestClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.MasterIPUserIPPOMClass;
import POMClasses.TestBaseClass;
import POMClasses.clientSettingPOMClass;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class MasterIPUserIPTestClass extends TestBaseClass
{
public SoftAssert soft;
	
	@Test(enabled=true,priority=0)
	public void verifyAddNewMasterIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickMasterIPTab();
		ip.clickAddIPButton();
		ip.sendIP(15,0);
		ip.clickSubmitButton();
		screenshot.ScreenShot(driver,"New Master IP Added");
		String expected = excelSheetCode.testData(driver,15,0);
		soft.assertEquals(ip.getMasterIP(),expected,"Add New Master IP fails");
		soft.assertAll();
	}
	@Test(enabled=true,priority=1)
	public void verifySameMasterIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickMasterIPTab();
		ip.clickAddIPButton();
		ip.sendIP(15,0);
		ip.clickSubmitButton();
		screenshot.ScreenShot(driver,"Same Master IP Error");
		soft.assertTrue(ip.checkError(),"Same Add Master IP fails");
		soft.assertAll();
		ip.clickCloseButton();
	}
	@Test(enabled=true,priority=2)
	public void verifyDeleteMasterIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickMasterIPTab();
		Thread.sleep(1000);
		ip.clickDeleteIpButton();
		Thread.sleep(1000);
		ip.clickDeleteButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Delete Master IP Error");
		soft.assertTrue(true,"Delete Master IP fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=3)
	public void verifyAddNoMasterIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickMasterIPTab();
		ip.clickAddIPButton();
		Thread.sleep(1000);
		ip.clickSubmitButton();
		screenshot.ScreenShot(driver,"Same Master IP Error");
		soft.assertTrue(ip.checkError(),"Same Add Master IP fails");
		soft.assertAll();
		ip.clickCloseButton();
	}
	@Test(enabled=true,priority=4)
	public void verifyAddNewUserIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		ip.clickAddIPButton();
		ip.sendUserIP(15,0);
		ip.sendRemark(15,1);
		ip.clickSubmitButton();
		screenshot.ScreenShot(driver,"Add User IP");
		soft.assertTrue(true,"Add User IP fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=5)
	public void verifyAddSameUserIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		ip.clickAddIPButton();
		ip.sendUserIP(15,0);
		ip.sendRemark(15,1);
		ip.clickSubmitButton();
		screenshot.ScreenShot(driver,"Same User IP Error");
		soft.assertTrue(ip.checkError(),"Same Add User IP fails");
		soft.assertAll();
		ip.clickCloseButton();
	}
	
	@Test(enabled=true,priority=6)
	public void verifyAddNoUserIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		ip.clickAddIPButton();
		ip.clickSubmitButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"No User IP Error");
		soft.assertTrue(ip.checkError(),"No User IP Error fails");
		soft.assertAll();
		Thread.sleep(1000);
		ip.clickCloseButton();
	}

	@Test(enabled=true,priority=7)
	public void verifyMassUpdateUserIP() throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		Thread.sleep(1000);
		ip.clickCheckbox();
		Thread.sleep(1000);
		ip.sendUpdatedUserIP1(16,0);
		ip.sendUpdatedUserIP2(17,0);
		ip.sendUpdatedRemark1(16,1);
		ip.sendUpdatedRemark2(17,1);
		ip.clickUpdateButton();
		ip.clickPopUpSubmitButton();
		screenshot.ScreenShot(driver,"Update User IP Added");
		soft.assertTrue(true,"Update User IP fails");
		soft.assertAll();
	
	}
	@Test(enabled=true,priority=8)
	public void verifySearchUserIP()throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		ip.sendUserIPSearch(16,0);
		ip.clickSearchButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Search user IP");
		soft.assertTrue(true,"Search User IP fails");
		soft.assertAll();
		ip.clearSearchBox();
		Thread.sleep(1000);
		ip.clickSearchButton();
		Thread.sleep(1000);
	}
	@Test(enabled=true,priority=9)
	public void verifyMassDeleteUserIP()throws InterruptedException, IOException
	{
		MasterIPUserIPPOMClass ip = new MasterIPUserIPPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		ip.clickoperatorSettingMenu();
		ip.clickUserIPTab();
		Thread.sleep(1000);
		ip.clickCheckbox();
		ip.clickDeleteUserIPButton();
		Thread.sleep(1000);
		ip.clickpopupDeleteButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Mass Delete User IP Added");
		soft.assertTrue(true,"Mass Delete User IP fails");
		soft.assertAll();
	}	
}
