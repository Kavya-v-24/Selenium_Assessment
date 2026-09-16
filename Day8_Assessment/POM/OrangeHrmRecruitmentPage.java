package Assessment_Day8;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmRecruitmentPage {
	
	WebDriver driver;

	
	public OrangeHrmRecruitmentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	//declare
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recuitlink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	@FindBy(name="firstName")
	private WebElement firstnametf;
	
	@FindBy(name="middleName")
	private WebElement middlenametf;
	
	@FindBy(name="lastName")
	private WebElement lastnametf;
	
	@FindBy(xpath="//div[@class=\"oxd-select-text--after\"]")
	private WebElement vacancydd;
	
	
	@FindBy(xpath="(//input[@placeholder=\"Type here\"])[1]")
	private WebElement emailtf;
	
	
	
	@FindBy(xpath="(//input[@placeholder=\"Type here\"])[2]")
	private WebElement contactnumtf;
	
	@FindBy(xpath="//input[@type=\"file\"]")
	private WebElement resumefile;
	
	@FindBy(xpath="//input[@placeholder=\"yyyy-dd-mm\"]")
	private WebElement dateofapplication;
	
	@FindBy(xpath=" //button[text()=' Save ']")
	private WebElement savebutton;

	
	
	//getter
	
	public void getRecuitlink() {
		recuitlink.click();
	}

	public void getAddbutton() {
		addbutton.click();
	}

	public void getFirstnametf(String value) {
		 firstnametf.sendKeys(value);
	}

	public void getMiddlenametf(String value) {
		middlenametf.sendKeys(value);
	}

	public void getLastnametf(String value) {
		lastnametf.sendKeys(value);
	}

	public void getVacancydd() throws AWTException {
		 vacancydd.click();
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
	}

	public void getEmailtf(String value) {
		 emailtf.sendKeys(value);
	}

	public void getContactnumtf(String value) {
		contactnumtf.sendKeys(value);
	}

	public void getResumefile(String value) {
		resumefile.sendKeys(value);
		
	}
	
	public void getDateofapplication() {
		dateofapplication.click();
	}

	public void getSavebutton() {
		savebutton.click();
	}
	
	

}
