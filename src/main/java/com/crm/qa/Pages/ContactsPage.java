package com.crm.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement conatcslabel;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement salutation;
	
	@FindBy(name = "first_name")
	WebElement firstname;
	
	@FindBy(name = "surname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyname;
	
	
	@FindBy(xpath="(//input[@class='button'])[2]")

	WebElement savebutton; 
	
	
	   public ContactsPage() throws IOException {
    	    
		PageFactory.initElements(driver,this);
		
	}
       
       
       public boolean verifyContactsLabel() {
    	   
    	   return conatcslabel.isDisplayed();
    	   
       }
       
       
       public void SelectContactsByName(String name) {
    	   
    	   
    	   driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
    	   		+ "//preceding-sibling::td[@class='datalistrow']")).click();
    	   
       }
       
       
       public void CreateNewContact(String title,String fname,String lname, String compname) {
    	   
    	   Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='title']")));
    	   dropdown.selectByVisibleText(title);
    	   
    	   firstname.sendKeys(fname);
    	   lastname.sendKeys(lname);
    	   companyname.sendKeys(compname);
    	   
    	   savebutton.click();
    	   
       }
       

}
