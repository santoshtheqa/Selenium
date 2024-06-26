package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	static WebElement element = null;
	static WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public static WebElement emialTextfield(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.id("input-email"));
		return element;
	}

	public static WebElement passwordTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-password"));
		return element;
	}
	static WebElement forgottenPasswordlink(WebDriver driver) {
		element = driver.findElement(By.linkText("Forgotten Password"));
		return element;
	}
	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@value='Login']"));
		return element;
	}
	
	public static WebElement errorMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
		return element;
	}
	
	public static void fillEmail(WebDriver driver, String email) {
		
		emialTextfield(driver).sendKeys(email);
	}
	
	public static void fillPassword(WebDriver driver, String password) {
		
		passwordTextfield(driver).sendKeys(password);
	}

	public static void clickOnLoginButton(WebDriver driver) {
		loginButton(driver).click();
	}
}
