package Assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		//maximize screen
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to application
		driver.get("https://www.saucedemo.com/");
		//entering username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//entering password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		//click on login button
		driver.findElement(By.id("login-button")).click();
		
		//scrolling to bottom of the page using javascript
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement lastele = driver.findElement(By.xpath("//div[@class=\"footer_copy\"]"));
		js.executeScript("arguments[0].scrollIntoView(true)",lastele);
		Thread.sleep(2000);
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/products-page.png");
       FileHandler.copy(src,dest);
       
       Thread.sleep(2000);
       driver.quit();
       }

}
