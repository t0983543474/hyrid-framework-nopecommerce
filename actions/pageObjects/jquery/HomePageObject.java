package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickPageNumber(String number) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_NUMBER, number);
		clickToElement(driver, HomePageUI.PAGINATION_NUMBER, number);
	}
	
	public boolean isActivePageNumber(String number) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_ACTIVE_NUMBER, number);
		return isElementDisplay(driver,HomePageUI.PAGINATION_ACTIVE_NUMBER,  number);
	}

}
