package TestClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.TestBaseClass;
import POMClasses.clientSettingPOMClass;
import UtilityClass.excelSheetCode;
import UtilityClass.screenshot;

public class CreateNewClientTestClass extends TestBaseClass
{
	public SoftAssert soft;
	
	@Test(enabled=true,priority=0)
	public void verifyAddNewClient() throws InterruptedException, IOException
	{
		clientSettingPOMClass cl = new clientSettingPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		cl.clickClientMenu();
		cl.clickAddNewButton();
		cl.selectCountry();
		cl.selectCurrency();
		cl.sendDomainName(1,3);
		cl.sendUserAgent(2,6);
		cl.selectPartnerName();
		cl.selectLanguage();
		cl.selectTimezone();
		cl.sendSubWebDomain(3,3);
		cl.clearTotalLimit();
		cl.sendTotalLimit(4,3);
		cl.clearWarningLimit();
		cl.sendWarningLimit(5,3);
		cl.selectTimeLimit();
		cl.selectTemplate();
		cl.selectsubTemplate();
		cl.selectLandAgentCheckBox();
		cl.selectIsExternalCheckBox();
		cl.clickSubmitButton();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"New Client Added");
		String expected = excelSheetCode.testData(driver,1,3);
		soft.assertEquals(cl.getDomainName(),expected,"Add New Client Functionality Fails");
		soft.assertAll();
	}
	
	@Test(enabled=true,priority=1)
	public void verifyEditClient() throws InterruptedException, IOException
	{
		clientSettingPOMClass cl = new clientSettingPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(1000);
		cl.clickClientMenu();
		cl.clickSearchButton();
	    cl.clickDomainName();
		Thread.sleep(1000);
		cl.clearDomainName();
		cl.sendDomainName(2,7);
		cl.clearSubWebDomainName();
		cl.sendSubWebDomain(2,8);
		cl.clearTotalLimit();
		cl.sendTotalLimit(4,4);
		cl.clearWarningLimit();
		cl.sendWarningLimit(5,4);
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Edit Client");
		cl.clickSubmitButton();
		Thread.sleep(2000);
		String expected = excelSheetCode.testData(driver,2,7);
		System.out.println(expected);
		System.out.println(cl.getDomainName());
		soft.assertEquals(cl.getDomainName(),expected,"Edit Client Functionality Fails");
		soft.assertAll();
	}

	@Test(enabled=true,priority=2)
	public void verifyAddNewClientWithNODATA() throws InterruptedException, IOException
	{
		clientSettingPOMClass cl = new clientSettingPOMClass(driver);
		soft =new SoftAssert();
//		Thread.sleep(2000);
		cl.clickClientMenu();
		cl.clickAddNewButton();
	    screenshot.ScreenShot(driver,"Create Client with no Data");
		cl.clickSubmitButton();
//		Thread.sleep(1000);
		soft.assertTrue(cl.getErrorMessage(),"fails");
		soft.assertAll();
		cl.clickCrossButton();
		
	}
	
	@Test(enabled=true,priority=3)
	public void verifyResetClientLimit() throws InterruptedException, IOException
	{
		clientSettingPOMClass cl = new clientSettingPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(2000);
		cl.clickClientMenu();
		cl.clickSearchButton();
	    cl.clickResetButton();
	    cl.clickYesButton();
		Thread.sleep(2000);
		screenshot.ScreenShot(driver,"Reset Client Limit");
		String expected = excelSheetCode.testData(driver,9,4);
		soft.assertEquals(cl.getAvailableLimit(),expected,"Reset Client Limit Functionality Fails");
		soft.assertAll();
	}
	
		@Test(enabled=true,priority=4)
	public void verifyEditClientAvailableLimit() throws InterruptedException, IOException
	{
		clientSettingPOMClass cl = new clientSettingPOMClass(driver);
		soft =new SoftAssert();
		Thread.sleep(2000);
		cl.clickClientMenu();
		cl.clickSearchButton();
		cl.clickeditButton();				
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"update available limit popup");
		cl.clickeditClientAmount();	
		screenshot.ScreenShot(driver,"New Client limit popup");
		cl.clearClientNewAmount();
		cl.sendClientNewAmount(6,3);
		cl.clickSubmitButton();
		cl.clickYesButton();
		Thread.sleep(1000);
		 cl.clickeditButton();
//			Thread.sleep(1000);
//			cl.clearAvailableNewAmount();
			Thread.sleep(1000);
			cl.sendAvailableLimitAmount(7,3);
			cl.clickSubmitButton();
			cl.clickYesButton();
			Thread.sleep(1000);
			screenshot.ScreenShot(driver,"Client Edit");
			String expected = excelSheetCode.testData(driver,9,3);
			soft.assertEquals(cl.getAvailableLimit(),expected,"Edit Available Limit Functionality Fails");
		String expected1 = excelSheetCode.testData(driver,10,3);
		soft.assertEquals(cl.getClientLimit(),expected1,"Edit Client Limit Functionality Fails");
		soft.assertAll();
	}

}
