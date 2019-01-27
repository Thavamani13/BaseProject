package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.testUtil;

import junit.framework.Assert;

public class ConatctsPageTest  extends TestBase{
	
	
    LoginPage loginpage;
	
	HomePage homepage;
	
	testUtil testutility;
	
	ContactsPage contactsPage; 
	
	String sheetName = "contacts";
	
	
	public ConatctsPageTest() throws IOException {
		
		super();
	}
	
	
	
	@BeforeMethod()
	
	public void setup() throws IOException, InterruptedException {
		
	 	initilization();
		
        testutility = new testUtil();
		
		loginpage = new LoginPage();
		
		contactsPage = new  ContactsPage();
		
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testutility.switchtoframe();
		
		contactsPage = homepage.ClickOnContactsLink();
		

	}
	
	
	
	@SuppressWarnings("deprecation")
	@Test()
	
	public void VerifyContacctsPageLabel() {
		
		Assert.assertEquals(contactsPage.verifyContactsLabel(),"Contacts");
		
		}
	
   @Test()
	
	public void SelectConatactsTest() {
	   
	   contactsPage.SelectContactsByName("Thavamani Murugan");
	   

   }
   
   
   @Test()
   
  public void SelectMultipleConatactsTest() {
	   
	   contactsPage.SelectContactsByName("Thavamani Murugan");
	   
	   contactsPage.SelectContactsByName("Ramkumar R");


	   
    }
   
   
   @DataProvider
   public Object[][] getCRMtestData() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException {
	   
	   Object data [][] = testUtil.getTestData(sheetName);
	   return data;
   }
   
   
   
   @Test  (dataProvider="getCRMtestData")
   
   public void validateCreateNewContact(String title,String fname,String lname,String compname) throws InterruptedException, IOException {
	   
	   homepage.clickOnNewContactLink();
	   
	  contactsPage.CreateNewContact(title, fname, lname, compname);
	   
   }
	
	
	

	@AfterMethod()
	
	public void tearDown() {
		
		driver.quit();
	}
	
	

}
