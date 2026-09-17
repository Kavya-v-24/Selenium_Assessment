package Assessment_Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
	
	WebDriver driver;
	
	public LoginPagePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(id="user-name")
	private WebElement usernametf;
	
	@FindBy(id="password")
	private WebElement passwordtf;
	
	@FindBy(id="login-button")
	private WebElement loginbutton;

	
	//getters
	public void getUsernametf(String value) {
		usernametf.sendKeys(value);
	}

	public void getPasswordtf(String value) {
		passwordtf.sendKeys(value);
	}

	public void getLoginbutton() {
		loginbutton.click();
	}
	
	
}
