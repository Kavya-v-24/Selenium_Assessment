package Assessments;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://www.zomato.com/bangalore/delivery");
		
		//click on login button
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//identify frame and switch using webelement
		WebElement loginframe = driver.findElement(By.id("auth-login-ui"));
		driver.switchTo().frame(loginframe);
		Thread.sleep(2000);
		
		//identify phone number text field and pass number
		driver.findElement(By.xpath("//input[@placeholder=\"Phone\"]")).sendKeys("9658974512");
		
		
		//click on cross button
		//driver.findElement(By.xpath("//i[@class=\"sc-rbbb40-1 cLEXmC sc-re4bd0-1 bKymEa\"]")).click();
		
		//switch to main page
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//verification that switched to main page by printing some text of main page to console
		System.out.println(driver.findElement(By.xpath("//div[text()='Delivery']")).getText());
		
		Thread.sleep(2000);
		driver.quit();

	}

}
