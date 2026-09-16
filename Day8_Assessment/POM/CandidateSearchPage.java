package Assessment_Day8;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidateSearchPage {
	WebDriver driver;
	Actions a;
	
	public CandidateSearchPage(WebDriver driver)
	{
		this.driver=driver;
		a=new Actions(driver);
		PageFactory.initElements( driver,this);
	}
	

	@FindBy(xpath="//a[text()='Candidates']")
	private WebElement candidatelink;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]")
	private WebElement jobtitledd;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text oxd-select-text--active\"])[2]")
	private WebElement vacancy;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text oxd-select-text--active\"])[3]")
	private WebElement hiringmanager;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text oxd-select-text--active\"])[4]")
	private WebElement status;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	private WebElement candidatename;
	
	@FindBy(xpath="//input[@placeholder=\"From\"]")
	private WebElement fromdate;
	
	@FindBy(xpath="//input[@placeholder=\"To\"]")
	private WebElement todate;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text oxd-select-text--active\"])[5]")
	private WebElement methofapp;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//span[text()='(1) Record Found']")
	private WebElement recordfound;

	public void getCandidatelink() {
		 candidatelink.click();
	}

	public void getJobtitledd() {
		
		a.click(jobtitledd).sendKeys(Keys.DOWN,Keys.ENTER).perform();
	}

	public void getVacancy() {
		a.click(vacancy).sendKeys(Keys.DOWN,Keys.ENTER).perform();
	}

	public void getHiringmanager() {
		a.click(hiringmanager).sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER).perform();
	}

	public void getStatus() {
		a.click(status).sendKeys(Keys.DOWN,Keys.ENTER).perform();
	}

	public void  getCandidatename(String value) throws InterruptedException {
		candidatename.sendKeys(value);
		Thread.sleep(4000);
		candidatename.sendKeys(Keys.DOWN,Keys.ENTER);
	}

	public void getFromdate(String value) {
		fromdate.sendKeys(value);
	}

	public void getTodate(String value) {
		todate.sendKeys(value);
	}
	
	public void getMethodofapp()
	{
		a.click(methofapp).sendKeys(Keys.DOWN,Keys.ENTER).perform();
	}
	
	public void getSearchbutton() 
	{
		searchbutton.click();
		
	}
	
	public void getRecordfound()
	{
		if(recordfound.isDisplayed())
		{
			System.out.println("record found");
		}
		else
		{
			System.out.println("Not found!");
		}
	}
	
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	private WebElement userdd;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public void getUserdd()
	{
		userdd.click();
	}
	
	public void getLogout()
	{
		logout.click();
	}
	

}
