package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	public static void main(String[] args) throws InterruptedException {
		//launch browser
		WebDriver driver=new ChromeDriver();
		
		//maximize
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		
		
		//identify toggle buttons and store in reference variable
		WebElement btn1 = driver.findElement(By.id("tog"));
	   WebElement btn2=driver.findElement(By.id("togg"));
		WebElement btn3 = driver.findElement(By.id("toggl"));
		WebElement btn4 = driver.findElement(By.id("toggler"));
		
		//place order button
		WebElement placebutton = driver.findElement(By.id("togglers"));
		
		//the button are disabled and hidden so we use javascriptexecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//removing disable tag and clicking on hidden element
		js.executeScript("arguments[0].removeAttribute('disabled');", btn1);//enabling disabled ele
		js.executeScript("arguments[0].click()", btn1);//clicking on hidden ele
		
		js.executeScript("arguments[0].removeAttribute('disabled');", btn2);
		js.executeScript("arguments[0].click()", btn2);
		
		js.executeScript("arguments[0].removeAttribute('disabled');", btn3);
		js.executeScript("arguments[0].click()", btn3);
		
		js.executeScript("arguments[0].removeAttribute('disabled');", btn4);
		js.executeScript("arguments[0].click()", btn4);
		
		Thread.sleep(2000);
		placebutton.click();//click on place button
		
		
		
		//verification (checking whether success message is displayed or not
		
		WebElement msg = driver.findElement(By.xpath("//p[text()='Your Order has been successfully placed!']"));
		if(msg.isDisplayed())
		{
			System.out.println(msg.getText());
		}
		else
		{
			System.out.println("failed to place the order");
		}
		
	Thread.sleep(2000);
	driver.quit();
	

	}
}
