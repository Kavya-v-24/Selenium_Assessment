package LastDay_Assessment;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase4 {

	public static void main(String[] args) throws InterruptedException {
		        //launch browser
				WebDriver driver=new ChromeDriver();
				
				//maximize
				driver.manage().window().maximize();
				
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//navigate to application
				driver.get("https://shoppersstack.com/");
				Thread.sleep(2000);
				
				
				//identify and click on a product
				driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/61BGE6iu4AL._AC_UY218_.jpg\"]")).click();

				//identify and enter a pin to check delivery text field
				driver.findElement(By.id("Check Delivery")).sendKeys("583106");
				Thread.sleep(1000);
				
				//identify whether check button is enabled for that pin code
				WebElement checkbutton = driver.findElement(By.id("Check"));
				
				//explicit wait to check for check button to enable
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(checkbutton));
				
				//after enable click
				checkbutton.click();
				
				//verification
				
				String msg = driver.findElement(By.id("Check Delivery-helper-text")).getText();
				
				if(msg.contains("Not Deliveriable."))
				{
					System.out.println("the selected product is not  available to pincode");
					
				}
				
				else 
				{
					System.out.println("the selected product is  available to pincode");
				}
				
				Thread.sleep(2000);
				driver.quit();
	}

}
