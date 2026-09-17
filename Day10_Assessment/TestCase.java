package Assesments;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import Assessment_Day10.BaseClass;
import Assessment_Day10.CartPagePOM;
import Assessment_Day10.CheckoutPagePOM;
import Assessment_Day10.HomePagePOM;
import Assessment_Day10.LoginPagePOM;


public class Day10_TC extends BaseClass{
	
  @Test
  
  public void loginTest()
  {
	  
	  LoginPagePOM l=new LoginPagePOM(driver);
	  l.getUsernametf(username);
	  l.getPasswordtf(password);
	  l.getLoginbutton();
	  System.out.println("Login successful");
  }
  
  @Test(dependsOnMethods = "loginTest")
  
  public void orderPlacementTest() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  FileInputStream fis2=new FileInputStream("src/test/resources/Assesment_data/Day10_TC_excel.xlsx");
	  Workbook wb = WorkbookFactory.create(fis2);
	  String firstname = wb.getSheet("checkout").getRow(1).getCell(0).getStringCellValue();
	  String lastname = wb.getSheet("checkout").getRow(1).getCell(1).getStringCellValue();
	  String postalpin = String.valueOf((int)wb.getSheet("checkout").getRow(1).getCell(2).getNumericCellValue());
	  
	  HomePagePOM h=new HomePagePOM(driver);
	  System.out.println("product page displayed");
	  Thread.sleep(3000);
	  h.getBackPackaddtocart();
	  Thread.sleep(1000);
	  h.getCartbutton();
	  Thread.sleep(2000);
	  
	  
	  CartPagePOM cart=new CartPagePOM(driver);
	  
      System.out.println("Cart page contains "+cart.getCartquantity()+" items");
	  System.out.println("Sauce Labs Backpack is displayed:"+cart.getBackpack());
	  cart.getCheckoutbutton();
	  Thread.sleep(2000);
	  
	  
	  CheckoutPagePOM co=new CheckoutPagePOM(driver);
	  co.getFirstnametf(firstname);
	  co.getLastnametf(lastname);
	  co.getPostalcodetf(postalpin);
	  Thread.sleep(1000);
	  co.getContinuebutton();
	  Thread.sleep(2000);
	  System.out.println("Overview page is displayed");
	  co.getFinishbutton();
	  Thread.sleep(1000);
	  System.out.println("Thank you for your order! is displayed: "+co.getConfirmmsg());
	  
		
  }

}
