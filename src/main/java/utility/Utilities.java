package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;

public class Utilities {

	public static WebDriver driver = null;
	static HashMap<Object, Object> mytestData = null;
	static String excelFilePath="C:\\Automation\\Selenium\\src\\test\\resources\\testData\\automationTestData.xlsx";
	static String sheetName = "testData";
	static int testCaseId = 1;
	
//	commented below code as constructor is called when an object is created and 
//	in currently we are not creating object we are using static functionalities
	
//	public functions() throws IOException {
//		// TODO Auto-generated constructor stub
//		System.out.println("in functions constructor");
//		testData = base.readtestData(excelFilePath, sheetName, testCaseId);
//		
//	}
	
	public static HashMap<Object, Object> readExcel() throws IOException {
		// TODO Auto-generated method stub
		HashMap<Object, Object> testData = BaseUtility.readtestData(excelFilePath, sheetName, testCaseId);
		return testData;	
	}
	
	 public static String getTestData(HashMap<Object, Object> mytestData2, String headerName) {
			return (String) mytestData2.get(headerName);
	}

	static int returnHeaderIndex(Sheet sheet, String headerName) {
		// this would return the column number where the given header string is searched
//		System.out.println("in returnHeaderIndex");
		int cellCount = sheet.getRow(0).getLastCellNum();
        int i=0, index=0;
        while(i<cellCount) {
        	if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(headerName))
        	{
//        		System.out.println("value of i ="+i);
        		index=i;
        		break;
        	}
        	else i++;
        }
//        System.out.println("out returnHeaderIndex with value"+ i);
        return index;
	}

	 public static Object[][] dataProviderTestData(String excelFilePath, String sheetName, String testCaseType) throws IOException {
			// return the Object[][] array based on the testcaseType 
			 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
			 XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			  XSSFSheet sheet = workbook.getSheet(sheetName);
			  int testcasetypeindex = returnHeaderIndex(sheet, "testType");
			  int j=1, Objectsize = 0;
//			  System.out.println("getLastRowNum - "+sheet.getLastRowNum());
			  while (j<=sheet.getLastRowNum()) {
//				  System.out.println("ojectsize while loop with testcasetype = "+testCaseType);
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
				  if(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType)) {
					  Objectsize++;
//					  System.out.println("in testcasetype if condition - "+Objectsize);
				  }
				j++;  
			  }
//			  System.out.println("object size" + Objectsize);
//			  Object[][] testdata = new Object[Objectsize][sheet.getRow(0).getLastCellNum()];
			  Object[][] testdata = new Object[Objectsize][1];
			  j=1;
//			  System.out.println("last row number"+sheet.getLastRowNum());
//			  System.out.println("last cell number"+ sheet.getRow(0).getLastCellNum());
			  while (j<=sheet.getLastRowNum()) {
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
			  if(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType)) {
				 int cellCount = sheet.getRow(j).getLastCellNum();
//				 int i=0;
//				 System.out.println("in if");
//			        while(i<cellCount) {
//			        	System.out.println("header "+sheet.getRow(0).getCell(i).toString());
//			        	System.out.println("value of j - "+ j +", j th "+ sheet.getRow(j).getCell(i).toString());
//			        	testdata[j-1][i]= sheet.getRow(j).getCell(i).toString();
//	//				   	testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(testCaseId).getCell(i).toString());
//			        	i++;
//			        }
				 testdata[j-1][0] = BaseUtility.readtestData(excelFilePath, sheetName, j);
			  	}
			  
			  j++;
			  }
			  workbook.close();
			  fileInputStream.close();
			  return testdata;
		}
	 
//	-----------------------------------------Pages FUnctionalities---------------------------
	 
//	public static void OpenHomepage(HashMap<Object, Object> testData) {
//		mytestData = testData;
//		driver = baseFunctions.openBrowser();
//		String url = (String) mytestData.get("Url");
//		baseFunctions.goToUrl(url, driver);
//
//	}
	
	public LoginPage navigateToLoginPage(WebDriver driver){
			this.driver = driver;
			HomePage homePage = new HomePage();
			homePage.clickOnLogin(driver);
			return new LoginPage(driver);
	}
	
//	public static DashboardPage navigateToDashboardPage(){
//		
//		LoginPage.clickOnLoginButton(driver);
//		return new DashboardPage(driver);
//	}
	
	public static RegisterPage navigateToRegisterPage(WebDriver driver){
		
		HomePage.clickOnRegister(driver);
		return new RegisterPage(driver);
	}
	
	public static void fillDetilasOnRegister() {
		String firstName = getTestData(mytestData, "firstName");
		String lastName =  getTestData(mytestData, "lastName");
		String email =  getTestData(mytestData, "email");
		String telephone =  getTestData(mytestData, "telephone");
		String password =  getTestData(mytestData, "password");
		String confirmPassword =  getTestData(mytestData, "confirmPassword"); 
		String newsLetter =  getTestData(mytestData, "newsLetter");
		
		RegisterPage.fillFirstName(driver, firstName);
		RegisterPage.fillLastName(driver, lastName);
		RegisterPage.fillEmail(driver, email);
		RegisterPage.fillTelephone(driver, telephone);
		RegisterPage.fillPassword(driver, password);
		RegisterPage.fillConfirmPassword(driver, confirmPassword);
		RegisterPage.selectNewsLetterOption(driver, newsLetter);
		RegisterPage.clickOnPolicyCheckbox(driver);
		RegisterPage.clickOnContinue(driver);
		String msg = RegisterPage.getWarningMessage(driver);
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
	
	public static DashboardPage navigateToDashboardPage(HashMap<Object, Object> mytestData) {
		
		String Email = getTestData(mytestData, "Email");
		String Password =  getTestData(mytestData, "Password");
		
		LoginPage.fillEmail(driver, Email);
		LoginPage.fillPassword(driver, Password);
		
		LoginPage.clickOnLoginButton(driver);
		
		return new DashboardPage(driver);
	}

	public static LogoutPage navigateToLogout() {
		DashboardPage.clickOnLogout(driver);
		return new LogoutPage();
	}
	
	public static void checkLogout() {
		String msg = LogoutPage.getLogoutMsg(driver);
		System.out.println("error message"+msg);
	}
	
}
