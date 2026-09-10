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
		
		//implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://www.instagram.com/");
		
		//identify no of text fields using tagname and storing in a list
		//List<WebElement> textfield = driver.findElements(By.xpath("//input[@dir=\"ltr\"]"));
		List<WebElement> textfield = driver.findElements(By.tagName("input"));
		
		//finding no of text fields and printing the count
		int count=textfield.size();
		System.out.println(count);
		
		// passing text to one of the text field
		//fetching each text field using for each loop
		for(WebElement text:textfield)
		{
			//printing size of each text field
			System.out.println(text.getSize());
			
			//passing the text to email text field using getAttribute method
			if(text.getAttribute("name").equals("email"))
					{
				text.sendKeys("hello");
					}		
		}
		
		Thread.sleep(2000);
		driver.quit();	
		
	}

}
