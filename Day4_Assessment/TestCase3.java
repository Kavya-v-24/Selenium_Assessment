package Assessments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		
		//maximize
		driver.manage().window().maximize();
		
		//implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://www.bigbasket.com/pb/boss/");
		
		//identify search text field and pass text
		 driver.findElement(By.xpath("(//input[@placeholder=\"Search for Products...\"])[2]")).sendKeys("apple");
		
		 //storing suggestions in a list
		List<WebElement> sugg = driver.findElements(By.xpath("//ul[@class=\"overscroll-contain\"]/li"));
		Thread.sleep(2000);
		
		//for each loop to fetch each element
		for(WebElement apple:sugg)
		{
			//fetching the suggestion text and store in a string type reference variable
			String text=apple.getText();
			
			//check for required product by comparing the text
			if(text.contains("Apple - Red Delicious, Regular"))
				{
				
				//adding the product to the cart
				apple.findElement(By.xpath(".//button[text()='Add']")).click();
				
				//verification
				
				//identify successfully add to cart popup and check whether dispalyed or not
				WebElement added = driver.findElement(By.xpath("//p[text()='Item has been added to your basket successfully']"));
				
				if(added.isDisplayed())
				{
					System.out.println("successfully added to cart");
					break;
				}
				else
				{
					System.out.println("failed to add to cart");
					break;
				}
				}
		}
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
