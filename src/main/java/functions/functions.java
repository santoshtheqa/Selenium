package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import pages.*;

public class functions {

	public static WebDriver driver = null;
	static HashMap<Object, Object> mytestData = null;
//	public static Map<Object, Object> testData = null;
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
		HashMap<Object, Object> testData = base.readtestData(excelFilePath, sheetName, testCaseId);
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
			  while (j<=sheet.getLastRowNum()) {
//				  System.out.println("ojectsize while loop with testcasetype = "+testCaseType);
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
//				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
				  if(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType)) {
					  Objectsize++;
				  }
				j++;  
			  }
//			  System.out.println("object size" + Objectsize);
//			  Object[][] testdata = new Object[Objectsize][sheet.getRow(0).getLastCellNum()];
			  Object[][] testdata = new Object[Objectsize][1];
//			  String [] testdatalist = new String[sheet.getRow(0).getLastCellNum()];
			  j=1;
//			  System.out.println("last row number"+sheet.getLastRowNum());
//			  System.out.println("last cel number"+ sheet.getRow(0).getLastCellNum());
			  while (j<=sheet.getLastRowNum()) {
				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
				  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
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
				 testdata[j-1][0] = base.readtestData(excelFilePath, sheetName, j);
			  	}
			  
			  j++;
			  }
			  workbook.close();
			  fileInputStream.close();
			  return testdata;
		}
	 
//	-----------------------------------------Pages FUnctionalities---------------------------
	 
	public static void OpenHomepage(HashMap<Object, Object> testData) {
		mytestData = testData;
		driver = base.openBrowser();
		String url = (String) mytestData.get("Url");
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
		String firstName = getTestData(mytestData, "firstName");
		String lastName =  getTestData(mytestData, "lastName");
		String email =  getTestData(mytestData, "email");
		String telephone =  getTestData(mytestData, "telephone");
		String password =  getTestData(mytestData, "password");
		String confirmPassword =  getTestData(mytestData, "confirmPassword"); 
		String newsLetter =  getTestData(mytestData, "newsLetter");
		
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
		
		String Email = getTestData(mytestData, "Email");
		String Password =  getTestData(mytestData, "Password");
		
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
