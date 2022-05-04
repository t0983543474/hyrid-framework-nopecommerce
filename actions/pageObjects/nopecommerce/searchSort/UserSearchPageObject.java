package pageObjects.nopecommerce.searchSort;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.nopecommerce.searchSort.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public String getWarningMessage() {
		waitForElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE);
		return getElementText(driver, UserSearchPageUI.WARNING_MESSAGE);
	}
	
	public String getNoDataMessage() {
		waitForElementVisible(driver, UserSearchPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NO_DATA_MESSAGE);
	}
	
	public List<String> getListSearchResult(){
		List<String> titleLists = new ArrayList<>();
		waitForAllElementVisible(driver, UserSearchPageUI.LIST_PRODUCT_NAME);
		List<WebElement> list = getWebElements(driver, UserSearchPageUI.LIST_PRODUCT_NAME);
		for (WebElement webElement : list) {
			titleLists.add(webElement.getText());
		}
		return titleLists;
	}
}
