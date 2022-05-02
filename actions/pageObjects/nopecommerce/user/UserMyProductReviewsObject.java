package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.user.UserMyProductReviewsUI;

public class UserMyProductReviewsObject  extends BasePage {
	
	WebDriver driver;
	public UserMyProductReviewsObject(WebDriver driver) {
		this.driver = driver;
	} 


	public String getTitleReview() {
		waitForElementVisible(driver, UserMyProductReviewsUI.REVIEW_TITLE);
		return getElementText(driver, UserMyProductReviewsUI.REVIEW_TITLE);
	}
	
	public String getTextReview() {
		waitForElementVisible(driver, UserMyProductReviewsUI.REVIEW_TEXT);
		return getElementText(driver, UserMyProductReviewsUI.REVIEW_TEXT);
	}
	
	
	public String getProductNameReview() {
		waitForElementVisible(driver, UserMyProductReviewsUI.PRODUCT_NAME_REVIEW);
		return getElementText(driver, UserMyProductReviewsUI.PRODUCT_NAME_REVIEW);
	}

}
