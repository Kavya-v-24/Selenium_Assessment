/*

Testcase 3 

1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login  submit button
3.Read the data from json file.


 */


package Assesments;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5_Tc3 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FileReader fr=new FileReader("./src/test/resources/DDT/demoQspiderslogindata.json");
		JSONParser p=new JSONParser();
		Object javaobj = p.parse(fr);
		JSONObject obj = (JSONObject)javaobj;
		
		String browser = obj.get("browser").toString();
		String url = obj.get("url").toString();
		String name = obj.get("name").toString();
		String email = obj.get("email").toString();
		String password = obj.get("password").toString();
		

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
		 
		 ///identify name text field and enter name and move to email text field enter email and move to password text field and enter password (using reference variables)
		 driver.findElement(By.id("name")).sendKeys(name,Keys.TAB,email,Keys.TAB,password);
		 Thread.sleep(2000);
		 
		 //identify register button and click 
		 driver.findElement(By.xpath("//button[text()='Register']")).click();
		 
		 Thread.sleep(3000);
		 driver.quit();		 

	}

}
