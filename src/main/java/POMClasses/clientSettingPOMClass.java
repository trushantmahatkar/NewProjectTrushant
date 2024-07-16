package POMClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityClass.excelSheetCode;

public class clientSettingPOMClass
{
	public WebDriver driver;
	private Select s ; 
	public clientSettingPOMClass(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath="//a[@href='/client']")
	private WebElement client;
	
	public void clickClientMenu()
	{
		client.click();
	}
	@FindBy(xpath="//button[@data-id='addClient']")
	private WebElement addNewButton;
	
	public void clickAddNewButton()
	{
		addNewButton.click();
	}
	@FindBy(xpath="(//select[@class='form-select form-select'])[1]")
	private WebElement countryDropdown ;
	
	public void selectCountry()
	{
		s =new Select(countryDropdown);
		s.selectByVisibleText("India");
	}
	@FindBy(xpath="(//select[@class='form-select form-select'])[2]")
	private WebElement currencyDropdown ;
	
	public void selectCurrency()
	{
		s =new Select(currencyDropdown);
		s.selectByVisibleText("Indian rupee");
	}
	@FindBy(xpath="(//select[@class='form-select form-select'])[3]")
	private WebElement languageDropdown ;
	
	public void selectLanguage()
	{
		s =new Select(languageDropdown);
		s.selectByVisibleText("English");
	}
	@FindBy(xpath="(//select[@class='form-select form-select'])[4]")
	private WebElement timezoneDropdown ;
	
	public void selectTimezone()
	{
		s =new Select(timezoneDropdown);
		s.selectByVisibleText("(UTC+05:30) Asia/Kolkata");
	}
	@FindBy(xpath="(//select[@class='form-select form-select'])[5]")
	private WebElement timeLimitDropdown ;
	
	public void selectTimeLimit()
	{
		s =new Select(timeLimitDropdown);
		s.selectByVisibleText("1 Month");
	}
	
	@FindBy(xpath="(//select[@class='form-select'])[1]")
	private WebElement partnerName ;
	
	public void selectPartnerName()
	{
		s =new Select(partnerName);
		s.selectByVisibleText("Partner_1");
	}
	@FindBy(xpath="(//select[@class='form-select'])[2]")
	private WebElement templateDropdown ;
	
	public void selectTemplate()
	{
		s =new Select(templateDropdown);
		s.selectByVisibleText("Temp02");
	}
	@FindBy(xpath="(//select[@class='form-select'])[3]")
	private WebElement subtemplateDropdown ;
	
	public void selectsubTemplate()
	{
		s =new Select(subtemplateDropdown);
		s.selectByVisibleText("Purple");
	}
	
	@FindBy(xpath="//input[@name='domain_name']")
	private WebElement domainName ;
	
	public void sendDomainName(int a,int b) throws IOException
	{
		domainName.sendKeys(excelSheetCode.testData(driver,a,b));
	}
	public void clearDomainName()
	{
		domainName.clear();
	}
	
	@FindBy(xpath="//input[@name='user_agent']")
	private WebElement userAgent ;
	
	public void sendUserAgent(int a, int b) throws IOException
	{
		userAgent.sendKeys(excelSheetCode.testData(driver,a,b));
	}
	@FindBy(xpath="//input[@name='sub_domain']")
	private WebElement subWebDomain ;
	
	public void sendSubWebDomain(int a, int b) throws IOException
	{
		subWebDomain.sendKeys(excelSheetCode.testData(driver,a,b));
	}
	public void clearSubWebDomainName()
	{
		subWebDomain.clear();
	}
	@FindBy(xpath="//input[@name='total_limit']")
	private WebElement totalLimit;
	public void sendTotalLimit(int x, int y) throws IOException
	{
		int d = (int)excelSheetCode.testData1(driver,x,y);
		totalLimit.sendKeys(Integer.toString(d));
		
	}
	public void clearTotalLimit()
	{
		totalLimit.clear();
	}
	@FindBy(xpath="//input[@name='warning_limit']")
	private WebElement warningLimit;
	public void sendWarningLimit(int a, int b) throws IOException
	{
		int c = (int)excelSheetCode.testData1(driver,a,b);
		warningLimit.sendKeys(Integer.toString(c));
	}
	public void clearWarningLimit()
	{
		warningLimit.clear();
	}
	@FindBy(xpath="//input[@name='land_agent_no']")
	private WebElement landAgentCheckBox;
	public void selectLandAgentCheckBox()
	{
		landAgentCheckBox.click();
	}
	@FindBy(xpath="//input[@name='is_external']")
	private WebElement isExternalCheckBox;
	public void selectIsExternalCheckBox()
	{
		isExternalCheckBox.click();
	}
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	@FindBy(xpath="//tbody//tr[1]//td[3]//a")
	private WebElement getDomainName;
	public String getDomainName()
	{
		return getDomainName.getText();
	}
    public void clickDomainName()
   {
    	getDomainName.click();
   }
    @FindBy(xpath="//span[@class='text-danger']")
	private List<WebElement> errorMessage;
	
	public Boolean getErrorMessage() throws IOException
	{
		ArrayList<String> memberNums = new ArrayList<String>();
		Boolean result=true;
//		int
		for(WebElement ele : errorMessage)
		{
			memberNums.add(ele.getText());	
		}
			for(int i=0;i<=memberNums.size()-1;i++)
				{
//				if(memberNums.get(i).equals(excelSheetCode.testData(driver,i,5))==true)
//				{
//					return true;
//				}
				result=memberNums.get(i).equals(excelSheetCode.testData(driver,i,5));
	
//					result = errorMessage.contains(excelSheetCode.testData(driver,i,5));
				}
//		}
//		for(int i=1;i<=15;i++)
//		{
//		
//			Boolean result =memberNums.contains(excelSheetCode.testData(driver,i,4));
//			return result;
//		}
//			else
//			{
//				return false;
//			}
			return result;
	}
	
//    public String getErrorMessage(int a)
//	{
//    	return errorMessage.get(a).getText();
//	}
	
	@FindBy(xpath="//button[@class='btn-close position-absolute end-0 top-0 m-2']")
	private WebElement crossButton;
	public void clickCrossButton()
	{
		crossButton.click();
	}	

	
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement searchButton;
	public void clickSearchButton()
	{
		searchButton.click();
	}	
	@FindBy(xpath="(//button[@class='btn btn-primary w-md'])[1]")
	private WebElement resetButton;
    public void clickResetButton()
	{
    	resetButton.click();
	}			 
    @FindBy(xpath="//button[text()='Yes']")
    private WebElement yesButton;
    public void clickYesButton()
    {
    	yesButton.click();
    }	
    @FindBy(xpath="(//button[@class='btn btn-primary w-md'])[2]")
    private WebElement editButton;
    public void clickeditButton()
   {
    	editButton.click();
   }	
    @FindBy(xpath="//tbody//tr[1]//td[5]//a")
    private WebElement editClientAmount;
    public void clickeditClientAmount()
   {
    	editClientAmount.click();
   }
    @FindBy(xpath="//input[@name='total_limit']")
    private WebElement enterClientNewAmount;
    public void clearClientNewAmount()
    {
    	enterClientNewAmount.clear();
    }
    public void sendClientNewAmount(int a, int b) throws IOException
   {
    	int c = (int)excelSheetCode.testData1(driver,a,b);
    	enterClientNewAmount.sendKeys(Integer.toString(c));
   }
    @FindBy(xpath="//tr[1]//td[6]")
    private WebElement getClientLimit;
    public String getClientLimit()
   {
    	return getClientLimit.getText();
   } 
  
    @FindBy(xpath="//input[@name='available_limit']")
    private WebElement enterAvailableLimitAmount;
    public void clearAvailableNewAmount()
    {
    	enterAvailableLimitAmount.clear();
    }
    public void sendAvailableLimitAmount(int a, int b) throws IOException
   {
    	int c = (int)excelSheetCode.testData1(driver,a,b);
    	enterAvailableLimitAmount.sendKeys(Integer.toString(c));
   }
    @FindBy(xpath="//tr[1]//td[7]")
    private WebElement getAvailableLimit;
    public String getAvailableLimit()
   {
    	return getAvailableLimit.getText();
   } 

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
