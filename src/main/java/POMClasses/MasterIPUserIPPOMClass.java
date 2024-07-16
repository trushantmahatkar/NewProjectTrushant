package POMClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityClass.excelSheetCode;

public class MasterIPUserIPPOMClass 
{
	
		public WebDriver driver;
		private Select s ; 
		public MasterIPUserIPPOMClass(WebDriver driver)
		{
			this.driver =driver;
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(xpath="//a[@href='/operator_setting']")
		private WebElement operatorSetting;
		
		public void clickoperatorSettingMenu()
		{
			operatorSetting.click();
		}
		@FindBy(xpath="//a[text()='Master IP']")
		private WebElement masterIP;
		
		public void clickMasterIPTab()
		{
			masterIP.click();
		}
		@FindBy(xpath="(//button[@class='btn btn-success w-md'])[1]")
		private WebElement addIP ;
		public void clickAddIPButton()
		{
			addIP.click();
		}
		@FindBy(xpath="//input[@name='ip_address']")
		private WebElement textboxIP ;
		public void sendIP(int a, int b) throws IOException
		{
			textboxIP.sendKeys(excelSheetCode.testData(driver,a,b));
		}
		@FindBy(xpath="//button[text()='Submit']")
		private WebElement submit ;
		public void clickSubmitButton()
		{
			submit.click();
		}
		@FindBy(xpath="(//tbody[1]//tr[1]//td[2])[1]")
		private WebElement getMasterIP ;
		public String getMasterIP()
		{
			return getMasterIP.getText();
		}	
		@FindBy(xpath="//span[@class='text-danger']")
		private WebElement errormessage ;
		public boolean checkError()
		{
			return errormessage.isDisplayed();
		}
		@FindBy(xpath="//button[text()='Close']")
		private WebElement close ;
		public void clickCloseButton()
		{
			close.click();
		}
		@FindBy(xpath="(//a[@class='text-dark'])[1]")
		private WebElement deleteIP ;
		public void clickDeleteIpButton()
		{
			deleteIP.click();
		}
		@FindBy(xpath="//button[text()='Delete']")
		private WebElement deleteButtonIP;
		public void clickDeleteButton()
		{
			deleteButtonIP.click();
		}
		@FindBy(xpath="//input[@name='choose_operator']")
		private WebElement selectOperator ;
		public void clickSelectOperator()
		{
			selectOperator.click();
		}
		@FindBy(xpath="//a[text()='User IP']")
		private WebElement userIP;
		
		public void clickUserIPTab()
		{
			userIP.click();
		}	
		
		@FindBy(xpath="//input[@placeholder='User IP']")
		private WebElement textboxUserIP ;
		public void sendUserIP(int a, int b) throws IOException
		{
			textboxUserIP.sendKeys(excelSheetCode.testData(driver,a,b));
		}
		
		@FindBy(xpath="(//input[@name='remark'])[last()]")
		private WebElement remarkPop;
		
		public void sendRemark(int a, int b) throws IOException
		{
			remarkPop.sendKeys(excelSheetCode.testData(driver,a,b));
		}
		@FindBy(xpath="//input[@type='checkbox']")
		private List<WebElement> checkBox;
				
		public void clickCheckbox()
		{
			checkBox.get(1).click();
			checkBox.get(2).click();  
		}
		@FindBy(xpath="//button[@class='btn btn-danger']")
		private WebElement popupDeleteButton;
		
		public void clickpopupDeleteButton()
		{
			popupDeleteButton.click();
		}
		
		@FindBy(xpath="(//button[@class='btn btn-success w-md'])[2]")
		private WebElement updateButton;
		
		public void clickUpdateButton()
		{
			updateButton.click();
		}
		@FindBy(xpath="//input[@name='ip_address']")
		private List<WebElement> userIPTextBoxes;
		
		public void sendUpdatedUserIP1(int a,int b) throws IOException, InterruptedException
		{
			userIPTextBoxes.get(0).clear();
			userIPTextBoxes.get(0).sendKeys(excelSheetCode.testData(driver,a,b));
		}
		public void sendUpdatedUserIP2(int a,int b) throws IOException, InterruptedException
		{
			userIPTextBoxes.get(1).clear();
			userIPTextBoxes.get(1).sendKeys(excelSheetCode.testData(driver,a,b));
		}
		@FindBy(xpath="//input[@name='remark']")
		private List<WebElement> remarkTextBoxes;
		public void sendUpdatedRemark1(int a,int b) throws IOException, InterruptedException
		{
			remarkTextBoxes.get(0).clear();
			remarkTextBoxes.get(0).sendKeys(excelSheetCode.testData(driver,a,b));
		}
		public void sendUpdatedRemark2(int a,int b) throws IOException, InterruptedException
		{
			remarkTextBoxes.get(1).clear();
			remarkTextBoxes.get(1).sendKeys(excelSheetCode.testData(driver,a,b));
		}
		@FindBy(xpath="//button[@class='btn btn-success']")
		private WebElement SubmitButton;
		public void clickPopUpSubmitButton()
		{
			SubmitButton.click();
		}
		@FindBy(xpath="(//button[@class='btn btn-danger w-md'])[1]")
		private WebElement deleteUserIPButton;
		
		public void clickDeleteUserIPButton()
		{
			deleteUserIPButton.click();
		}
		@FindBy(xpath="(//input[@class='form-control'])[1]")
		private WebElement searchTextBox;
		
		public void sendUserIPSearch(int a, int b) throws IOException
		{
			searchTextBox.sendKeys(excelSheetCode.testData(driver,a,b));
		}
		@FindBy(xpath="//button[@class='btn btn-primary']")
		private WebElement searchButton;
		
		public void clickSearchButton()
		{
			searchButton.click();
		}
		public void clearSearchBox()
		{
			searchTextBox.clear();
		}


}
