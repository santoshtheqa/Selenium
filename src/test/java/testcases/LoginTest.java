package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegisterPage;
import utility.BaseUtility;
import utility.Utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class LoginTest extends Utilities{
	static WebDriver driver = null;
	SoftAssert softassert= new SoftAssert();
	
	
  @Test(enabled = false)
  public void verifyHomePage(){
//  	functions.readExcel();
//	functions.OpenHomepage(testData);
	
//	functions.navigateToRegisterPage();
//	functions.fillDetilasOnRegister();
////	functions.navigateToaccountCreatedPage();
////	functions.checkAccountCreation();
//	functions.navigateToLoginPage();
//	functions.fillDetilasOnLoginPage();
//	functions.navigateToDashboardPage();
//	functions.navigateToLogout();
//	functions.checkLogout();
//	functions.closeBrowser();
	  
//	  -----------------------old list of methods-------------------
	  HomePage homePageObj = new HomePage();
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(homePageObj.myaccountdropdown(driver)));
		
	  Assert.assertEquals(true, homePageObj.searchButton(driver).isDisplayed(),"Search button on Homepage not displayed");
  }
  
  @Test(enabled = false)
  private void verifyLoginPage() {  
	  System.out.println(1);
	   LoginPage  loginPageObj =  navigateToLoginPage(driver);
	   System.out.println(2);
	  softassert.assertEquals(true, loginPageObj.emialTextfield(driver).isDisplayed(),"emial Textfield on LoginPage not displayed");
	  softassert.assertEquals(true, loginPageObj.passwordTextfield(driver).isDisplayed(),"password Textfield on LoginPage not displayed");
	  softassert.assertEquals(true, loginPageObj.loginButton(driver).isDisplayed(),"login button on LoginPage not displayed");
	  softassert.assertAll();
}
  
  @Test(enabled = false)
  private void verifyRegisterPage() throws InterruptedException {
	  System.out.println("in navigateToRegisterPage");
	 RegisterPage registerObj = navigateToRegisterPage(driver);
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(registerObj.firstNameTextfield(driver)));
	  System.out.println("out navigateToRegisterPage");
	  
	  softassert.assertEquals(true, registerObj.firstNameTextfield(driver).isDisplayed(),"firstName Textfield on LoginPage not displayed");
}
  
  @Test(dataProvider = "loginDataProvider",enabled = true)
  private void verifyDashboardPage(HashMap<Object, Object> mytestData) {
	  
//	  BaseUtility.mywait(driver, 10);
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e) { 
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  LoginPage loginPageObj = new LoginPage(driver); 
	  navigateToLoginPage(driver);
	  DashboardPage dashboardObj = navigateToDashboardPage(mytestData);
	 
	  boolean errorstatus = false;
      try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(loginPageObj.errorMessage(driver)));
			
			errorstatus = loginPageObj.errorMessage(driver).isDisplayed();
	} catch (Exception e) {
		System.out.println("error message catch block");
		e.printStackTrace();
	}
		
		if(errorstatus) {
			String errorMessage =  loginPageObj.errorMessage(driver).getText();
		 System.out.println(errorMessage);
		 System.out.println(errorMessage.contains("Warning: No match for E-Mail Address and/or Password."));
		 softassert.assertEquals(true, errorMessage.contains("Warning"),"error message - "+errorMessage+" - is displayed");
		}
		else {
			System.out.println("in else");
			Assert.assertEquals(true, dashboardObj.editYourAccountInformation(driver).isDisplayed(),"Edit your account information image");
		}
	  
//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(loginPageObj.errorMessage(driver)));
//		if(loginPageObj.errorMessage(driver).isDisplayed()) {
//			String errorMessage =  loginPageObj.errorMessage(driver).getText();
//		 System.out.println(errorMessage);
//		 softassert.assertEquals(true, errorMessage.contains("Warning"),"error message - "+errorMessage+" - is displayed");
//		}
//		else {
//			Assert.assertEquals(true, dashboardObj.editYourAccountInformation(driver).isDisplayed(),"Edit your account information image");
//		}
}

  @Test(alwaysRun = true, enabled = false)
  private void verifyLogout(HashMap<Object, Object> mytestData) {
	  navigateToLoginPage(driver);
	  navigateToDashboardPage(mytestData);
	  LogoutPage logoutObj = navigateToLogout();
	  
	  Assert.assertEquals(true, logoutObj.getLogoutMsg(driver).contains("Account Logout"),"Account Logout header");
}
  
  @DataProvider(name = "Register")

  public Object[][] registerDataProvider() {
  /* 	need to write function
   *  1. to get the number of testcases or number of iterations the tests will execute - done
   *  2. to return individual testdata as per individual testcase, return type must be array - done
   */
	  String excelFilePath="C:\\Automation\\Selenium\\src\\test\\resources\\testData\\automationTestData.xlsx";
	  String sheetName = "TestData";
	  String testCaseType = "sanity";
	  Object[][] data = null;
	 
	  try {
		data = Utilities.dataProviderTestData(excelFilePath, sheetName, testCaseType);
	} catch (IOException e) {
		System.out.println("erorr in reading excel");
		e.printStackTrace();
	}  
//	  System.out.println("printing data from dataprovider");
//	  for(int i=0; i<data.length; i++) {
//          for(int j=0; j<data[i].length; j++) {
//              System.out.print("Values at arr["+i+"]["+j+"] is "+data[i][j]);
//          }
//          System.out.println();
//      }
	  
	  return data;
  }
  
  @DataProvider(name = "loginDataProvider")
  
  public Object[][] loginDataProvider() {
  /* 	need to write function
   *  1. to get the number of testcases or number of iterations the tests will execute - done
   *  2. to return individual testdata as per individual testcase, return type must be array - done
   */
	  
	  Properties  prop = new Properties();
      System.out.println(System.getProperty("user.dir"));
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(propFile);
			prop.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		 String excelFilePath=prop.getProperty("excelFilePath");
		  String sheetName = prop.getProperty("sheetName");
		  String testCaseType = prop.getProperty("testCaseType");
		  
//	  String excelFilePath="C:\\Automation\\Selenium\\src\\test\\resources\\testData\\automationTestData.xlsx";
//	  String sheetName = "Login";
//	  String testCaseType = "sanity";
	  
	  Object[][] data = null;
	 
	  try {
		data = Utilities.dataProviderTestData(excelFilePath, sheetName, testCaseType);
	} catch (IOException e) {
		System.out.println("erorr in reading excel");
		e.printStackTrace();
	}  
	  System.out.println("printing data from dataprovider");
	  for(int i=0; i<data.length; i++) {
          for(int j=0; j<data[i].length; j++) {
              System.out.print("Values at arr["+i+"]["+j+"] is "+data[i][j]);
          }
          System.out.println();
      }
	  return data;
  }
  
  @Parameters({"browserType","url"})
  @BeforeMethod
  public void beforeMethod(String browserType,String url) {
	  
//	  below is implicit wait which is common throughout the browser session 
//	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS
	  
	  System.out.println("browserType parameter = "+ browserType);
	  
//	  Creating test bed where browser we open browser and hit the url 
//		String driverpath= "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe";
//		String browserType = "Chrome";
//		String url = (String) mytestData.get("Url");
//		String url = "https://ecommerce-playground.lambdatest.io/index.php?route=common/home";
		BaseUtility baseFunctions = new BaseUtility();
		driver = baseFunctions.openBrowser(browserType);
		baseFunctions.goToUrl(url, driver);
		 BaseUtility.mywait(driver, 5);
		System.out.println("end of beforemethod");
  }

  @AfterMethod
  public void afterClass() {
	  BaseUtility baseFunctions = new BaseUtility();
	  baseFunctions.closeBrowser(driver);
	  System.out.println("in after method");
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
