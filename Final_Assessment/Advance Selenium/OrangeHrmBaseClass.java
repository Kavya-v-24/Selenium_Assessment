package Last_Day_Assessment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class OrangeHrmBaseClass {
	
	protected WebDriver driver;
	protected String browser;
    protected String url;
    protected String username;
    protected String password;
    protected String msgtopost;
	
	
	public void propertiesfiledata() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Assesment_data/OrangeHrmloginDetails.properties");
		Properties p=new Properties();
		p.load(fis);
		browser=p.getProperty("browser");
		url=p.getProperty("url");
		username=p.getProperty("username");
		password=p.getProperty("password");
		msgtopost=p.getProperty("whatinmind");
		
	}
	
	@BeforeClass
	
	public void launchBrowser() throws IOException 
	{
	
		propertiesfiledata();
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Browser Launched");	
		Assert.assertTrue(true);
			
				
	}
	
	@BeforeMethod
	public void navigateLoginApplication() throws IOException, InterruptedException
	{
		propertiesfiledata();
		
		driver.get(url);
		
		Thread.sleep(2000);
		
		OrangeHrmLoginPage l=new OrangeHrmLoginPage(driver);
		l.getUsernametf(username);
		l.getPasswordtf(password);
		l.getLoginbutton();
		Assert.assertTrue(true);
		System.out.println("login successful");
		
		
	}

	@AfterMethod
	
	public void logout() throws InterruptedException
	{
		OrangeHrmHomePage h=new OrangeHrmHomePage(driver);
		
		h.getUserdropdown();
		Thread.sleep(2000);
		h.getLogoutbutton();
		System.out.println("logout successful");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
