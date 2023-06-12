package com.hotel.utill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hotel.pages.HomePage;
import com.hotel.pages.bookPage;
import com.hotel.pages.confirmPage;
import com.hotel.pages.passengerPage;



public class BasePage {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	public ConfigFileReader configFile;
	public HomePage homePage;
	public bookPage bookpage;
	public passengerPage passengerpage;
	public confirmPage confirmpage;
	
	@BeforeMethod
	public void executionSetUp() {
		Reporter.log("Before execution started successfully", true);
		configFile = new ConfigFileReader();
		try {
			
			BrowserType();
			driver.get(configFile.getApplicationUrl());
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		} catch (Error err) {
			Reporter.log(err.getMessage(), true);
		}
		Reporter.log("Before Class execution completed successfully", true);
	}


	@AfterMethod
	public void tearDown() {
		Reporter.log("After Class execution started successfully");
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.log(e.getMessage(),true);
		} catch (Error err) {
			Reporter.log(err.getMessage(),true);
		}
		Reporter.log("After Class execution completed successfully",true);
	}
	
  public WebDriver BrowserType()
  
  {
	 String BrowserName = configFile.getBrowserName();
	 String driverPath = configFile.getDriverPath();
	
	 
	 try{
			if (BrowserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe"); 
				driver = new ChromeDriver();
			} else if (BrowserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		} catch (Error err) {
			Reporter.log(err.getMessage(),true);
		}
		Reporter.log("Initiate Browser Session Method execution completed successfully", true);
		return driver;
	}

	
  }
  
  






