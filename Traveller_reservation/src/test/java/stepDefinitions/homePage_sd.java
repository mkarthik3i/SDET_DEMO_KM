package stepDefinitions;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;

import com.hotel.pages.HomePage;
import com.hotel.utill.BasePage;
import com.hotel.utill.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePage_sd extends BasePage{
	
//Scenarios:1	
		@Given("Launch the application")
		public void launch_the_application() throws Exception {
			try {
			homePage = new HomePage(driver);
			}catch(Exception e) {
				Reporter.log("The Application is not Launched", true);
				
			}
		}
		
		@When("Click {string} button on Home Page")
		public void click_button_on_home_page(String string) throws InterruptedException {
			homePage.acceptCookies();
		}
		
		@Then("Verify {string} button is disappeared")
		public void verify_the_all_cookies_button_disabled(String string) throws InterruptedException {
			Thread.sleep(3000);
			assertTrue(homePage.allCookies_disabled(), "The All cookies popup hasn't dispalyed");
		}
		
//Scenarios:2
		
		@When("Search {string} in search box")
		public void search_in_search_box(String str) throws InterruptedException {
			homePage.acceptCookies();
		    homePage.searchText(str);
		}
		
		@Then("Select {string} in dynamic dropdown")
		public void select_india_in_bootstrap_drop_down(String str) {
			configFile = new ConfigFileReader();
			try {
				homePage.getSearchLink(configFile.getCountry());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
		@Before
		public void setupDriver() {
			executionSetUp();
		}
		
		@After
		public void closeBrowser() {
			tearDown();
		}

}

