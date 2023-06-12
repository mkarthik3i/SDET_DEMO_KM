package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hotel.utill.BasePage;

public class confirmPage extends BasePage {
	
	WebDriver driver;
	
	public confirmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Confirm Details + Book
	@FindBy(how = How.CLASS_NAME, using = "nbf_fancyimg_payment_pageheader") 
	private WebElement txt_confirm_details;
	
	//Booknow Button
	@FindBy(how = How.ID, using = "nbf_booknow_button") 
	private WebElement btn_booknow;
	
	
	public boolean verify_confirmPage() {
		return txt_confirm_details.isDisplayed();
		
	}
	
	public boolean verify_booknow_button() {
		return btn_booknow.isEnabled();
	}

}
