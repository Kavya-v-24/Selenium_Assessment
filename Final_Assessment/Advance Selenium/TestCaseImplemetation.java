package LastDay_Assessment;


import org.testng.annotations.Test;



import Last_Day_Assessment2.OrangeHrmBaseClass;
import Last_Day_Assessment2.OrangeHrmBuzzPage;
import Last_Day_Assessment2.OrangeHrmHomePage;

public class Assessment2 extends OrangeHrmBaseClass {
	
	@Test
	public void BuzzTest() throws InterruptedException
	{
		OrangeHrmHomePage h=new OrangeHrmHomePage(driver);
		h.getBuzzlink();
		Thread.sleep(2000);
		
		OrangeHrmBuzzPage buzz=new OrangeHrmBuzzPage(driver);
		buzz.getWhatinmind(msgtopost);
		buzz.getPostbutton();
		buzz.getVerifypost(msgtopost);
	
	}

}
