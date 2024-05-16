package functions;

import org.openqa.selenium.WebDriver;

import pages.HomePage;


public class Functions {

	public static WebDriver driver = null;
	
	public static void OpenHOmepage() {
		driver = base.openBrowser();
		base.goToUrl("https://ecommerce-playground.lambdatest.io/", driver);
	}
	
	public static void navigateToLoginPage(){
		try {
			HomePage.clickonlogin(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while clicking on login button");
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		base.closeBrowser(driver);
	}
	
}
