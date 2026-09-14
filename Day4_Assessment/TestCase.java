/*
//Test case 

Login to orangeHrm application -> Click on PIM link -> click on +Add button ->enter firstname , middlename, lastname , 
employeeId -> click on Create Login Details toggle button -> enter username , password and confirm password 
-> click on save button
-> click on Admin link 
-> enter username , select role ,enter employee name and select status 
-> click on search button
->verify whether the emplyoee is added from the records found section and logout.
Note: store the common data in property file and testscript data in excel file.
 
 
 */

package Assesments;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day6_Tc1 {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		
		//fetching common data(login page data) from properties file and storing in reference variables
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/Day6_tc_commondata(login).properties");
		Properties p=new Properties();
		p.load(fis);
		
		//login credentials
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		

		//fetching webelement text fields data from excel sheet and storing in reference variable
		FileInputStream fis2= new FileInputStream("./src/test/resources/DDT/Day6_TC_EleData.xlsx");
		//fetching workbook
		Workbook wb=WorkbookFactory.create(fis2);

		//storing input data in reference variables
		String firstname = wb.getSheet("PIM").getRow(1).getCell(0).getStringCellValue();
		 String middlename = wb.getSheet("PIM").getRow(1).getCell(1).getStringCellValue();
		 String lastname = wb.getSheet("PIM").getRow(1).getCell(2).getStringCellValue();
		 String empid = String.valueOf((int)wb.getSheet("PIM").getRow(1).getCell(3).getNumericCellValue());
		 String PIMUN = wb.getSheet("PIM").getRow(1).getCell(4).getStringCellValue();
		 String PIMPASS= wb.getSheet("PIM").getRow(1).getCell(5).getStringCellValue();
		 String CPIMPASS = wb.getSheet("PIM").getRow(1).getCell(6).getStringCellValue();
		 
		
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
		 Thread.sleep(1000);
		 
		 
		 //identify PIM link and click
		 driver.findElement(By.xpath("//span[text()='PIM']")).click();
		 Thread.sleep(1000);
		
		 //identify add button and click PIM page
		 driver.findElement(By.xpath(" //button[text()=' Add ']")).click();
		Thread.sleep(2000);
		 
	
		 //identify first name,middle name, last name and enter text
		 driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys(firstname);
		 driver.findElement(By.name("middleName")).sendKeys(middlename);
		 driver.findElement(By.name("lastName")).sendKeys(lastname);
		 Thread.sleep(1000);
		 
		 //identify employee id and click
		 WebElement employeeid = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
		 employeeid.click();
		 
		 //clear employee id text field existing text(id) and enter user required id
		 employeeid.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		 employeeid.sendKeys(empid);
		 Thread.sleep(1000);
		 
		 
		 //identify and click on Create Login Details toggle button
	     driver.findElement(By.xpath("//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]")).click();
		 Thread.sleep(1000);

		 //identify username, password and confirm password text field and enter text
		 driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]")).sendKeys(PIMUN);
		 driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys(PIMPASS);
		 driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).sendKeys(CPIMPASS);
		 Thread.sleep(1000);
		 
		 //identify and click on save button
		 driver.findElement(By.xpath("//button[text()=' Save '] ")).click();
		 Thread.sleep(2000);
		 
		 //identify and click on Admin link
		 driver.findElement(By.xpath("//span[text()='Admin']")).click();
		 
		 //identify username text field and enter user name 
		 driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys(PIMUN);
		 
		 //identify employee role dropdown  and click
		 WebElement role = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]"));
		 role.click();
		 Thread.sleep(1000);
		
		 //create object for robot class to select the option from role dropdown and select Admin role
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 
		 
		 //identify employee name text field and enter text and select employee from dynamic dropdown using keys class
		 WebElement ename = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
	     ename.sendKeys(PIMUN);
	     Thread.sleep(3000);
		 ename.sendKeys(Keys.ARROW_DOWN);
		 ename.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
		
		 //identify status dropdown and click 
        WebElement status = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]"));
        status.click();
        //select enable option using robot class
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        
        //identify search button and click
        WebElement search = driver.findElement(By.xpath("//button[text()=' Search ']"));
        search.click();
        Thread.sleep(2000);
		 
        
        //verification (whether record found or not)
        
        //if record not found is displayed 
       
       if(driver.findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed())
       {
    	   
    	   //again click on role and select ESS
    	   role.click();
    	   r.keyPress(KeyEvent.VK_DOWN);
           r.keyRelease(KeyEvent.VK_DOWN);
           r.keyPress(KeyEvent.VK_DOWN);
           r.keyRelease(KeyEvent.VK_DOWN);
           r.keyPress(KeyEvent.VK_ENTER);
           r.keyRelease(KeyEvent.VK_ENTER);
           Thread.sleep(1000);
           
           //again click on search button
           search.click();
           
           //if record found print record found
           System.out.println("Record found");
           
       }
       
       //else print not found
       else
       {
    	   System.out.println("Record not found");
       }
		 
		
       Thread.sleep(2000);
       //log out 
       //identify user dropdown and click and click on logout 
       driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
       driver.findElement(By.xpath("//a[text()='Logout']")).click();
		 
		 Thread.sleep(2000);
		 driver.quit();
		 
	}

}
