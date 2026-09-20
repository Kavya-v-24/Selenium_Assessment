package Assesments;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.testng.annotations.Test;


import Assesment_Day12.OrangeHrmAddVacanciesPagePOM;
import Assesment_Day12.OrangeHrmBaseClass;
import Assesment_Day12.OrangeHrmHomePagePOM;
import Assesment_Day12.OrangeHrmRecruitmentPagePOM;
import Assesment_Day12.OrangeMyInfoPagePOM;


public class Day12_Tc extends OrangeHrmBaseClass{
	String vacancyname;
	String description;
	String hiringmanager ;
	String numofposition;
	String firstname;
	String middlename;
	String lastname;
	String empid;
	
	public void exceldata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2=new FileInputStream("./src/test/resources/Assesment_data/Day12_Excel_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Row row = wb.getSheet("Sheet1").getRow(1);
		vacancyname = row.getCell(0).getStringCellValue();
        description = row.getCell(1).getStringCellValue();
		hiringmanager = row.getCell(2).getStringCellValue();
		numofposition = String.valueOf((int) row.getCell(3).getNumericCellValue());
		firstname=row.getCell(4).getStringCellValue();
		middlename=row.getCell(5).getStringCellValue();
		lastname=row.getCell(6).getStringCellValue();
		empid=row.getCell(7).getStringCellValue();
		
	}
	
	@Test
	public void testCase1Test() throws  InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		
		exceldata();
		OrangeHrmHomePagePOM h=new OrangeHrmHomePagePOM(driver);
		
		Thread.sleep(2000);
		
		h.getRecruitmentlink();
		Thread.sleep(2000);
		
		OrangeHrmRecruitmentPagePOM r=new OrangeHrmRecruitmentPagePOM(driver);
		
		
		r.getVacancieslink();
		Thread.sleep(2000);
		
		r.getAddbutton();
		Thread.sleep(2000);
		
		OrangeHrmAddVacanciesPagePOM add=new  OrangeHrmAddVacanciesPagePOM(driver);
		
		add.getVacancynametf(vacancyname);
		Thread.sleep(1000);
		add.getJobtitledd();
		Thread.sleep(2000);
		add.getDescriptiontf(description);
		Thread.sleep(1000);
		add.getHiringmanagertf(hiringmanager);
		Thread.sleep(4000);
		add.getNumofpositionstf(numofposition);
		Thread.sleep(1000);
		add.getSavebutton();
		Assert.assertTrue(true);
		
		Thread.sleep(3000);
		
		r.getVacancieslink();
		Thread.sleep(2000);
		
		r.getVacancydd();
		Thread.sleep(2000);
		
		r.getSearchbutton();
		Thread.sleep(3000);
		
		if(r.getrecord().contains(vacancyname))
		{
			System.out.println("Vacancy added successfully");
		}
		
		System.out.println("testcase1 passed");
		
		
		
	}
		
	
		@Test
		
		public void testcase2() throws InterruptedException, EncryptedDocumentException, IOException
		{
			exceldata();
			OrangeHrmHomePagePOM h=new OrangeHrmHomePagePOM(driver);
			h.getMyinfolink();
			Thread.sleep(2000);
			
			OrangeMyInfoPagePOM info=new OrangeMyInfoPagePOM(driver);
			Thread.sleep(2000);
			info.getFirstnametf(firstname);
			Thread.sleep(2000);
			info.getMiddlenametf(middlename);
			Thread.sleep(2000);
			info.getLastnametf(lastname);
			Thread.sleep(3000);
			info.getEmpid(empid);
			Thread.sleep(2000);
			info.getSavebutton();
			Thread.sleep(2000);
			
			System.out.println("testcase2 passed");
			
			
		}
		
		@Test(dependsOnMethods = "testcase2")
		
		public void testcase2verify() throws InterruptedException
		{
			OrangeHrmHomePagePOM h=new OrangeHrmHomePagePOM(driver);
		     h.getMyinfolink();
		     Thread.sleep(2000);
		     OrangeMyInfoPagePOM info=new OrangeMyInfoPagePOM(driver);
		     info.verification(firstname);
		     System.out.println("Test case 2 is verified");
		     
		     
		     
		
			
		}
		
		
		
		
	

}
