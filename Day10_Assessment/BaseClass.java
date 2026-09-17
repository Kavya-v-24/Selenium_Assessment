package Assessment_Day10;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass  {
	protected WebDriver driver;
	protected String browser;
	protected String url;
	protected String username;
	protected String password;
			
	public void propertiesFileData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Assesment_data/Day10_sauce_login_page_data.properties");
	    Properties p=new Properties();
	    p.load(fis);
	    browser = p.getProperty("browser");
		url = p.getProperty("url");
		username = p.getProperty("username");
	    password= p.getProperty("password");
		
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException 
	
	{
		propertiesFileData();
		
       
		
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
		
		System.out.println("Browser Launched");	
		

		driver.get(url);
		System.out.println("Navigated to application");
		
		
	}
	

	@AfterClass
	
	public void closebrowser()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}

}
