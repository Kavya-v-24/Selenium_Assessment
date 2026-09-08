package Assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		        //launch the browser
				WebDriver driver=new ChromeDriver();
				//maximize
				driver.manage().window().maximize();
				//implicit time
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//navigate to application
				driver.get("https://www.facebook.com/");
				//identify create new account button
				WebElement button = driver.findElement(By.xpath("//span[text()='Create new account']"));
				//location of button
				System.out.println("create new account button location "+button.getLocation());
				//identify the email text field
				WebElement email = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
				//domAttribute and domProperty for email text field before entering email
				System.out.println(email.getDomAttribute("value"));
				System.out.println(email.getDomProperty("value"));
				Thread.sleep(1000);
				
				email.sendKeys("kavya@gmail.com");
				
				//domAttribute and domProperty for email text field after entering email
				System.out.println(email.getDomAttribute("value"));
				System.out.println(email.getDomProperty("value"));
				
				button.click();
				WebElement submitbt = driver.findElement(By.xpath("(//div[@role=\"button\"])[4]"));
				//getting size of submit button
				System.out.println(submitbt.getSize());
				//3 css properties of submit button
				System.out.println(submitbt.getCssValue("width"));
				System.out.println(submitbt.getCssValue("font-family"));
				System.out.println(submitbt.getCssValue("font-size"));
				
				driver.quit();

	}

}
