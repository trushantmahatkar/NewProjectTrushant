package POMClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.excelSheetCode;

public class ReservedKeywordControlPinPOMClass
{
	public WebDriver driver;
	private Actions act; 
	public ReservedKeywordControlPinPOMClass(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
		act= new Actions(driver);
		
	}
	@FindBy(xpath="//span[text()='Player Settings']")
	private WebElement playerSettings;
	
	public void clickPlayerSettings()
	{
		playerSettings.click();
	}
	@FindBy(xpath="//a[text()='Reserved Keywords']")
	private WebElement reservedKeywords;
	
	public void clickReservedKeywords()
	{
		reservedKeywords.click();
	}
	@FindBy(xpath="//button[text()='Add New']")
	private WebElement addNewButton;
	
	public void clickAddNewButton()
	{
		addNewButton.click();
	}
	@FindBy(xpath="//input[@placeholder='Keyword']")
	private WebElement keyword;
	
	public void sendKeyword() throws IOException
	{
		keyword.sendKeys(excelSheetCode.testData(driver,0,0));
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submit;
	
	public void clickSubmitButton()
	{
		submit.click();
	}
	
	@FindBy(xpath="//tbody//tr[1]//td[2]")
	private WebElement entry;
	
	public String getAddedEntry()
	{
		return entry.getText();
	}
	
	@FindBy(xpath="//span[text()='The name field is required.']")
	private WebElement errorMessage1;
	
	public String getErrorMessage1()
	{
		return errorMessage1.getText();
	}

	@FindBy(xpath="//button[text()='Close']")
	private WebElement close;
	
	public void clickCloseButton()
	{
		close.click();
	}

	@FindBy(xpath="//tbody//tr[1]//td[3]//a")
	private WebElement delete;
	
	public void clickdeleteButton()
	{
		delete.click();
	}
	
	@FindBy(xpath="//button[text()='Delete Now']")
	private WebElement deleteNow;
	
	public void clickdeleteNowButton()
	{
		deleteNow.click();
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	
	public void searchTextboxReserve() throws IOException
	{
		search.sendKeys(excelSheetCode.testData(driver,0,0));
	}
	public void clearKeyword()
	{
		search.clear();
	}
	public void clearControl()
	{
		searchControl.clear();
	}
	
	@FindBy(xpath="//span[text()='The name has already been taken.']")
	private WebElement errorMessage2;
	
	public String getErrorMessage2()
	{
		return errorMessage2.getText();
	}
	
	@FindBy(xpath="//a[text()='Control Pin']")
	private WebElement controlPin;
	
	public void clickControlPin() throws IOException
	{
		controlPin.click();
	}
	
	@FindBy(xpath="//button[text()='Add New Pin']")
	private WebElement addNewPin;
	
	public void clickAddNewPin() throws IOException
	{
		addNewPin.click();
	}
	
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchControl;
	public void searchTextboxControl() throws IOException
	{
		int a = (int)excelSheetCode.testData1(driver,0,0);
		searchControl.sendKeys(Integer.toString(a));
	}
	
	
	@FindBy(xpath="//input[@name='pin']")
	private WebElement controlP;
	
	public void sendControlPin() throws IOException
	{
		int a = (int)excelSheetCode.testData1(driver,0,0);
		controlP.sendKeys(Integer.toString(a));
	}
	
	
	@FindBy(xpath="//span[text()='The pin has already been taken.']")
	private WebElement errorMessage3;
	
	public String getExistErrorMessage()
	{
		return errorMessage3.getText();
	}
	
	@FindBy(xpath="//tbody//tr[1]//td[3]")
	private WebElement pinEntry;
	
	public String getAddedPinEntry()
	{
		return pinEntry.getText();
	}
	
	@FindBy(xpath="//span[text()='The pin field is required.']")
	private WebElement emptyPinMessage;
	
	public String getEmptyPinErrorMessage()
	{
		return emptyPinMessage.getText();
	}
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	private List<WebElement> checkBox;
	
	public void clickMassCheckBox()
	{
		checkBox.get(0).click();
	}
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement massDeleteButton;
	
	public void clickMassDeleteButton() throws IOException
	{
		massDeleteButton.click();
	}
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement deleteButtonControlPin;
	
	public void clickDeleteButtonControlPin() throws IOException
	{
		deleteButtonControlPin.click();
	}
	
	
}
