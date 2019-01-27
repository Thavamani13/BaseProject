package com.crm.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	ContactsPage contactsPage;
	
	
	@FindBy(xpath = "//td[contains(text(),\"User: Thavamani Murugan\")]" )
	
	WebElement namelabel;
	
	
	@FindBy(xpath="//a[text()='Contacts']")
	
	WebElement contactslink;
	
    @FindBy(xpath="//a[text()='Deals']")
	
	WebElement Dealslink;

    @FindBy(xpath="//a[text()='Tasks']")

    WebElement taskslink;  
    
    @FindBy(xpath="//a[text()='New Contact']")
    WebElement NewContactsLink;		
    		
    		
    
    ///Create Constructor to initilaize the page objects
    
    public HomePage() throws IOException {
    	
    	PageFactory.initElements(driver, this);
	
	}

    //Define Your Methods
    
    
    public String VerifyHomePageTitle() {
    	
    	return driver.getTitle();
     }
    
    public ContactsPage ClickOnContactsLink() throws IOException {
    	
    	contactslink.click();
    	
    	return new ContactsPage();
    }
    
    public DealsPage ClickOnDealsPage() throws IOException {
    	
    	Dealslink.click();
    	
    	return new DealsPage();
    }
    
    public TaskPage ClickOnTaskLink() throws IOException {
    	
    	taskslink.click();
    	
    	return new TaskPage();
    	
    }
    
    
    public boolean verifyCorrectUsername() {
    	
    	return namelabel.isDisplayed(); 
    	
    	 }
    
    public ContactsPage clickOnNewContactLink() throws InterruptedException, IOException {
    	
    	
    	Actions action= new Actions(driver);
    	
    	action.moveToElement(contactslink).build().perform();
    	
    	Thread.sleep(3000);
    	
    	NewContactsLink.click();
    	
    	return new ContactsPage();
    	
    	
    	 
    }
    
    
    
}
