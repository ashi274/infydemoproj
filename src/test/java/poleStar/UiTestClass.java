package poleStar;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import pages.GetStartedPage;
import pages.HomePage;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class UiTestClass extends BaseClass {

	@Parameters("br")
	@BeforeClass
	public void beforeMethod(@Optional("firefox") String br) {
		playwright = Playwright.create();

		switch (br) {

		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			System.out.println("Browser is " + br);
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			System.out.println("Browser is " + br);
			break;
			
		case "webkit":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			System.out.println("Browser is " + br);
			break;
		}

		page = browser.newPage();
		getStartedPageObj = new GetStartedPage(page);
		homePageObj = new HomePage(page);
	}

	@Parameters("url")
	@Test(priority = 0)
	public void navigateToTheLink(@Optional("https://www.polestar.com/global/developer/get-started/") String url)
			throws Exception {
		page.navigate(url);
		Thread.sleep(5000);

	}

	@Test(priority = 1, dependsOnMethods = "navigateToTheLink")
	public void rejectCookies() throws Exception {

		Assert.assertTrue(getStartedPageObj.acceptButtonDisplayed());
		getStartedPageObj.ClickRejectCookies();

	}

	@Test(priority = 2, dependsOnMethods = "navigateToTheLink")
	public void toHomePage() throws InterruptedException {

		getStartedPageObj.goToHome();

	}

	@Test(priority = 3)
	public void toLearnMore() {

		homePageObj.goTolearnMore();
	}

	@AfterClass
	public void afterMethod() {
		page.close();
		browser.close();
		playwright.close();
	}

}
