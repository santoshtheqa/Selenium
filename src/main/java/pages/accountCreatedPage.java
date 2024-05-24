package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class accountCreatedPage {
	
	static WebElement element = null;
	
	static WebElement accountCretedMsg(WebDriver driver) {
		
		element = driver.findElement(By.tagName("h1"));
		return element;
	}
	
	static WebElement continueButton(WebDriver driver) {
		
		element = driver.findElement(By.linkText("Continue"));
		return element;
	}
	
//	---------------methods---------------
	
	public static String getMsg(WebDriver driver) {
		String msg = null;
		msg = accountCretedMsg(driver).getText();
		return msg;
	}
	
	public static void clickOnContinue(WebDriver driver) {
		
		continueButton(driver).click();
	}
}
