package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public static WebDriver driver=null;
	
	 public static void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver= new ChromeDriver(options);
	}
	
	 public static void goToUrl(String Url) {
		driver.get(Url);
	}
	
	 public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
