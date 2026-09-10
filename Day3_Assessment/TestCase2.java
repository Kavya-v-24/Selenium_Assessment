/*
 * 
1.NAvigate to demo app qspiders date picker---  (https://demoapps.qspiders.com/ui/datePick?sublist=0)
2.Click on calender.
3. Navigate to the next month in the current year.
4. Select any valid date from that month.
5. Verify that the selected date is displayed correctly in the date field.

*/


package Assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		        //launch the browser
				WebDriver driver=new ChromeDriver();
				//maximize
				driver.manage().window().maximize();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//navigate to application
				driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
				
				//click on calender
				driver.findElement(By.cssSelector("[placeholder='Select A Date']")).click();
				Thread.sleep(2000);
				//go to next month in same year
				driver.findElement(By.xpath("//button[@aria-label=\"Next Month\"]")).click();
				
				//select valid date
				driver.findElement(By.xpath("//div[text()=20]")).click();
				
				//verification whether selected date is displayed or not
				System.out.print("Selected date is displayed: ");
				System.out.println(driver.findElement(By.cssSelector("[value='20/10/2026']")).isDisplayed());
				
				Thread.sleep(3000);
				driver.quit();

	}

}
