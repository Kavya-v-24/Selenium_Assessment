package Assesment_Day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmHomePagePOM {
	
	WebDriver driver;
	public OrangeHrmHomePagePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recruitmentlink;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myinfolink;
	
	@FindBy(css="[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement userdropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	
	public void getRecruitmentlink() {
		recruitmentlink.click();
	}

	public void getMyinfolink() {
		myinfolink.click();
	}

	public void getUserdropdown() {
		userdropdown.click();
	}

	public void getLogoutbutton() {
		logoutbutton.click();
	}
	
	
	
}
