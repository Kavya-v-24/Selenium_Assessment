package Assessment_Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOM {
	
	WebDriver driver;
	
	public CartPagePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath="//div[text()='1']")
	private WebElement cartquantity;
	
	@FindBy(id="item_4_title_link")
	private WebElement backpack;
	
	@FindBy(id="checkout")
	private WebElement checkoutbutton;

	
	//getters
	
	public String getCartquantity() {
		return cartquantity.getText();
	}

	public boolean getBackpack() {
		  return backpack.isDisplayed();
	}

	public void getCheckoutbutton() {
		checkoutbutton.click();
	}
	
	
	
	
}
