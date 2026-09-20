package Assesment_Day12;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrangeHrmAddVacanciesPagePOM {
	
	WebDriver driver;
	
	Robot r;
	public OrangeHrmAddVacanciesPagePOM(WebDriver driver) throws AWTException
	{
		this.driver=driver;
		
	    r=new Robot();
		PageFactory.initElements( driver,this);
		
	}

	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	private WebElement vacancynametf;
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]")
	private WebElement jobtitledd;
	
	@FindBy(css = "[placeholder='Type description here']")
	private WebElement descriptiontf;
	
	@FindBy(css = "[placeholder='Type for hints...']")
	private WebElement hiringmanagertf;
	
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[3]")
	private WebElement Numofpositionstf;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement savebutton;
	
	
	//getters
	
	
	public void getVacancynametf(String value) {
		vacancynametf.sendKeys(value);
	}

	public void getJobtitledd()  {
		jobtitledd.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public void getDescriptiontf(String value) {
		descriptiontf.sendKeys(value);
	}

	public void getHiringmanagertf(String value) throws InterruptedException {
		hiringmanagertf.sendKeys(value);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

	}

	public void getNumofpositionstf(String value) {
		Numofpositionstf.sendKeys(value);
	}

	public void getSavebutton() {
		savebutton.click();
	}
	
	
	
	
	
	
	
}
