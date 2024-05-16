package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebElement element = null;
	
	WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Search']"));
		return element;
	}
	
	WebElement searchTextBox(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@name='search']"));
		return element;
	}
	
}
