package Assessment_Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPagePOM {
	

	WebDriver driver;
	
	public CheckoutPagePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	//checkout page1
	
	@FindBy(id="first-name")
	private WebElement firstnametf;
	
	@FindBy(id="last-name")
	private WebElement lastnametf;
	
	@FindBy(id="postal-code")
	private WebElement postalcodetf;
	
	@FindBy(id="continue")
	private WebElement continuebutton;
	
	
	//checkout page 2
	
	
	@FindBy(id="finish")
	private WebElement finishbutton;
	
	
	//checkout complete page 
	
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private WebElement confirmmsg;

	
	//getters
	
	public void getFirstnametf(String value) {
		firstnametf.sendKeys(value);
	}

	public void getLastnametf(String value) {
		lastnametf.sendKeys(value);
	}

	public void getPostalcodetf(String value) {
		postalcodetf.sendKeys(value);
	}

	public void getContinuebutton() {
		continuebutton.click();
	}

	public void getFinishbutton() {
		finishbutton.click();
	}

	public boolean getConfirmmsg() {
		return confirmmsg.isDisplayed();
	}
	
	

}
