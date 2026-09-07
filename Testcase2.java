package Assessments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to application
		driver.navigate().to("https://www.myntra.com/");
		Thread.sleep(1000);
		//passing text to search text field
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("watch");
		Thread.sleep(2000);
		//storing suggestion in a list of webelement type
		List<WebElement> sugg = driver.findElements(By.cssSelector("[class='desktop-suggestion null']"));
		
		//for each loop to fetch each element and click on a particular element
		for(WebElement ele:sugg)
		{
			System.out.println(ele.getText());
			if(ele.getText().contains("Watches For Women"))
			{
				ele.click();
				break;
			}
		}
		
		//clicking on a particular product and adding to wishlist
		driver.findElement(By.xpath("//img[@title=\"French Connection Women Bracelet Style Straps Analogue Watch Gift Set FCB5NRGM\"]")).click();
		//driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
