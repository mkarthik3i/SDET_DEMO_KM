package com.hotel.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.hotel.utill.BasePage;
import com.hotel.utill.ConfigFileReader;





public class bookPage extends BasePage {
	
	WebDriver driver;
	
	public bookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	ConfigFileReader configFile;
	
	// Radion Button to select available date
	@FindBy(how = How.CLASS_NAME, using = "pms_pricing_update") 
	private WebElement radio_date;
	
	//Click Calender Next Month arrow mark
	@FindBy(how = How.CSS, using = ".nbf_tpl_pms_calendar_next.nbf_tpl_pms_calendar_update") 
	private WebElement btn_next;
	
	
	//get Calender Price
	@FindBy(how = How.CSS, using = ".nbf_tpl_pms_calendar_price") 
	private WebElement txt_getCalenderPrice;
	
	// Total price
	@FindBy(how = How.CSS, using = "#tour-price") 
	private WebElement txt_total_price;
	
	// Book Online Button
	@FindBy(how = How.CSS, using = "div[id='book-button'] div[class='nbf_fancyimg_pms_add_button nbf_fg_pms_button_text nbf_bg_pms_button nbf_fg_pms_button_text ']") 
	private WebElement btn_bookOnline;
	
	// select no of room
	@FindBy(how = How.XPATH, using = ".//div[4]/select[1]") 
	private WebElement selc_room;
	
	// select adult count
	//@FindBy(how = How.ID, using = "room-1859919-1-adults") 
	//private WebElement selc_adult;
	
	// Select_your_rooms Button
	@FindBy(how = How.CSS, using = ".nbf_fancy_nbf_tpl_pms_book_room.nbf_fg_pms_button_text") 
	private WebElement btn_Select_your_rooms;
	
	// Passenger count
	@FindBy(how = How.CSS, using = ".nbf_tpl_pms_bf_passenger_number.unit.size1of2.lastUnit") 
	private WebElement txt_passenger_count;
	
	
	// Passenger departure date
	@FindBy(how = How.CLASS_NAME, using = "nbf_tpl_pms_bf_departuredate") 
	private WebElement txt_departureDate;
		 
	
	//Expand Date and Departure 
	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='1. Date, Departure & Passengers']") 
	private WebElement lnk_date_departure;
	
	//Expand Accomdation Page
	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='3. Accommodation']") 
	private WebElement lnk_accomdation;
	
	//Passengers Adults in Date, Departure & Passengers section
	@FindBy(how = How.CSS, using = ".nbf_tpl_pms_bf_passenger_number.unit.size1of2.lastUnit") 
	private WebElement txt_no_of_adult;
	
	
	//Departure date in Date, Departure & Passengers section
	@FindBy(how = How.CSS, using = ".nbf_tpl_pms_bf_departuredate") 
	private WebElement txt_departure_date;
	
	
	//Departure Airport: in Date, Departure & Passengers section
	@FindBy(how = How.CSS, using = "span[dir='ltr']") 
	private WebElement txt_departure_arport;
	
	
	
	public void navigateSelectDatePage() throws InterruptedException {
		homePage = new HomePage(driver);
		configFile = new ConfigFileReader();
		homePage.acceptCookies();
		homePage.searchText(configFile.getCountry());
		homePage.getSearchLink(configFile.getCountry());
	}
	
	
	public void navigateAccomdation_page() {
		bookpage = new bookPage(driver);
		configFile = new ConfigFileReader();
		try {
			bookpage.navigateSelectDatePage();
			bookpage.selectDate();
			bookpage.selectNoAdult("dummy");
			bookpage.clickOnlinebook();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDate() throws InterruptedException {
		try {
			radio_date.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			btn_next.click();
			Thread.sleep(2000);
			radio_date.click();
		}
		Thread.sleep(3000);
	}
	
	public void selectNoAdult(String num) {
		try {
			
			List<WebElement> sel = driver.findElements(By.tagName("select"));
			//sel.get(0).sendKeys("London Heathrow");
			sel.get(0).sendKeys(configFile.get_no_of_adult());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verifyPrice() {
		
		//getCalender Price
		WebElement ele2 = txt_getCalenderPrice.findElement(By.cssSelector(".ibecurr"));
		String getCalenderPrice = ele2.getAttribute("data-amt");
				
		//Calculate No of Passenger cost
		 int getPassengerCount = Integer.parseInt(configFile.get_no_of_adult());
		 System.out.println(getCalenderPrice);
		 
		 double d = Double.parseDouble(getCalenderPrice);
		 int getPriceCalender = (int) d;
		 int actualCost = getPriceCalender * getPassengerCount;
		 
		//getTotalPrice
		 int getTotalPrice = 0;
		 try {
		 String getPrice = driver.findElement(By.cssSelector(".ibecurr[data-amt="+"'"+actualCost+"']")).getAttribute("data-amt");
		 getTotalPrice = Integer.parseInt(getPrice);
		 }catch(Exception e) {
			 Reporter.log("The Price mismatch in Actual cost = "+actualCost+" vs Total Cost");
		 }; 
		 
		 if(actualCost == getTotalPrice)
		 {
			 Reporter.log("The Price match with Actual cost = "+actualCost+" vs Total Cost = "+getTotalPrice);
			 return true;
			 
		 }else {
			 return false;
		 }
	}
	
	public void clickOnlinebook() {
		try {
			btn_bookOnline.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chooseRoom() {
		
		try {
			Select sel = new Select(selc_room);
			sel.selectByValue(configFile.get_no_of_rooms());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click_continue() {
		
		try {
			btn_Select_your_rooms.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verify_accomdation_page() {
		return btn_Select_your_rooms.isDisplayed();
	}
	
	public void expandDateDepartureSection() {
		lnk_date_departure.click();
	}
	
	public void expandAccomdation() {
		lnk_accomdation.click();
	}
	
	public boolean verify_no_of_adult_date_departure_section() {
		return txt_no_of_adult.isDisplayed();
	}
	
	public boolean verify_departure_date_in_departure_section() {
		return txt_departure_date.isDisplayed();
	}
	
	public boolean verify_departure_arport_date_departure_section() {
		return txt_departure_arport.isDisplayed();
		
	}
}
