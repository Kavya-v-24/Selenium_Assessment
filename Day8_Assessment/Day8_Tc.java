package Assesments;


import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Assessment_Day8.CandidateSearchPage;
import Assessment_Day8.OrangeHrmLoginpage;
import Assessment_Day8.OrangeHrmRecruitmentPage;

public class Day8_Tc {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	
		FileInputStream fis=new FileInputStream("./src/test/resources/Assesment_data/Day8_tc_loginData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		FileInputStream fis2=new FileInputStream("./src/test/resources/Assesment_data/Day8_Tc_eleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String firstname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		 String middlename = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		 String lastname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		 String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		 String contact_no = String.valueOf((long)wb.getSheet("Sheet1").getRow(1).getCell(4).getNumericCellValue());
		 String resume = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		 String fromdate = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		 String todate = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		 
			
		
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
		
		OrangeHrmLoginpage l=new OrangeHrmLoginpage(driver);
		
		l.getUsername(username);
		l.getPassword(password);
		l.getLoginbutton();
		Thread.sleep(2000);
		
		OrangeHrmRecruitmentPage r=new OrangeHrmRecruitmentPage(driver);
		r.getRecuitlink();
		Thread.sleep(1000);
		r.getAddbutton();
		Thread.sleep(1000);
		r.getFirstnametf(firstname);
		r.getMiddlenametf(middlename);
		r.getLastnametf(lastname);
		Thread.sleep(2000);
		r.getVacancydd();
		Thread.sleep(2000);
		r.getEmailtf(email);
		Thread.sleep(2000);
		r.getContactnumtf(contact_no);
		Thread.sleep(2000);
		r.getResumefile(resume);
//		r.getDateofapplication();
		Thread.sleep(1000);
		r.getSavebutton();
		Thread.sleep(3000);
		
 
		CandidateSearchPage cs=new CandidateSearchPage(driver);
		cs.getCandidatelink();
		Thread.sleep(3000);
//		cs.getJobtitledd();
//		Thread.sleep(2000);
//		cs.getVacancy();
//		Thread.sleep(3000);
//		
//		cs.getHiringmanager();
//		Thread.sleep(2000);
//		cs.getStatus();
//		Thread.sleep(2000);
		cs.getCandidatename(firstname);
		Thread.sleep(3000);
//		cs.getFromdate(fromdate);
//		Thread.sleep(2000);
//		cs.getTodate(todate);
//		Thread.sleep(2000);
//		cs.getMethodofapp();
		Thread.sleep(2000);
		cs.getSearchbutton();
		cs.getRecordfound();
		Thread.sleep(3000);
		cs.getUserdd();
		Thread.sleep(1000);
		cs.getLogout();
		
		Thread.sleep(2000);
		driver.quit();
		

	}

	
	}


