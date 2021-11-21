package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.user.UserCustomerInfoUI;

public class UserCustomerInfoObject extends BasePage {
	WebDriver driver;
	public UserCustomerInfoObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplay() {
		waitForElementVisible(driver, UserCustomerInfoUI.HEADING_CUSTOMER_INFO);
		return isElementDisplay(driver, UserCustomerInfoUI.HEADING_CUSTOMER_INFO);
	}
}
