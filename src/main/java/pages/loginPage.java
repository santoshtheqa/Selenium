package pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	static WebElement element = null;
	
	static WebElement emialTextfield(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.id("input-email"));
		return element;
	}

	static WebElement passwordTextfield(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.id("input-password"));
		return element;
	}
	static WebElement forgottenPasswordlink(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.linkText("Forgotten Password"));
		return element;
	}
	static WebElement loginButton(WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.xpath(".//input[@value='Login']"));
		return element;
	}
}
