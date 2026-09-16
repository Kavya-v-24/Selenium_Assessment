package Keyword_Driven_framework;

import KeywordDriven.SauceApplicationKeywords;

public class SauceApplicationImplementation {

	public static void main(String[] args) throws InterruptedException {
		
		SauceApplicationKeywords key=new SauceApplicationKeywords();
	
		
		key.keywords("LAUNCH_BROWSER");
		key.keywords("OPEN_URL");
		Thread.sleep(1000);
		key.keywords("USERNAME");
		key.keywords("PASSWORD");
		Thread.sleep(1000);
		key.keywords("LOGIN");
		key.keywords("LOGOUT");

	}

}
