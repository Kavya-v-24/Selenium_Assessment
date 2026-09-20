package Assesment_Day12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmRecruitmentPagePOM {
	
	WebDriver driver;
	Robot r;
	public OrangeHrmRecruitmentPagePOM(WebDriver driver) throws AWTException
	{
		this.driver=driver;
		r=new Robot();
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement vacancieslink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addbutton;
	
	@FindBy(xpath="(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]")
	private WebElement vacancydd;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement searchbutton;
	
	@FindBy(xpath="(//div[text()='Automation test engineer'])[2]")
	private WebElement record;
	
	
	public void getVacancieslink()
	{
		vacancieslink.click();
	}
	
	public void getAddbutton()
	{
		addbutton.click();
	}
	
	public void getVacancydd()
	{
		vacancydd.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void getSearchbutton()
	{
		searchbutton.click();
	}
	
	public String getrecord()
	{
		return record.getText();
	}

}
