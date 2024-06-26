package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {

	public WebDriver openBrowser(String browserType){
		 WebDriver driver= null;
		if (browserType.equalsIgnoreCase("Chrome")) {
			String driverpath = "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe";
			 System.setProperty("webdriver.chrome.driver",driverpath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
//			options.addArguments("--incognito");
//			options.addArguments("--disable-application-cache");
			 driver= new ChromeDriver(options);
		}
		else
		{
			// default chrome driver 
			 driver= new ChromeDriver();
		}
		 return driver;
	}
	
	 public void goToUrl(String Url,WebDriver driver) {
		driver.get(Url);
		
	}
	
	 public static void mywait(WebDriver driver,int waitTime) {
		 
		 try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("wait block in baseUtility");
//			e.printStackTrace();
		}
	}
	
	
	public static HashMap<Object, Object> readtestData(String excelFilePath, String sheetName, int testCaseId) throws IOException {
		// TODO Auto-generated method stub
		 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int cellCount = sheet.getRow(testCaseId).getLastCellNum();
		 int i=0;
//		 testData = new Map<String, String>
		 HashMap<Object, Object> testData = new HashMap<Object, Object>();
	        while(i<cellCount) {
	        	testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(testCaseId).getCell(i).toString());
	        	i++;
	        }
	        workbook.close();
        	fileInputStream.close();
	        return testData;
		}
	
	 public static void writetestResult(String excelFilePath, String sheetName, int testCaseId, String headrName, String data) {
//		 FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
//		 XSSFWorkbook workbook = new XSSFWorkbook(fileOutputStream);
//		 XSSFSheet sheet = workbook.getSheet(sheetName);
//		 int headerIndex;
//		XSSFCell newCell = sheet.getRow(testCaseId).createCell(headerIndex);
//	        workbook.write(fileOutputStream);
//	        workbook.close();
//	        fileOutputStream.close();
		}
	 
	 public void closeBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}
}
