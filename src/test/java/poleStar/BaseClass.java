package poleStar;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.GetStartedPage;
import pages.HomePage;

public class BaseClass {
	
	Playwright playwright;
	Browser browser;
	public Page page;
	
	GetStartedPage getStartedPageObj;
	HomePage homePageObj;
	


}
