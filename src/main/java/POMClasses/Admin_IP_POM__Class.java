package POMClasses;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityClass.excelSheetCode;

public class Admin_IP_POM__Class 
{
	public WebDriver driver;
	private Select s ;
	private Actions act;
	public Admin_IP_POM__Class(WebDriver driver)
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
	@FindBy(xpath="//a[text()='Admin IP']")
	private WebElement adminIP;
	
	public void clickAdminIPTab()
	{
		adminIP.click();
	}
	@FindBy(xpath="(//div[@class=' css-19bb58m'])[2]")
	private WebElement clientDropDown;
	public void clickClientDropdownButton()
	{
		clientDropDown.click();
	}
	@FindBy(xpath="//input[@id='react-select-5-input']")
	private WebElement sendclient;
	public void sendClientDropdown(int a, int b) throws IOException
	{
		sendclient.sendKeys(excelSheetCode.testData(driver,a,b));
		act = new Actions(driver);	
		act.sendKeys(Keys.ENTER).perform();
	}
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement search;
	
	public void clickSearchButton()
	{
		search.click();
	}
	@FindBy(xpath="//button[@class='btn btn-success w-md']")
	private WebElement addNewButton;
	public void clickAddNewButton()
	{
		addNewButton.click();
	}
	@FindBy(xpath="//input[@name='ip_address']")
	private WebElement sendAdminIP;
	public void sendAdminIP(int a, int b) throws IOException
	{
		sendAdminIP.sendKeys(excelSheetCode.testData(driver,a,b));
	}
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
	private WebElement submitButton;
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	@FindBy(xpath="//tbody//tr[1]//td[2]")
	private WebElement getAdminIP ;
	public String getMasterIP()
	{
		return getAdminIP.getText();
	}
	@FindBy(xpath="//span[@class='text-danger']")
	private WebElement errormessage ;
	public boolean checkError()
	{
		return errormessage.isDisplayed();
	}
	@FindBy(xpath="//button[@class='btn btn-light']")
	private WebElement closeButton;
	public void clickCloseButton()
	{
		closeButton.click();
	}
	@FindBy(xpath="(//i[@class='bx bx-trash h3 m-0 text-danger'])[1]")
	private WebElement deleteButton;
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement deletePopUpButton;
	public void clickDeletePopupButton()
	{
		deletePopUpButton.click();
	}
	
	
			
}
