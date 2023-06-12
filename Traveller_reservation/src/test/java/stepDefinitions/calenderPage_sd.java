package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.hotel.pages.bookPage;
import com.hotel.utill.BasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class calenderPage_sd extends BasePage{

	//Scenario:3
	@When("Select the available date in the calendar")
	public void select_the_first_available_date_in_the_calendar() {
		bookpage = new bookPage(driver);
		try {
			bookpage.navigateSelectDatePage();
			bookpage.selectDate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@When("Select {int} adults from the drop down")
	public void select_adult_from_the_drop_down(Integer int1) {
		String num = int1.toString();
		bookpage.selectNoAdult(num);
	}
	@Then("verify the price calculation")
	public void verify_the_price_calculation() {
		assertTrue(bookpage.verifyPrice(), "The Price hasn't displayed");
	}
	@Then("click {string} button on calender page")
	public void choose_book_online_button(String str) {
	bookpage.clickOnlinebook();				
	}
		
	@Then("verify the user lands to traveller accommodation page")
	public void verify_navigate_to_passenger_accomdation_page() {
		assertTrue(bookpage.verify_accomdation_page(), " The passenger Accomdation page hasn't dispalyed ");
	}
//---------------	
}
