package Assessment_Day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLoginpage {
	
	WebDriver driver;
	
	public OrangeHrmLoginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	//declare
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginbutton;
	
	//getter
	
	public void getUsername(String value) {
		username.sendKeys(value);
		}
	
	public void getPassword(String value)
	{
		password.sendKeys(value);
	}
	public void getLoginbutton()
	{
		loginbutton.click();
	}

}
