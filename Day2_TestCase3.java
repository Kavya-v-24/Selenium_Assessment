package Assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Day2_TestCase3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to application
		driver.get("https://demowebshop.tricentis.com/");
		//identify 14.1 inch laptop
		driver.findElement(By.xpath("//img[@alt=\"Picture of 14.1-inch Laptop\"]")).click();
		//identify add to cart button
		WebElement cart = driver.findElement(By.id("add-to-cart-button-31"));
		//capture size of cart button
		System.out.println(cart.getSize());
		Thread.sleep(2000);
		//clicking on add to cart button
		cart.click();
		Thread.sleep(2000);
		//clicking on shopping cart link
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		//storing removecheckbox webelement in rcb
		WebElement rcb= driver.findElement(By.name("removefromcart"));
		//checking whether it is selected or not
		System.out.println(rcb.isSelected());
		//getting all rect of remove check box
		System.out.println(rcb.getRect().getHeight());
		System.out.println(rcb.getRect().getWidth());
		System.out.println(rcb.getRect().getX());
		System.out.println(rcb.getRect().getY());
		
		
		//identify alert message webelement and storing in a list
		List<WebElement> alerts = driver.findElements(By.xpath("//div[@class=\"message\"]"));
		//checking size of list if >0, print whether first alert message is displayed or not
		if(alerts.size()>0)
		{
			System.out.println(alerts.get(0).isDisplayed());
		}
		else
		{
			System.out.println("alert message is not displayed before clicking apply coupon");
		}
		
		
		//identify apply coupon button clicking on it
		  driver.findElement(By.name("applydiscountcouponcode")).click();
		
		//identify alert message and checking whether displaying or not
		System.out.println(driver.findElement(By.xpath("//div[@class=\"message\"]")).isDisplayed());
		
		
		//identify laptop img and taking laptop screenshot
		WebElement img = driver.findElement(By.xpath("(//img[@alt=\"Picture of 14.1-inch Laptop\"])[2]"));
		File src=img.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/laptop.png");
		FileHandler.copy(src, dest);
		
		
		driver.quit();

	}

}
