package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.nopecommerce.product.UserProductPageUI;

public class UserProductPageObject extends BasePage {
	WebDriver driver;
	public UserProductPageObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public String getWarningMessage() {
		waitForElementVisible(driver, UserProductPageUI.WARNING_MESSAGE);
		return getElementText(driver, UserProductPageUI.WARNING_MESSAGE);
	}
	
	public String getNoDataMessage() {
		waitForElementVisible(driver, UserProductPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, UserProductPageUI.NO_DATA_MESSAGE);
	}
	
	public List<String> getListProducts(){
		List<String> titleLists = new ArrayList<String>();
		waitForElementInvisible(driver, UserProductPageUI.LOADING_ICON);
		waitForAllElementVisible(driver, UserProductPageUI.LIST_PRODUCT_NAME);
		List<WebElement> list = getWebElements(driver, UserProductPageUI.LIST_PRODUCT_NAME);
		for (WebElement webElement : list) {
			titleLists.add(webElement.getText());
		}
		return titleLists;
	}
	
	public void checkAdvanceSearch() {
		waitForElementClickAble(driver, UserProductPageUI.ADVANCE_SEARCH_CHECKBOX);
		 checkToDefaultCheckboxRadio(driver, UserProductPageUI.ADVANCE_SEARCH_CHECKBOX);
	}
	
	public void selectCategory(String category) {
		waitForAllElementVisible(driver, UserProductPageUI.CATEGORY_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserProductPageUI.CATEGORY_DROPDOWN, category);
	}
	
	public void uncheckSubCategory() {
		waitForElementClickAble(driver, UserProductPageUI.SUB_CATEGORY_CHECKBOX);
		 uncheckDefaultToCheckbox(driver, UserProductPageUI.SUB_CATEGORY_CHECKBOX);
	}
	
	public void checkSubCategory() {
		waitForElementClickAble(driver, UserProductPageUI.SUB_CATEGORY_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, UserProductPageUI.SUB_CATEGORY_CHECKBOX);
	}
	
	
	public void clickSearch() {
		waitForElementClickAble(driver, UserProductPageUI.SEARCH_BTN);
		 clickToElement(driver, UserProductPageUI.SEARCH_BTN);
	}
	
	public void selectmanufactuer(String manufactuer) {
		waitForAllElementVisible(driver, UserProductPageUI.MANUFACTUER_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserProductPageUI.MANUFACTUER_DROPDOWN, manufactuer);
	}
	
	public void selectSortBy(String sortBy) {
		waitForAllElementVisible(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserProductPageUI.SORT_BY_DROPDOWN, sortBy);
	}
	
	public void selectDisplayPerPaging(String page) {
		waitForAllElementVisible(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserProductPageUI.DISPLAY_DROPDOWN, page);
	}
	
	public List<Double> getListPrices(){
		List<Double> priceLists = new ArrayList<Double>();
		waitForElementInvisible(driver, UserProductPageUI.LOADING_ICON);
		waitForAllElementVisible(driver, UserProductPageUI.LIST_PRODUCT_PRICE);
		List<WebElement> list = getWebElements(driver, UserProductPageUI.LIST_PRODUCT_PRICE);
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
			priceLists.add(Double.parseDouble(webElement.getText().substring(1).replace(",", "")));
		}
		return priceLists;
	}
	
	public boolean isDisplayNextIcon() {
		waitForElementVisible(driver, UserProductPageUI.NEXT_BTN);
		return isElementDisplay(driver, UserProductPageUI.NEXT_BTN);
	}
	
	public boolean isDisplayPreviousIcon() {
		waitForElementVisible(driver, UserProductPageUI.PREVIOUS_BTN);
		return isElementDisplay(driver, UserProductPageUI.PREVIOUS_BTN);
	}
	
	public void clickPageByNumber(String pageNumber) {
		waitForElementVisible(driver, UserProductPageUI.INDIVIDUAL_PAGE_BTN, pageNumber);
		clickToElement(driver, UserProductPageUI.INDIVIDUAL_PAGE_BTN, pageNumber);
	}
	
	public boolean isCurrentpageNumber(String currentPage) {
		waitForElementVisible(driver, UserProductPageUI.CURRENT_PAGE_BTN, currentPage);
		return isElementDisplay(driver, UserProductPageUI.CURRENT_PAGE_BTN, currentPage);
	}
	
	public boolean isNotPaging() {
		waitForElementInvisible(driver, UserProductPageUI.PAGING_DIV);
		return isElementUnDisplay(driver, UserProductPageUI.PAGING_DIV);
	}
	
}
