package Last_Day_Assessment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmHomePage {
	
	WebDriver driver;
	public OrangeHrmHomePage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[text()='Buzz']")
	private WebElement buzzlink;
	
	@FindBy(css="[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement userdropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	
	//getter
	
	public void getBuzzlink()
	{
		buzzlink.click();
	}
	
	public void getUserdropdown() {
		userdropdown.click();
	}

	public void getLogoutbutton() {
		logoutbutton.click();
	}
}
