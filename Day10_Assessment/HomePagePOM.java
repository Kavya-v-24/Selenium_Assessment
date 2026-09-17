package Assessment_Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	WebDriver driver;

	 public HomePagePOM(WebDriver driver) 
		
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	 
	 @FindBy(id="add-to-cart-sauce-labs-backpack")
	 private WebElement backpackaddtocart;
	 
	 @FindBy(id="shopping_cart_container")
	 private WebElement cartbutton;
	 
	 public void getBackPackaddtocart()
	 {
		 backpackaddtocart.click();
	 }
	 
	 public void getCartbutton()
	 {
		 cartbutton.click();
	 }
	 

}