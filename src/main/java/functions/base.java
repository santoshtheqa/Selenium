package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	 public static WebDriver openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
//		options.addArguments("--disable-application-cache");
		WebDriver driver= new ChromeDriver(options);
		 return driver;
	}
	
	 public static void goToUrl(String Url,WebDriver driver) {
		driver.get(Url);
	}
	
	
	
	public static HashMap<String,String> readtestData(String excelFilePath, String sheetName, int testCaseId) throws IOException {
		// TODO Auto-generated method stub
		 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int cellCount = sheet.getRow(0).getLastCellNum();
		 int i=0;
		 HashMap<String, String> testData = new HashMap<String, String>();
	        while(i<cellCount) {
	        	testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(testCaseId).getCell(i).toString());
	        	i++;
	        }
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
	 
	 public static void closeBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}
}
