package common;

import org.openqa.selenium.WebDriver;

import pageObjects.jquery.HomePageObject;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;


public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomPageObject(WebDriver driver) {
		return  new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPageeObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerInfoObject getUserCustomerPageObject(WebDriver driver) {
		return new UserCustomerInfoObject(driver);
	}
	
	public static UserAddressesPageObject getUserAddressesPageObject(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserMyProductReviewsObject getUserMyProductReviewsObject(WebDriver driver) {
		return new UserMyProductReviewsObject(driver);
	}
	public static UserRewardPonitObject getUserRewardPonitObject(WebDriver driver) {
		return new UserRewardPonitObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	// Jquery DataTable 

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}


}
