package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.CustomerInfoUI;

public class CustomerInfoObject extends BasePage {
	WebDriver driver;
	public CustomerInfoObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplay() {
		waitForElementVisible(driver, CustomerInfoUI.HEADING_CUSTOMER_INFO);
		return isElementDisplay(driver, CustomerInfoUI.HEADING_CUSTOMER_INFO);
	}
}
