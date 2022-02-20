package pageUIs.jquery;

public class HomePageUI {
	public final static String PAGINATION_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public final static String PAGINATION_ACTIVE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[contains(@class, 'active') and text()='%s']";
	public final static String INPUT_SEARCH_TEXT_BY_LABEL="xpath=//div[text()='%s']//parent::div//following-sibling::input";
	public final static String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul li";
	public final static String DATA_ROW = "xpath=//tbody/tr";
	public final static String DATA_BY_COLUMN = "xpath=//tbody/tr//td[@data-key='%s']";
}
