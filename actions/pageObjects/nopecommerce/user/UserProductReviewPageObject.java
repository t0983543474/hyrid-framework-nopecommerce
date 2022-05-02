package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;

import pageUIs.nopecommerce.user.UserProductReviewUI;

public class UserProductReviewPageObject extends BasePage{
	WebDriver driver;
	public UserProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public void inputReviewTitle(String title) {
		waitForElementVisible(driver, UserProductReviewUI.REVIEW_TITLE_TXT);
		sendKeyToElement(driver, UserProductReviewUI.REVIEW_TITLE_TXT, title);
	}
	
	
	public void inputReviewText(String text) {
		waitForElementVisible(driver, UserProductReviewUI.REVIEW_TEXT_AREA);
		sendKeyToElement(driver, UserProductReviewUI.REVIEW_TEXT_AREA, text);
	}
	
	public void clickSubmitReview() {
		waitForElementClickAble(driver, UserProductReviewUI.SUBMIT_BTN);
		clickToElement(driver, UserProductReviewUI.SUBMIT_BTN);
	}
	
	public String getTitleReViewPage() {
		waitForElementVisible(driver, UserProductReviewUI.REVIEW_REVIEW_PRODUCT_TITLE);
		return getElementText(driver, UserProductReviewUI.REVIEW_REVIEW_PRODUCT_TITLE);
	}

}
