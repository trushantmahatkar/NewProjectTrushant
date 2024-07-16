package POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.screenshot;

public class HomePagePOMClass
{
	private WebDriver driver;
	private Actions act;
	public HomePagePOMClass(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
		act= new Actions(driver);
	}
	@FindBy(xpath="//div[@class='marquee']")
	private WebElement internalNews;
	
	public String get_News()
	{
		String news =internalNews.getText();
		return news;
	}
	public boolean verifyHeaderNews()
	{
		return internalNews.isDisplayed();
	}
	
	@FindBy(xpath="(//div[@class='d-flex'])[2]")
	private WebElement date_time;
	public String checkDateTime()
	{  
		return date_time.getText();
	}
	
	public boolean verifyDate_Time()
	{
		return date_time.isDisplayed();
	}
	
	@FindBy(xpath="//button[@class='btn header-item ']")
	private WebElement multilingual;
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement language;
	
	public void change_Language()
	{
		multilingual.click();
		act.moveToElement(language).perform();
		language.click();
	}
	public boolean verifyMultilingual()
	{
		return multilingual.isDisplayed();
	}
	
	@FindBy(xpath="//button[@id='page-header-user-dropdown']")
	private WebElement profileIcon;
	@FindBy(xpath="(//button[@class='dropdown-item'])[1]")
	private WebElement profile;
	@FindBy(xpath="//h5[@id='staticBackdropLabel']")
	private WebElement myProfile;
	@FindBy(xpath="//button[@class='btn-close']")
	private WebElement close;
	
	public void clickonProfileIcon() throws InterruptedException, IOException
	{
		profileIcon.click();
		profile.click();
		Thread.sleep(1000);
		screenshot.ScreenShot(driver,"Profile");
		close.click();
	}
	
	@FindBy(xpath="(//button[@class='dropdown-item'])[2]")
	private WebElement changePasswordSetting;
	@FindBy(xpath="//h5[@id='staticBackdropLabel']")
	private WebElement changePassword;
	@FindBy(xpath="//input[@placeholder='Current Password']")
	private WebElement currentPassword;
	@FindBy(xpath="//input[@placeholder='New Password']")
	private WebElement newPassword;
	@FindBy(xpath="//input[@placeholder='Confirm New Password']")
	private WebElement confirmNewPassword;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	
	public void clickonChangePasswordSetting() throws InterruptedException
	{
		profileIcon.click();
		changePasswordSetting.click();
		currentPassword.sendKeys("Test@123");
		newPassword.sendKeys("Test@123");
		confirmNewPassword.sendKeys("Test@123");
		submitButton.click();
	}
	
	@FindBy(xpath="//span[text()='The old password field is required.']")
	private WebElement errorCurrent;
	public void notpassingdataChangePasswordSetting() throws InterruptedException
	{
		profileIcon.click();
		changePasswordSetting.click();
		submitButton.click();
	}
	public String getCurrentError()
	{
		return errorCurrent.getText();
	}
	@FindBy(xpath="//span[text()='The new password field is required.']")
	private WebElement errorNew;
	
	public String getNewError()
	{
		return errorNew.getText();
	}
	
	@FindBy(xpath="//button[@class='btn-close']")
	private WebElement closeButton;
	
	public void clickChangePasswordCloseButton()
	{
		closeButton.click();
	}
	
	@FindBy(xpath="//span[text()='The new password confirmation does not match.']")
	private WebElement errorWrongPassword;
	public void wrongDataChangePasswordSetting() throws InterruptedException
	{
		profileIcon.click();
		changePasswordSetting.click();
		currentPassword.sendKeys("Test@1234");
		newPassword.sendKeys("Test@12");
		confirmNewPassword.sendKeys("Test@14");
		submitButton.click();
	}
	public String getWrongNewError()
	{
		return errorWrongPassword.getText();
	}
	
	@FindBy(xpath="(//button[@class='dropdown-item'])[3]")
	private WebElement logout;
	
	public void clickonLogout()
	{
		profileIcon.click();
		logout.click();
	}
	public String getURL()
	{ 
		return driver.getCurrentUrl();
	}
}
