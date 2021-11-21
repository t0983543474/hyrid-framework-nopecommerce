package common;

import org.openqa.selenium.WebDriver;

import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;


public class PageGeneratorManager {
	
	public static UserHomePageObject getHomPageObject(WebDriver driver) {
		return  new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getRegisterPageeObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerInfoObject getCustomerPageObject(WebDriver driver) {
		return new UserCustomerInfoObject(driver);
	}
	
	public static UserAddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserMyProductReviewsObject getMyProductReviewsObject(WebDriver driver) {
		return new UserMyProductReviewsObject(driver);
	}
	public static UserRewardPonitObject getRewardPonitObject(WebDriver driver) {
		return new UserRewardPonitObject(driver);
	}

}
