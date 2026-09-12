/*

Testcase 2 

1.Navigate to orange Hrm application
2.Enter the username password and click on login button
   by reading the data from excel file.
 
 */

package Assesments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Day5_Tc2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		//reading data from excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/orangehrm.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		//excel file data is fetched and storing in reference variables
		String browser = wb.getSheet("login_page").getRow(1).getCell(0).getStringCellValue();
		String url = wb.getSheet("login_page").getRow(1).getCell(1).getStringCellValue();
		String username = wb.getSheet("login_page").getRow(1).getCell(2).getStringCellValue();
		String password = wb.getSheet("login_page").getRow(1).getCell(3).getStringCellValue();
		
		//launch the browser
		 WebDriver driver=null;
		 
		 if(browser.contains("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 
		 if(browser.contains("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 if(browser.contains("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		
		//maximize the window
		 driver.manage().window().maximize();
		 
		 //Implicit wait time
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //navigate to application
		 driver.get(url);
		 
		 ///identify email text field and enter email and move to password text field and enter password (using reference variables)
		 driver.findElement(By.name("username")).sendKeys(username,Keys.TAB,password);
		 
		 //identify login button and click 
		 driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		 
		
		Thread.sleep(3000);
		driver.quit();

	}

}
