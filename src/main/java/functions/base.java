package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	 public static WebDriver openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
//		options.addArguments("--disable-application-cache");
		WebDriver driver= new ChromeDriver(options);
		 return driver;
	}
	
	 public static void goToUrl(String Url,WebDriver driver) {
		driver.get(Url);
	}
	
	 public static void closeBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}
}
