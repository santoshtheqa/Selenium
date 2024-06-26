package utility;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class CheckAssert{
	public static void main(String[] args) {
//		C:\Program Files (x86)\Google\Chrome\Application
//		cmd => chrome.exe -remote-debugging-port=9222 -user-data-dir=C:\Users\Public\Temp
	      ChromeOptions o = new ChromeOptions();
	      //setting debuggerAddress value
	      o.setExperimentalOption("debuggerAddress", "localhost:9222");
	      //add options to browser capabilities
	      System.out.println(697);
	      WebDriver driver = new ChromeDriver(o);
	      System.out.println(12);
	      //set implicit wait
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      //identify element
	      System.out.println(077);
//	      driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
	      System.out.println("jash");
	    
	}
}