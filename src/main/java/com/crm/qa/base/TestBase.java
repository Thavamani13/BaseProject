package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.testUtil;

public  class TestBase {
	
	
	public static  WebDriver driver;
	
	public static   Properties prop;// To use in child class as well
	
	public static EventFiringWebDriver e_driver;
	
	public static WebEventListener 	eventlistner;

	
	
	
	// 1-->Create a constructor
	public TestBase() throws IOException {
		
		prop = new Properties();
		
		  try {
			  
			FileInputStream input = new FileInputStream("D:\\MyProject\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			prop.load(input);
			
		} 
		  
		  catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		  

		  catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void initilization() throws IOException {
		
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			}
		
		else if(browsername.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./Drivers/FirefoxDriver.exe");
			driver = new FirefoxDriver();
			}
		
          driver.manage().window().maximize();		
          driver.manage().deleteAllCookies();
          
          driver.manage().timeouts().pageLoadTimeout(testUtil.page_load_timeout, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(testUtil.implicity_wait, TimeUnit.SECONDS);
          
          driver.get(prop.getProperty("url"));
          
          
          
          e_driver = new EventFiringWebDriver(driver);
          
          eventlistner = new WebEventListener() ;
          
          e_driver.register(eventlistner);
          
          
          driver=e_driver;
          
          
          
          driver.manage().window().maximize();		
          driver.manage().deleteAllCookies();
          
          driver.manage().timeouts().pageLoadTimeout(testUtil.page_load_timeout, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(testUtil.implicity_wait, TimeUnit.SECONDS);
          
          driver.get(prop.getProperty("url"));
          
	}
	
	

}
