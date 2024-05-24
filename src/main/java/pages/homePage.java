package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class homePage {

	static WebElement element = null;
	static Actions action = null; 
	
	WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Search']"));
		return element;
	}
	
	WebElement searchTextBox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@name='search']"));
		return element;
	}
	
	static WebElement myaccountdropdown(WebDriver driver){
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
	
	public static void clickOnLogin(WebDriver driver) throws InterruptedException {
		 action = new Actions(driver);
		 action.moveToElement(myaccountdropdown(driver)).perform();
		Thread.sleep(1000);
		loginButton(driver).click();
		Thread.sleep(2000);
	}
	
	public static void clickOnRegister(WebDriver driver) throws InterruptedException {
		 action = new Actions(driver);
		 action.moveToElement(myaccountdropdown(driver)).perform();
		Thread.sleep(1000);
		registerButton(driver).click();
		Thread.sleep(2000);
	}
}
