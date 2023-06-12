package stepDefinitions;

import static org.testng.Assert.assertTrue;

import com.hotel.pages.bookPage;
import com.hotel.pages.passengerPage;
import com.hotel.utill.BasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accomdationPage_sd extends BasePage {
	
	//Scenario:4
	@When("Expand the Date, Departure & traveller page")
	public void expand_the_date_departure_passengers_section() {
		try {
			bookpage = new bookPage(driver);
			bookpage.navigateAccomdation_page();
			bookpage.expandDateDepartureSection();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("Verify displayed the Date and Departure details")
	public void verify_populated_details_are_valid() {
		assertTrue(bookpage.verify_no_of_adult_date_departure_section(),"The No of Adult details hasnt't displayed in Date & Departure Section");
		assertTrue(bookpage.verify_departure_date_in_departure_section(),"The departure date info hasnt't displayed in Date & Departure Section");
		assertTrue(bookpage.verify_departure_arport_date_departure_section(),"The departure airport info hasnt't displayed in Date & Departure Section");
	}
	
	@When("Select {int} people in accommodation page")
	public void select_people_in_accommodation_section(Integer int1) throws InterruptedException {
		bookpage.expandDateDepartureSection(); 
		Thread.sleep(2000);
		bookpage.chooseRoom();
	}
	
	
	@When("Click {string} button")
	public void click_button(String string) {
		bookpage.click_continue();
	}
	
	@Then("Verify the user lands traveller details page")
	public void verify_user_can_navigate_the_passengers_details_page() {
		passengerpage = new passengerPage(driver);
		assertTrue(passengerpage.verify_passengerInfoPage(),"The Passenger details page hasnt displayed");
	}

}
