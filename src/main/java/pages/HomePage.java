package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseUtility;

public class HomePage {

	static WebElement element = null;
	static Actions action = null; 
	
	public WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Search']"));
		return element;
	}
	
	public WebElement searchTextBox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@name='search']"));
		return element;
	}
	
	public static WebElement myaccountdropdown(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']//span[contains(text(),' My account')]"));
		return element;
	}
	
	static WebElement loginButton(WebDriver driver){			
		element = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		return element;
	}
	
	static WebElement registerButton(WebDriver driver){			
		element = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
		return element;
	}
//	--------------------------actions --------------
	
	public void clickOnLogin(WebDriver driver) {
		 action = new Actions(driver);
		 action.moveToElement(myaccountdropdown(driver)).perform();
		loginButton(driver).click();
		
	}
	
	public static void clickOnRegister(WebDriver driver) {
		 action = new Actions(driver);
		 action.moveToElement(myaccountdropdown(driver)).perform();
//		 BaseUtility.mywait(driver, 2);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(registerButton(driver)));
//		Thread.sleep(1000);
		registerButton(driver).click();
//		Thread.sleep(2000);
	}
}
