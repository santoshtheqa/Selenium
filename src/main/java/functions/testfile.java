package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String excelFilePath="C:/Automation/Selenium/src/main/java/testData/automationTestData.xlsx";
		
        System.out.println(1);
//        ------------------------------------
//        to return the column index of the give column name
        HashMap<String, String> testData = readtestData(excelFilePath, "TestData", 1);
        String headerName = "firstName";
        String data1 = getTestData(testData, headerName);
        System.out.println(data1);
        String data2 = getTestData(testData,"productName");
        System.out.println(data2);
//        ------------------------------------------
       
	}
	
	static int returnHeaderIndex(Sheet sheet, String headerName) {
		// TODO Auto-generated method stub
		int cellCount = sheet.getRow(0).getLastCellNum();
        int i=0;
        while(i<cellCount) {
        	if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(headerName))
        	{
        		System.out.println("value of i ="+i);
        		break;
        	}
        	else i++;
        }
		return i;
	}
	static String getTestData(HashMap<String, String> testData, String headerName) {
		String temp = testData.get(headerName);
		return temp;
	}
	
	 static HashMap<String,String> readtestData(String excelFilePath, String sheetName, int testCaseId) throws IOException {
		// TODO Auto-generated method stub
		 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int cellCount = sheet.getRow(0).getLastCellNum();
		 int i=0;
		 HashMap<String, String> testData = new HashMap<String, String>();
	        while(i<cellCount) {
	        	System.out.println(sheet.getRow(0).getCell(i).toString());
	        	testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(testCaseId).getCell(i).toString());
	        	i++;
	        }
	        
        	fileInputStream.close();
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
	        workbook.write(fileOutputStream);
	        workbook.close();
	        fileOutputStream.close();
	        return testData;
	}
	
}
