package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String excelFilePath="C:\\Automation\\Selenium\\src\\test\\resources\\testData\\automationTestData.xlsx";
		
        System.out.println(1);
//        ------------------------------------
//        to return the column index of the give column name
//        HashMap<String, String> testData = readtestData(excelFilePath, "TestData", 1);
        
        Object[][] data = dataProviderTestData(excelFilePath, "TestData", "regression");
        
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                System.out.println("Values at arr["+i+"]["+j+"] is "+data[i][j]);
            }
        }
//        String headerName = "firstName";
//        String data1 = getTestData(testData, headerName);
//        System.out.println(data1);
//        String data2 = getTestData(testData,"productName");
//        System.out.println(data2);
//        ------------------------------------------
	}
	
	private static XSSFWorkbook openexcel(String excelFilePath) throws IOException {
		// returns workbook object for given excel path
		 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
	     return workbook;
	}
	 static void closeExcel(FileInputStream fileInputStream) throws IOException {
		// closes FileInputStream object
		  fileInputStream.close();
	}
	
	static int returnHeaderIndex(Sheet sheet, String headerName) {
		// this would return the column number where the given header string is searched
		System.out.println("in returnHeaderIndex");
		int cellCount = sheet.getRow(0).getLastCellNum();
        int i=0, index=0;
        while(i<cellCount) {
        	if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(headerName))
        	{
        		System.out.println("value of i ="+i);
        		index=i;
        		break;
        	}
        	else i++;
        }
        System.out.println("out returnHeaderIndex with value"+ i);
        return index;
	}
	
	static String getTestData(HashMap<String, String> testData, String headerName) {
		//return the key value of the given string by searching the testdata hash map returned from readtestData method
		
		String temp = testData.get(headerName);
		return temp;
	}
	
	 static HashMap<String,String> readtestData(String excelFilePath, String sheetName, int testCaseId) throws IOException {
		// creates the hash map from the given excel path & sheet name. Returns hash map for single row as per given testcaseId
		 
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
	
	 static Object[][] dataProviderTestData(String excelFilePath, String sheetName, String testCaseType) throws IOException {
		// return the Object[][] array based on the testcaseType 
		 FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		  XSSFSheet sheet = workbook.getSheet(sheetName);
		  int testcasetypeindex = returnHeaderIndex(sheet, "testType");
		  int j=1, Objectsize = 0;
		  
		  while (j<=sheet.getLastRowNum()) {
			  System.out.println("ojectsize while loop with testcasetype = "+testCaseType);
			  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
			  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
			  if(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType)) {
				  Objectsize++;
			  }
			j++;  
		  }
		  System.out.println("object size" + Objectsize);
		  Object[][] testdata = new Object[Objectsize][sheet.getRow(0).getLastCellNum()];
//		  String [] testdatalist = new String[sheet.getRow(0).getLastCellNum()];
		  j=1;
		  System.out.println("last row number"+sheet.getLastRowNum());
		  System.out.println("last cel number"+ sheet.getRow(0).getLastCellNum());
		  while (j<=sheet.getLastRowNum()) {
			  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString());
			  System.out.println(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType));
		  if(sheet.getRow(j).getCell(testcasetypeindex).toString().contains(testCaseType)) {
			  int cellCount = sheet.getRow(j).getLastCellNum();
				 int i=0;
				 System.out.println("in if");
			        while(i<cellCount) {
			        	System.out.println("header "+sheet.getRow(0).getCell(i).toString());
			        	System.out.println("value of j - "+j+", j th "+sheet.getRow(j).getCell(i).toString());
			        	testdata[j-1][i]= sheet.getRow(j).getCell(i).toString();
//			        	testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(testCaseId).getCell(i).toString());
			        	i++;
			        }
		  	}
		  j++;
		  }
		  fileInputStream.close();
		  return testdata;
	}
}
