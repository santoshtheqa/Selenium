package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	
	static WebElement element = null;
	static JavascriptExecutor js =null;
	WebDriver driver = null;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement firstNameTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-firstname"));
		return element;
	}
	
	static WebElement LastNameTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-lastname"));
		return element;
	}
	
	static WebElement emailTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-email"));
		return element;
	}
	
	static WebElement telephoneTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-telephone"));
		return element;
	}
	
	static WebElement passwordTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-password"));
		return element;
	}
	static WebElement confirmPasswordTextfield(WebDriver driver) {
		element = driver.findElement(By.id("input-confirm"));
		return element;
	}
	
	static WebElement newsletterYesRadioButton(WebDriver driver) {
		element = driver.findElement(By.id("input-newsletter-yes"));
		return element;
	}
	
	static WebElement newsletterNoRadioButton(WebDriver driver) {
		element = driver.findElement(By.id("input-newsletter-no"));
		return element;
	}
	
	static WebElement policyCheckbox(WebDriver driver) {
		element = driver.findElement(By.id("input-agree"));
		return element;
	}
	
	static WebElement continueButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@value='Continue']"));
		return element;
	}
	
	static WebElement warningMessage(WebDriver driver) {
		element= driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));
		return element;
	}
	
	//--------------------methods--------------
	public static void fillFirstName(WebDriver driver, String firstName) {
		
		firstNameTextfield(driver).sendKeys(firstName);
	}
	
	public static void fillLastName(WebDriver driver, String lastName) {
		
		LastNameTextfield(driver).sendKeys(lastName);
	}
	
	public static void fillEmail(WebDriver driver, String email) {
		
		emailTextfield(driver).sendKeys(email);
	}
	
	public static void fillTelephone(WebDriver driver, String telephone) {
		
		telephoneTextfield(driver).sendKeys(telephone);
	}
	
	public static void fillPassword(WebDriver driver, String password) {
		
		passwordTextfield(driver).sendKeys(password);
	}
	
	public static void fillConfirmPassword(WebDriver driver, String confirmPassword) {
		
		confirmPasswordTextfield(driver).sendKeys(confirmPassword);
	}
	
	public static void selectNewsLetterOption(WebDriver driver, String newsLetterOption) {
		
		 js = (JavascriptExecutor) driver;
		 
		if(newsLetterOption.equalsIgnoreCase("yes"))
//			newsletterYesRadioButton(driver).click();
			js.executeScript("arguments[0].click()", newsletterYesRadioButton(driver));
		
		else
//			newsletterNoRadioButton(driver).click();
			js.executeScript("arguments[0].click()", newsletterNoRadioButton(driver));
	}
	
	public static void clickOnPolicyCheckbox(WebDriver driver) {
		
//		policyCheckbox(driver).click();
		js.executeScript("arguments[0].click()", policyCheckbox(driver));
	}
	
	public static void clickOnContinue(WebDriver driver) {
		
		continueButton(driver).click();
	}
	
	public static String getWarningMessage(WebDriver driver) {
		String msg = null;
		if(warningMessage(driver).isDisplayed())
		msg = warningMessage(driver).getText();
		return msg;
	}
}
