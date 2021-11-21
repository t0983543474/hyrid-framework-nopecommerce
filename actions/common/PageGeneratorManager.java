package common;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewsObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPonitObject;


public class PageGeneratorManager {
	
	public static HomePageObject getHomPageObject(WebDriver driver) {
		return  new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageeObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static CustomerInfoObject getCustomerPageObject(WebDriver driver) {
		return new CustomerInfoObject(driver);
	}
	
	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static MyProductReviewsObject getMyProductReviewsObject(WebDriver driver) {
		return new MyProductReviewsObject(driver);
	}
	public static RewardPonitObject getRewardPonitObject(WebDriver driver) {
		return new RewardPonitObject(driver);
	}

}
