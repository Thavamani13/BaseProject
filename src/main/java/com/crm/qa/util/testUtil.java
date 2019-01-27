package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.WorkbookNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.sun.media.sound.InvalidFormatException;



public class testUtil extends TestBase {
	
	

	public static  long page_load_timeout = 100;
	public static  long implicity_wait =100; 
	
	public static String TESTDATA_SHEET_PATH = "D:\\MyProject\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xls";
	
      	
	
	static Workbook book;
	
	static Sheet sheet;
	
	
	public testUtil() throws IOException {
		super();
	}

	
	
	
	public   void switchtoframe() {
		
		driver.switchTo().frame("mainpanel") ;
	}
	
	
	public static Object[][] getTestData(String sheetName) throws FileNotFoundException, org.apache.poi.openxml4j.exceptions.InvalidFormatException   {
		
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);

		
		/*try {
			file = 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			*/
			
			
		   try {
				book=WorkbookFactory.create(file);
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		
		
		 sheet = book.getSheet(sheetName);
		 
		 Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		
		
	   for (int i = 0; i < sheet.getLastRowNum(); i++) {
		   
		   for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			             
			   // data[i][k] = sheet.getRow(i + 1).getCell(k).toString();


                System.out.println(data[i][k]);
		   }
	   }
	   
	   return data;
	   }
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	
		
         
         
         
         
         
        
		
		
		
		
	
	

}
