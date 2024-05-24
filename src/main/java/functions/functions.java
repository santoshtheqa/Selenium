package functions;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import pages.*;

public class functions {

	public static WebDriver driver = null;
	public static HashMap<String, String> testData = null;
	static String excelFilePath="C:/Automation/Selenium/src/main/java/testData/automationTestData.xlsx";
	static String sheetName = "testData";
	static int testCaseId = 1;
	
//	commented belw code as constructor is called when an object is created and 
//	in currently we are not creating object we are using static functionalities
	
//	public functions() throws IOException {
//		// TODO Auto-generated constructor stub
//		System.out.println("in functions constructor");
//		testData = base.readtestData(excelFilePath, sheetName, testCaseId);
//		
//	}
	public static HashMap<String, String> readExcel() throws IOException {
		// TODO Auto-generated method stub
		testData = base.readtestData(excelFilePath, sheetName, testCaseId);
		return testData;
		
	}
	
	 public static String getTestData(HashMap<String, String> testData, String headerName) {
			return testData.get(headerName);
	}
	
	public static void OpenHOmepage() {
		driver = base.openBrowser();
		String url = testData.get("Url");
		base.goToUrl(url, driver);
	}
	
	public static void navigateToLoginPage(){
		try {
			homePage.clickOnLogin(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while clicking on login button");
			e.printStackTrace();
		}
	}
	
	public static void navigateToDashboardPage(){
		
		dashboardPage.clickOnLoginButton(driver);
	}
	
	public static void navigateToRegisterPage(){
		try {
			homePage.clickOnRegister(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while clicking on login button");
			e.printStackTrace();
		}
	}
	
	public static void fillDetilasOnRegister() {
		String firstName = getTestData(testData, "firstName");
		String lastName =  getTestData(testData, "lastName");
		String email =  getTestData(testData, "email");
		String telephone =  getTestData(testData, "telephone");
		String password =  getTestData(testData, "password");
		String confirmPassword =  getTestData(testData, "confirmPassword"); 
		String newsLetter =  getTestData(testData, "newsLetter");
		
		registerPage.fillFirstName(driver, firstName);
		registerPage.fillLastName(driver, lastName);
		registerPage.fillEmail(driver, email);
		registerPage.fillTelephone(driver, telephone);
		registerPage.fillPassword(driver, password);
		registerPage.fillConfirmPassword(driver, confirmPassword);
		registerPage.selectNewsLetterOption(driver, newsLetter);
		registerPage.clickOnPolicyCheckbox(driver);
		registerPage.clickOnContinue(driver);
		String msg = registerPage.getWarningMessage(driver);
		System.out.println("error message"+msg);
		
	}
	
	public static void navigateToaccountCreatedPage(){
		try {
			accountCreatedPage.clickOnContinue(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception while clicking on Continue button");
			e.printStackTrace();
		}
	}
	
	public static void checkAccountCreation() {
		String msg = accountCreatedPage.getMsg(driver);
		System.out.println("error message"+msg);
	}
	
	public static void fillDetilasOnLoginPage() {
		
		String Email = getTestData(testData, "Email");
		String Password =  getTestData(testData, "Password");
		
		loginPage.fillEmail(driver, Email);
		loginPage.fillPassword(driver, Password);
	}

	public static void navigateToLogout() {
		logoutPage.clickOnLogout(driver);
	}
	
	public static void checkLogout() {
		String msg = logoutPage.getLogoutMsg(driver);
		System.out.println("error message"+msg);
	}
	
	public static void closeBrowser() {
		base.closeBrowser(driver);
	}
	
}
