package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GetStartedPage {
	Page page;
	
	Locator rejectButton;
	Locator acceptButton;
	Locator toHomeButton;
	
	public GetStartedPage(Page page) {
		
		  this.page = page;
		  
		  rejectButton = page.locator("#onetrust-reject-all-handler");
		  acceptButton = page.getByText("Accept all");
		  toHomeButton = page.getByText("Return Home");
		  
	}
	
	public void ClickRejectCookies() {
		
		//Rejecting cookies
		rejectButton.click();
	}
	
	public boolean acceptButtonDisplayed() {
		
		//Accept Button availability 
		return acceptButton.isVisible();
	}
	
	public void goToHome() {
		
		toHomeButton.click();
		
	}


}