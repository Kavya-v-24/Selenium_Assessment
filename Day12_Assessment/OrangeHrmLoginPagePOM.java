package Assesment_Day12;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLoginPagePOM {
	
	WebDriver driver;
	public OrangeHrmLoginPagePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="username")
	private WebElement usernametf;
	
	@FindBy(name="password")
	private WebElement passwordtf;
	
	@FindBy(xpath="//button[text()=' Login ']")
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
