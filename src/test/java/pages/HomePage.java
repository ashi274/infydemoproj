package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
	
	Page page;
	
	Locator learnMoreButton;
	
	public HomePage(Page page) {
		
		learnMoreButton = page.locator("xpath = //*[@id=\"main-content\"]/div/div[1]/section/div[2]/div/div/div/div[2]/div/div[1]/div/a");
	}
	
	public void goTolearnMore() {
		
		learnMoreButton.click();
		
	}

}
