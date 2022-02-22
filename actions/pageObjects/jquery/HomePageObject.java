package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickPageNumber(String number) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_NUMBER, number);
		clickToElement(driver, HomePageUI.PAGINATION_NUMBER, number);
	}
	
	public boolean isActivePageNumber(String number) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_ACTIVE_NUMBER, number);
		return isElementDisplay(driver,HomePageUI.PAGINATION_ACTIVE_NUMBER,  number);
	}

	public void enterValueSearchHeading(String label , String value) {
		waitForElementVisible(driver, HomePageUI.INPUT_SEARCH_TEXT_BY_LABEL, label);
		sendKeyToElement(driver, HomePageUI.INPUT_SEARCH_TEXT_BY_LABEL, value, label);
		pressKeyToElement(driver, HomePageUI.INPUT_SEARCH_TEXT_BY_LABEL, Keys.ENTER, label);
	}
	
	public void getDataTable() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		List<String> dataListAllPage = new ArrayList<String>();
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.PAGINATION_NUMBER, String.valueOf(i));
			sleepSecond(1);
			
			List<WebElement> dataListInPage = getWebElements(driver, HomePageUI.DATA_ROW);
			
			for (WebElement webElement : dataListInPage) {
				dataListAllPage.add(webElement.getText());
			}
		}
		
		for (String value : dataListAllPage) {
			System.out.println("------");
			System.out.println(value);
		}
	}
	
	public void inputDataOnRowAtColumn(String ColumnName, String row, String value) {
		int columnNumber = getElementSize(driver, HomePageUI.COLUMN_KEY_NUMBER,ColumnName) + 1;
		waitForElementVisible(driver, HomePageUI.INPUT_TEXTBOX_ROW_AT_COLUMN, row, String.valueOf(columnNumber));
		sendKeyToElement(driver, HomePageUI.INPUT_TEXTBOX_ROW_AT_COLUMN, value, row, String.valueOf(columnNumber));
	}
	
	public void loadDataDummy() {
		waitForElementClickAble(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver,  HomePageUI.LOAD_DATA_BUTTON);
	}
	
	public void checkDataOnRowAtColumn(String ColumnName, String row, String value) {
		int columnNumber = getElementSize(driver, HomePageUI.COLUMN_KEY_NUMBER,ColumnName) + 1;
		waitForElementClickAble(driver, HomePageUI.CHECKBOX_TEXTBOX_ROW_AT_COLUMN, row, String.valueOf(columnNumber));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_TEXTBOX_ROW_AT_COLUMN, row, String.valueOf(columnNumber));
		
	}
	public void uncheckDataOnRowAtColumn(String ColumnName, String row, String value) {
		int columnNumber = getElementSize(driver, HomePageUI.COLUMN_KEY_NUMBER,ColumnName) + 1;
		waitForElementClickAble(driver, HomePageUI.CHECKBOX_TEXTBOX_ROW_AT_COLUMN, row, String.valueOf(columnNumber));
		uncheckDefaultToCheckbox(driver, HomePageUI.CHECKBOX_TEXTBOX_ROW_AT_COLUMN, row, String.valueOf(columnNumber));
		
	}
	
	public void selectDataOnRowAtColumn(String ColumnName, String row, String value) {
		
	}
}
