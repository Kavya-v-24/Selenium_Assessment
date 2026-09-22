package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		        //launch browser
				WebDriver driver=new ChromeDriver();
				
				//maximize
				driver.manage().window().maximize();
				
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//navigate to application
				driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
				Thread.sleep(2000);
				
				//identify slidebar 
				WebElement slidebar = driver.findElement(By.xpath("//input[@value=\"40\"]"));
				
				//slide till mens cooton jeans
				slidebar.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);
				
				//veification 
				
				WebElement target = driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']"));
				
				if(target.isDisplayed())
				{
					System.out.println("slided till "+target.getText());
				}
				else
				{
					System.out.println("failed to slide");
				}
				
				Thread.sleep(2000);
				driver.quit();
				
	}

}
