package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.testUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	
	HomePage homepage;
	
	testUtil testutility;
	
	ContactsPage  contactsPage;
	
	
	
	
	//Create a constructor
	public HomePageTest() throws IOException {
		
		super();
	}
	
	
	@BeforeMethod()
	
	public void setup() throws IOException, InterruptedException {
		
		initilization();
		
		testutility = new testUtil();
		
		loginpage = new LoginPage();
		
		contactsPage = new  ContactsPage();
		
		
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest() {
		
		String homepagetitle = homepage.VerifyHomePageTitle();
		
		Assert.assertEquals(homepagetitle, "CRMPRO","The Home page title is incorrect");
	} 
	
	@Test(priority=2)
	
	public void VerifyUserNameTest() {
		
		testutility.switchtoframe();
		
		homepage.verifyCorrectUsername();
		Assert.assertTrue(true);
		
	}
	
	@Test(priority= 3)
	
	public void VerifyContactLinkTest() throws IOException {
		
		
		testutility.switchtoframe();
		
		 contactsPage = homepage.ClickOnContactsLink();
		
		}
	
	
	
	@AfterMethod()
	
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	


}
