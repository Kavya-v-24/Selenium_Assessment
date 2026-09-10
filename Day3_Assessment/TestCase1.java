package Assessments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day3_TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		//launch the browser
		WebDriver driver=new ChromeDriver(option);
		
		//maximize
		driver.manage().window().maximize();
		
		//implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://www.easemytrip.com/");
		
		//select one way
		driver.findElement(By.id("oway")).click();
		
		//enter state in the from field
		driver.findElement(By.id("frmcity")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("hyderabad");
		
		//select valid suggestion
		driver.findElement(By.id("spnHyderabad")).click();
		
		//enter state in to field
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("bangalore");
		
		//select valid suggestion
		driver.findElement(By.id("spnBengaluru")).click();
		
		//click departure date field
		driver.findElement(By.id("frth_0_18/10/2026")).click();
		
		//click traveller & class field
		driver.findElement(By.id("myFunction4")).click();
		
		//select 2 adults and keep class as economy
		driver.findElement(By.id("add")).click();
		
		//click search
		driver.findElement(By.id("divSearchFlight")).click();
		Thread.sleep(2000);
		
		//verify flight result page is displayed or not
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com"))
		{
			System.out.println("result page is successfully displayed");
		}
		else
		{
			System.out.println("Result page is not found!");
		}
		
		
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
