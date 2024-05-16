package functions;

import org.openqa.selenium.WebDriver;

import pages.HomePage;


public class Functions {

	public static WebDriver driver = null;
	
	public static void OpenHOmepage() {
		driver = base.openBrowser();
		base.goToUrl("https://ecommerce-playground.lambdatest.io/", driver);
		
		try {
			HomePage.clickonlogin(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		base.closeBrowser(driver);
	}
	
}
