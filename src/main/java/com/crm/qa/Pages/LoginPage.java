package com.crm.qa.Pages;

import java.io.IOException;
import java.lang.annotation.Native;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//page Factory Object repository

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginbutton;
	
	
	@FindBy(xpath="(//a[@href='https://www.freecrm.com/register/'])[1]")
	WebElement signupbutton;
	
	@FindBy(xpath="(//img[contains(class,img-responsive)])[1]")
	WebElement crmlogo;  
	
	//Initialization of PageObject
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);

	}
	
	//Methods defining perform on that particular page
	
	public String verifyLoginPagetitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		
	  return  crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws IOException, InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		Thread.sleep(3000);
		
		loginbutton.click(); // after clicking the lands on Homepage
		
		return new HomePage() ;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

	
	

}
