package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		//launch browser
		WebDriver driver=new ChromeDriver();
		
		//maximize
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to application
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		
		//identify laptop charger
		WebElement lcharger = driver.findElement(By.id("dragElement1"));
		
		//identify laptop cover
		WebElement lcover = driver.findElement(By.id("dragElement3"));
		
		//identify mobile cover
		WebElement mcover = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		
		//identify mobile charger
		WebElement mcharger = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		
		//targets
		
		//identify mobile accessories zone
		WebElement mobilezone = driver.findElement(By.id("dropZone1"));
		
		//identify laptop accessories zone
		WebElement laptopzone = driver.findElement(By.id("dropZone2"));
		Thread.sleep(1000);
		
		//actions class for drag and drop
		Actions a=new Actions(driver);
		
		//first click elements belong to laptop 
		lcharger.click();
		lcover.click();
		
		//drag and drop them laptop zone
		a.dragAndDrop(lcharger,laptopzone ).perform();
		
		// click elements belong to mobile 
		mcharger.click();
		mcover.click();
		
		//drag and drop them mobile zone
		a.dragAndDrop(mcover, mobilezone).perform();
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
