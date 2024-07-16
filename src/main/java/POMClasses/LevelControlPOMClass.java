package POMClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.excelSheetCode;

public class LevelControlPOMClass
{
	public WebDriver driver;
	private Actions act; 
	public LevelControlPOMClass(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
		act= new Actions(driver);
		
	}
	@FindBy(xpath="//a[@href='/operator_setting']")
	private WebElement operatorSettings;
	
	public void clickOperatorSettings()
	{
		operatorSettings.click();
	}
	@FindBy(xpath="//button[text()='Add Level']")
	private WebElement addLevel;
	
	public void clickAddLevelButton()
	{
		addLevel.click();
	}
	@FindBy(xpath="//input[@name='name']")
	private WebElement levelName;
	
	public void sendLevelName(int a,int b) throws IOException
	{
		levelName.sendKeys(excelSheetCode.testData(driver,a,b));
	}
	
	@FindBy(xpath="//span[text()='The name has already been taken.']")
	private WebElement errorMessage1;
	
	public String getErrorMessage1()
	{
		return errorMessage1.getText();
	}
	
	@FindBy(xpath="//button[text()='Refresh']")
	private WebElement refresh;
	
	public void clickRefreshButton()
	{
		refresh.click();
	}
	
	@FindBy(xpath="//span[text()='The name field is required.']")
	private WebElement errorMessage2 ;
	
	public String getErrorMessage2()
	{
		return errorMessage2.getText();
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBox;
			
	public void clickCheckbox()
	{
		checkBox.get(1).click();
		checkBox.get(2).click();
		checkBox.get(12).click();
		checkBox.get(13).click();
		checkBox.get(19).click();
		checkBox.get(20).click();
		checkBox.get(33).click();
		checkBox.get(34).click();  
	}	
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	public void clickSaveButton()
	{
		save.click();
	}

	@FindBy(xpath="//tbody//tr[5]//td[2]")
	private WebElement addedLevelName;
	public String getLevel()
	{
		return addedLevelName.getText(); 
	}
	
	@FindBy(xpath="//button[text()='Back']")
	private WebElement back;
	public void clickBackButton()
	{
		back.click();
	}
	@FindBy(xpath="(//i[@class='bx bx-pencil h3 m-0 text-success'])[5]")
	private WebElement edit;
	public void clickeditLevel()
	{
		edit.click();
	}
		
	public void clickEditCheckbox()
	{
		checkBox.get(12).click();
		checkBox.get(13).click();
		checkBox.get(19).click();
		checkBox.get(20).click();
		checkBox.get(36).click();
		checkBox.get(37).click(); 
		checkBox.get(41).click();
		checkBox.get(42).click();
		checkBox.get(43).click();
		checkBox.get(44).click();
		checkBox.get(57).click();
		checkBox.get(58).click();
		checkBox.get(61).click();
		checkBox.get(62).click();	
	}

	@FindBy(xpath="//tbody//tr[5]//td[4]")
	private WebElement delete;
	public void clickDeleteButton()
	{
		delete.click();
	}
	
	@FindBy(xpath="//button[text()='Delete Now']")
	private WebElement deleteNow;
	public void clickDeleteNowButton()
	{
		deleteNow.click();
	}
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement close;
	public void clickCloseButton()
	{
		close.click();
	}
}
