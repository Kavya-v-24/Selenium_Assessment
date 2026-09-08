package Assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_TestCase1 {

	public static void main(String[] args) {
		//launch the browser
		WebDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to application
		driver.get("https://www.facebook.com/");
		//click on create new account button
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		//identify first name text field
		WebElement fname = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		//get y offset of first name
		int fyoffset = fname.getRect().getY();
		//identify surname textfield
		WebElement sname = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		//get y offset of surname
		int syoffset = sname.getRect().getY();
		//printing first and surname y offset
		System.out.println(fyoffset);
		System.out.println(syoffset);
		//comparing both fields y offset
		if(fyoffset==syoffset)
		{
			System.out.println("Aligned in same line");
		}
		else
		{
			System.out.println("not aligned in a same line");
		}
		driver.quit();
		

	}

}
