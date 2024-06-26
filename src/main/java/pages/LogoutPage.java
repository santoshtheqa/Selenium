package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

	static WebElement element = null;
	
	static WebElement logoutMsg(WebDriver driver) {
		
		element = driver.findElement(By.tagName("h1"));
		return element;
	}
	
	public static String getLogoutMsg(WebDriver driver) {
		String msg = null;
		msg = logoutMsg(driver).getText();
		return msg;
	}
}
