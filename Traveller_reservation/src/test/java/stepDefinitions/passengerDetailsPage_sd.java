package stepDefinitions;

import static org.testng.Assert.assertTrue;

import com.hotel.pages.confirmPage;
import com.hotel.pages.passengerPage;
import com.hotel.utill.BasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class passengerDetailsPage_sd extends BasePage {
	

	//Scenario:5
					@When("Enter the mandatory fields in passenger details page")
					public void enter_the_mandatory_fields_in_passenger_details_page() throws InterruptedException {
					    passengerpage = new passengerPage(driver);
					    passengerpage.navigatePassenger_details_page();
					    passengerpage.enterPassenger_details();
					    Thread.sleep(3000);
					}
					
					@When("Click {string} button on passenger details page")
					public void clickContinue(String string) {
						try {
							passengerpage.clickContiue();
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};
					
					@Then("Verify the traveller Confirmation Details on the page")
					public void verify_the_confirmation_details_on_the_page() {
						confirmpage = new confirmPage(driver);
						assertTrue(confirmpage.verify_confirmPage(), "The Confirm Detail page hasn't displayed");
					}
					
			
					@Then("Verify the {string} button is enabled")
					public void verify_the_button_is_enabled(String string) {
						assertTrue(confirmpage.verify_booknow_button(), "The Booknow buttn hasn't enabled");
					}


}
