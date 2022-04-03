package pageObjects.nopecommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopecommerce.admin.AdminDashboardPageUI;
import pageUIs.nopecommerce.user.UserRegisterPageUI;

public class AdminDashboardPageObject extends BasePage{
	
	WebDriver driver;
	
	public  AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Text heading DashBoard")
	public String getTextHeadingDashBoard() {
		waitForElementVisible(driver, AdminDashboardPageUI.HEADING_TEXT_DASHBOARD);
		return getElementText(driver,  AdminDashboardPageUI.HEADING_TEXT_DASHBOARD);
	}

}
