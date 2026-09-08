package Assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
		
		//identify apply coupon button
		 WebElement coupon = driver.findElement(By.name("applydiscountcouponcode"));
		 //clicking on coupon button
		coupon.click();
		//identify alert message
		WebElement alert = driver.findElement(By.xpath("//div[@class=\"message\"]"));
		Thread.sleep(2000);
		//checking whether alert is displayed or not
		System.out.println(alert.isDisplayed());
		
		//identify laptop img and taking laptop screenshot
		WebElement img = driver.findElement(By.xpath("(//img[@alt=\"Picture of 14.1-inch Laptop\"])[2]"));
		File src=img.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/laptop.png");
		FileHandler.copy(src, dest);
		
		
		driver.quit();

	}

}
