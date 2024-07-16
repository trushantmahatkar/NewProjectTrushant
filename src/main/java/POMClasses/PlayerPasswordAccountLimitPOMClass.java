package POMClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityClass.excelSheetCode;

public class PlayerPasswordAccountLimitPOMClass 
{
	public WebDriver driver;
	private Select s ;
	private Actions act;
	public PlayerPasswordAccountLimitPOMClass(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);	
		
	}
	@FindBy(xpath="//a[@href='/player_settings']")
	private WebElement playerSettings;
			
	public void clickPlayerSettingsMenu()
	{
		playerSettings.click();
	}
	@FindBy(xpath="//a[text()='Player Password And Account Limit']")
	private WebElement PlayerPassAccTab;		
	public void clickPlayerPassAccTab()
	{
		PlayerPassAccTab.click();
	}
	@FindBy(xpath="//input[@name='Number Of Player Account Limit']")
	private WebElement sendPlayerPassAccLimit;
	public void sendPlayerPassAccLimit(int a, int b) throws IOException, InterruptedException
	{
		sendPlayerPassAccLimit.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendPlayerPassAccLimit.sendKeys(Integer.toString(d));
	}
	@FindBy(xpath="//input[@name='duration_password']")
	private WebElement sendDurationPassPlayer;
	public void sendDurationPassPlayer(int a, int b) throws IOException, InterruptedException
	{
		sendDurationPassPlayer.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendDurationPassPlayer.sendKeys(Integer.toString(d));
	}
	@FindBy(xpath="//input[@name='max_pwd_reset_count']")
	private WebElement sendMaxResetPass;
	public void sendMaxResetPass(int a, int b) throws IOException, InterruptedException
	{
		sendMaxResetPass.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendMaxResetPass.sendKeys(Integer.toString(d));
	}
	@FindBy(xpath="//input[@name='duration_reset']")
	private WebElement sendDurationReset;
	public void sendDurationReset(int a, int b) throws IOException, InterruptedException
	{
		sendDurationReset.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendDurationReset.sendKeys(Integer.toString(d));
	}
	@FindBy(xpath="//input[@name='next_reset']")
	private WebElement sendNextReset;
	public void sendNextReset(int a, int b) throws IOException, InterruptedException
	{
		sendNextReset.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendNextReset.sendKeys(Integer.toString(d));
	}
	@FindBy(xpath="//input[@name='next_reset_duration']")
	private WebElement sendNextResetDuration;
	public void sendNextResetDuration(int a, int b) throws IOException, InterruptedException
	{
		sendNextResetDuration.clear();
		Thread.sleep(500);
		int d = (int)excelSheetCode.testData1(driver,a,b);
		sendNextResetDuration.sendKeys(Integer.toString(d));
	}		
	public void clearExpiredPassAccLimit() throws InterruptedException
	{
		act = new Actions(driver);
		sendPlayerPassAccLimit.click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		sendDurationPassPlayer.click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
	}
	@FindBy(xpath="//strong[@class='text-danger']")		
	private List<WebElement> passErrorMessage;
	public boolean checkExpiredPassErrorMessage()
	{
		return passErrorMessage.get(0).isDisplayed();
	}
	@FindBy(xpath="//button[@class='btn btn-success']")		
	private List<WebElement> updateButton;
	
	public void clickExpiredPassUpdateButton()
	{
		System.out.println("before update click");
		updateButton.get(0).click(); 
		System.out.println("after update click");
	}
	@FindBy(xpath="//div[@role='textbox']")
	private List<WebElement> emailMessage;
	public void sendEmailMessage(int a, int b) throws IOException, InterruptedException
	{
		act = new Actions(driver);
		emailMessage.get(0).click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(500);
		emailMessage.get(0).sendKeys(excelSheetCode.testData(driver,a,b));
	}
	public void sendEmailVerificationMessage(int a, int b) throws IOException, InterruptedException
	{
		act = new Actions(driver);
		emailMessage.get(1).click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(500);
		emailMessage.get(1).sendKeys(excelSheetCode.testData(driver,a,b));
	}
	public void clearEmailMessage() throws InterruptedException
	{
		act = new Actions(driver);
		emailMessage.get(0).click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
	}
	public void clearEmailVerificationMessage() throws InterruptedException
	{
		act = new Actions(driver);
		emailMessage.get(1).click();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(500);
		act.sendKeys(Keys.BACK_SPACE).perform();
	}
	public void clickEmailUpdateButton()
	{
		updateButton.get(1).click();  
	}
	public void clickEmailVerificationUpdateButton()
	{
		updateButton.get(2).click();  
	}
}
