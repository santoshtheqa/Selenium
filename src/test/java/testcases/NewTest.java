package testcases;

import org.testng.annotations.Test;

import functions.functions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(dataProvider = "dp")
//	@Test
  public void f(HashMap<Object, Object> testData){
	  System.out.println("print ="+testData);
//  	functions.readExcel();
	functions.OpenHomepage(testData);
	functions.navigateToRegisterPage();
	functions.fillDetilasOnRegister();
//	functions.navigateToaccountCreatedPage();
//	functions.checkAccountCreation();
	functions.navigateToLoginPage();
	functions.fillDetilasOnLoginPage();
	functions.navigateToDashboardPage();
	functions.navigateToLogout();
	functions.checkLogout();
	functions.closeBrowser();
  }

  @DataProvider(name = "dp")
  public Object[][] dp() {
  /* 	need to write function
   *  1. to get the number of testcases or number of iterations the tests will execute - done
   *  2. to return individual testdata as per individual testcase, return type must be array - done
   */
	  String excelFilePath="C:\\Automation\\Selenium\\src\\test\\resources\\testData\\automationTestData.xlsx";
	  String sheetName = "TestData";
	  String testCaseType = "smoke";
	  Object[][] data = null;
	 
	  try {
		data = functions.dataProviderTestData(excelFilePath, sheetName, testCaseType);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("erorr in reading excel");
		e.printStackTrace();
	}  
	  return data;
	  
	  
//    return new Object[][] {
//
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
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
