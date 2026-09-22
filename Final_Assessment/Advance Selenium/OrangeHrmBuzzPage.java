package Last_Day_Assessment2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmBuzzPage {
	
	WebDriver driver;
	public OrangeHrmBuzzPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//textarea[@placeholder=\"What's on your mind?\"]")
	private WebElement whatinmindtf;
	
	@FindBy(xpath="//button[text()=' Post ']")
	private WebElement postbutton;
	
	@FindBy(xpath="(//p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-body-text\"])[1]")
	private WebElement verifypost;
	
	//getters
	
	public void getWhatinmind(String value)
	{
		whatinmindtf.sendKeys(value);
	}
	
	public void getPostbutton()

	{
		postbutton.click();
	}
	
	public void getVerifypost(String value)
	{
		boolean postmsg = driver.findElement(By.xpath("//button[text()=' Most Recent Posts ']/../..//p[text()='"+value+"']")).isDisplayed();
		Assert.assertTrue(postmsg);
		System.out.println("posted successfully");
	}
	
}
