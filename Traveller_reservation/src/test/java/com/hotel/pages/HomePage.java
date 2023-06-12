package com.hotel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hotel.utill.BasePage;
import com.hotel.utill.ConfigFileReader;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	// Search Box 
	@FindBy(how = How.ID, using = "searchtext_freetext_search_form") 
	private WebElement txt_searchText;
	
	// Accept All Cookies
	@FindBy(how = How.ID, using = "onetrust-accept-btn-handler") 
	private WebElement btn_acceptCookie;
	
	// Search text field
	@FindBy(how = How.ID, using = "as_searchtext_freetext_search_form") 
	private WebElement lnk_searchtext;
	
	
	public void acceptCookies() throws InterruptedException {
		configFile = new ConfigFileReader();
		Thread.sleep(2000);
		System.out.println("driver = " + driver);
		btn_acceptCookie.click();
		Thread.sleep(3000);
	}
	
	public boolean allCookies_disabled() {
		return btn_acceptCookie.isEnabled();
	}
	
	public void searchText(String str) {
		
		try {
			txt_searchText.sendKeys(str);
			Thread.sleep(3000);
			getSearchLink("test");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getSearchLink(String Str) throws InterruptedException {
		List<WebElement> link = driver.findElements(By.tagName("div").tagName("a"));
		int test = link.size();
		for(int i=0; i<test; i++)
		{
			if(link.get(i).getText().contains(configFile.getCountry()))
			{
				link.get(i).click();
				Thread.sleep(3000);
				break;
			}
			
		}
	}
	
}





