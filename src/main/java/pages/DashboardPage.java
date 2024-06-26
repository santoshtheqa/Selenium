package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	static WebElement element = null;
	WebDriver driver = null;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static WebElement logout(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=' Logout']")); 
		return element;
	}
	
	public WebElement editYourAccountInformation(WebDriver driver) {
		element = driver.findElement(By.xpath(".//a[contains(@href,'route=account/edit')]"));
		return element;
	}
	
	public static void clickOnLogout(WebDriver driver) {
		logout(driver).click();
	}
	
}
