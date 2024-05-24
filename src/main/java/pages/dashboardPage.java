package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage {

	static WebElement element = null;
	private static WebElement loginButton(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.xpath("//input[@value='Login']"));
		return element;
	}
	
	public static void clickOnLoginButton(WebDriver driver) {
		// TODO Auto-generated method stub
		loginButton(driver).click();
	}
}
