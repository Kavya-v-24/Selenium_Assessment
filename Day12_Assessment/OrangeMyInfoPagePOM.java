package Assesment_Day12;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class OrangeMyInfoPagePOM {
	
	WebDriver driver;
	
	public OrangeMyInfoPagePOM(WebDriver driver)
	{
			this.driver=driver;
			
			PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="firstName")
	private WebElement firstnametf;
	
	@FindBy(name="middleName")
	private WebElement middlenametf;
	
	@FindBy(name="lastName")
	private WebElement lastnametf;
	
	@FindBy(xpath="//label[text()='Employee Id']/../..//input")
	private WebElement empid;
	
	@FindBy(xpath="(//button[text()=' Save '])[1]")
	private WebElement savebutton;
	
	
	//getters

	public void  getFirstnametf(String value) throws InterruptedException {
		
		firstnametf.sendKeys(Keys.CONTROL,"a");
		firstnametf.sendKeys(Keys.BACK_SPACE);
		firstnametf.sendKeys(value);
	}

	public void getMiddlenametf(String value) throws InterruptedException {
		middlenametf.sendKeys(Keys.CONTROL,"a");
		middlenametf.sendKeys(Keys.BACK_SPACE);
		middlenametf.sendKeys(value);
	}

	public void getLastnametf(String value) throws InterruptedException {
		lastnametf.sendKeys(Keys.CONTROL,"a");
		lastnametf.sendKeys(Keys.BACK_SPACE);
		lastnametf.sendKeys(value);
	}

	public void getEmpid(String value) throws InterruptedException {
		
		 empid.sendKeys(Keys.CONTROL,"a");
		 empid.sendKeys(Keys.BACK_SPACE);
		 //Thread.sleep(2000);
		 empid.sendKeys(value);
	}
	
	public void getSavebutton()
	{
		savebutton.click();
	}
	
	public String getFirstname()
	{
		return firstnametf.getAttribute("value");
		
	}
	
	public void verification(String value)
	{
		Assert.assertEquals(getFirstname(), value);
		
	}
	
}
