/*
Test- case  1 

1.Navigate to DemoWebshop application 
2.Click on login link .
3.Enter email and password and click on login button by reading the data from property file.


 */

package Assesments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5_Tc1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//reading the data from the properties file
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/demoshopdata.properties");
		Properties p=new Properties();
		p.load(fis);
		
		//data in property file are fetched and storing in a reference variables
		 String browser = p.getProperty("browser");
		 String url = p.getProperty("url");
		 String email = p.getProperty("email");
		 String password = p.getProperty("password");
		 
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
		 
		 //identify login button and click on login button
		 driver.findElement(By.xpath("//a[text()='Log in']")).click();
		 
		 //identify email text field and enter email and move to password text field and enter password (using reference variables)
		 driver.findElement(By.id("Email")).sendKeys(email,Keys.TAB,password);
		 
		 //driver.findElement(By.id("Password")).sendKeys(password);
		 
		 //identify login button and click
		 driver.findElement(By.cssSelector("[value='Log in']")).click();
		 Thread.sleep(2000);
		
		 
		 //verification 
		 
		 //identify log out button 
		 WebElement logout = driver.findElement(By.xpath("//a[text()='Log out']"));
		 //check whether displayed or not
		 if(logout.isDisplayed()==true)
		 {
			 System.out.println("login successful");
		 }
		 else
		 {
			 System.out.println("login failed!");
		 }
		 
		 //click logout
		 logout.click();
		 
		 
		 Thread.sleep(2000);
		 driver.quit();

	}

}
