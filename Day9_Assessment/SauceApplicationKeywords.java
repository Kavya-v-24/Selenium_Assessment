package KeywordDriven;

public class SauceApplicationKeywords {
	
	SauceApplicationMethods m=new SauceApplicationMethods();
	
	
	public void keywords(String keyword) throws InterruptedException 
	{
	
		
		if(keyword.equals("LAUNCH_BROWSER"))
		{
			m.launchbrowser();
		}
		
		else if(keyword.equals("OPEN_URL"))
		{
			m.openurl();
		}
		else if(keyword.equals("USERNAME"))
		{
			m.username();
		}
		else if(keyword.equals("PASSWORD"))
		{
			m.password();
		}
		else if(keyword.equals("LOGIN"))
		{
			m.login();
		}
		else if(keyword.equals("LOGOUT"))
		{
			m.logout();
		}
	}

}
