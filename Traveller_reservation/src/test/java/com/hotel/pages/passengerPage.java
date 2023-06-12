package com.hotel.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotel.utill.BasePage;
import com.hotel.utill.ConfigFileReader;

public class passengerPage extends BasePage {
	
	WebDriver driver;
	
	public passengerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		//  Passenger1 Title1
		@FindBy(how = How.ID, using = "pax-a-title-1") 
		private WebElement sel_passenger_title1;

		// Passenger2 Title2
		@FindBy(how = How.ID, using = "pax-a-title-2") 
		private WebElement sel_pax_title2;
		
		// Passenger-1 firstname1
		@FindBy(how = How.ID, using = "pax-a-first-1") 
		private WebElement txt_pax_firstname1;
		
		//Passenger2 firstname2
		@FindBy(how = How.ID, using = "pax-a-first-2") 
		private WebElement txt_pax_firstname2;

		// AdultPassenger-1 lastname1
		@FindBy(how = How.ID, using = "pax-a-last-1") 
		private WebElement txt_pax_lastname1;
		
		// Passenger2 lastname2
		@FindBy(how = How.ID, using = "pax-a-last-2") 
		private WebElement txt_pax_lastname2;
	
		// Passenger-1 date
		@FindBy(how = How.ID, using = "pax-a-dobd-1") 
		private WebElement sel_pax1_date;
		
		// Passenger2 date
		@FindBy(how = How.ID, using = "pax-a-dobd-2") 
		private WebElement sel_pax2_date;	
		
		// Passenger-1 month
		@FindBy(how = How.ID, using = "pax-a-dobm-1") 
		private WebElement sel_pax1_month;
		
		// Passenger2 month
		@FindBy(how = How.ID, using = "pax-a-dobm-2") 
		private WebElement sel_pax2_month;	

		// Passenger-1 month
		@FindBy(how = How.ID, using = "pax-a-doby-1") 
		private WebElement sel_pax1_year;
		
		// Passenger2 month
		@FindBy(how = How.ID, using = "pax-a-doby-2") 
		private WebElement sel_pax2_year;
		
		//Primary Contact Name
		@FindBy(how = How.ID, using = "contact-name") 
		private WebElement txt_contact_name;
		
		//Primary Email-Id
		@FindBy(how = How.ID, using = "contact-email") 
		private WebElement txt_contacte_mail;
		
		//Primary Mobile Number
		@FindBy(how = How.ID, using = "contact-mobile") 
		private WebElement txt_contact_mobilenumber;
		
		//Primary Address Line 1
		@FindBy(how = How.ID, using = "contact-address1") 
		private WebElement txt_contact_address1;
		
		//Primary Address Line 2
		@FindBy(how = How.ID, using = "contact-address2") 
		private WebElement txt_contact_address2;

		//City
		@FindBy(how = How.ID, using = "contact-city") 
		private WebElement txt_contact_city;
		
		//Post Code
		@FindBy(how = How.ID, using = "contact-postcode") 
		private WebElement txt_postcode;
		
		//wheredidyouhear
		@FindBy(how = How.ID, using = "contact-hearabout") 
		private WebElement sel_hearabout;
		
		//Continue Button
		@FindBy(how = How.CSS, using = ".nbf_fancy_paxButton.nbf_fg_pms_button_text") 
		private WebElement btn_continue;
		
		
		public boolean verify_passengerInfoPage() {
			return txt_pax_firstname1.isDisplayed();
			
		}
		
		public void navigatePassenger_details_page() {
			bookpage = new bookPage(driver);
			try {
				bookpage.navigateSelectDatePage();
				bookpage.selectDate();
				bookpage.selectNoAdult("dummy");
				bookpage.clickOnlinebook();
				bookpage.chooseRoom();
				bookpage.click_continue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void enterPassenger_details() throws InterruptedException {
			configFile = new ConfigFileReader();
			
			// First Passenger details
			Select title1 = new Select(sel_passenger_title1);
			title1.selectByValue(configFile.get_title());
			txt_pax_firstname1.sendKeys(configFile.get_firstname1());
			txt_pax_lastname1.sendKeys(configFile.get_lastname1());
			sel_pax1_date.sendKeys(configFile.get_pax1_date());
			sel_pax1_month.sendKeys(configFile.get_pax1_month());
			sel_pax1_year.sendKeys(configFile.get_pax1_year());
			
			//Second Passenger details
			Select title2 = new Select(sel_pax_title2);
			title2.selectByValue(configFile.get_title());
			txt_pax_firstname2.sendKeys(configFile.get_firstname2());
			txt_pax_lastname2.sendKeys(configFile.get_lastname2());
			sel_pax2_date.sendKeys(configFile.get_pax2_date());
			sel_pax2_month.sendKeys(configFile.get_pax2_month());
			sel_pax2_year.sendKeys(configFile.get_pax2_year());
			
			//Primary Passenger Details
			txt_contact_name.sendKeys(configFile.get_firstname1()+ configFile.get_lastname1());
			txt_contact_mobilenumber.sendKeys(configFile.getMobileNumber());
			txt_contacte_mail.sendKeys(configFile.getEmail());
			txt_contact_address1.sendKeys(configFile.getAddress1());
			txt_contact_address2.sendKeys(configFile.getAddress2());
			txt_contact_city.sendKeys(configFile.getCity());
			txt_postcode.sendKeys(configFile.getPincode());
			sel_hearabout.sendKeys(configFile.gethearabout());
			Thread.sleep(2000);

		}
		
		public void clickContiue() {
			try {
				btn_continue.click();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
