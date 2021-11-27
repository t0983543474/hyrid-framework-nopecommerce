package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;
import pageUIs.nopecommerce.user.BasePageUI;
import pageUIs.nopecommerce.user.UserCustomerInfoUI;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	protected void openPageUrl(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	
	protected void freshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertToPresent(WebDriver driver) {
		WebDriverWait explictWait = new WebDriverWait(driver, longtime);
		return explictWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void aceptAlert(WebDriver driver)
	{
		waitForAlertToPresent(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver)
	{
		waitForAlertToPresent(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitForAlertToPresent(driver).getText();
	}
	
	protected void sendkeyToAlertText(WebDriver driver, String value) {
		waitForAlertToPresent(driver).sendKeys(value);
	}
	
	protected void switchToWindowById(WebDriver driver, String parentId) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		
		for(String windowId : allWinDowIDs) {
			if(!windowId.equals(parentId)) {
				driver.switchTo().window(windowId);
				break;
			}
		}
	}
	
	protected void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		
		for(String windowId : allWinDowIDs) {
			driver.switchTo().window(windowId);
			String titleCurrent = driver.getTitle();
			if(titleCurrent.equals(title)) {

				break;
			}
		}
	}
	
	protected void closeAllTabWithoutParent(WebDriver driver, String parentId) {
	Set<String> allWinDowIDs = driver.getWindowHandles();
		
		for(String windowId : allWinDowIDs) {
			if(!windowId.equals(parentId)) {
				driver.switchTo().window(windowId);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
		
		
	}
	
	protected By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	protected List<WebElement> getWebElements(WebDriver driver, String xpathLocator){
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	protected void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	protected void sendKeyToElement(WebDriver driver, String xpathLcaotor, String value) {
		WebElement element = getWebElement(driver, xpathLcaotor);
		element.clear();
		element.sendKeys(value);
	}
	
	
	
	protected void selectItemDefaultDropdowList(WebDriver driver, String xpathLocator, String item) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(item);
	}
	
	protected String getSelectedItemDefaultDropdowList (WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdowListMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdow(WebDriver driver, String parentElement, String childXpath, String expectedText) {
		getWebElement(driver, parentElement).click();
		driver.findElement(By.xpath(parentElement)).click();
		sleepSecond(1);
		WebDriverWait expliciWait = new WebDriverWait(driver, longtime);
		List<WebElement> allItems = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		
		for(WebElement item : allItems) {
			if(item.getText().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepSecond(1);
				item.click();
				break;
			}
		}
		
	}
	
	protected void sleepSecond(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attribute) {
		return getWebElement(driver, xpathLocator).getAttribute(attribute);
	}
	
	protected String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	protected String getElementCssvalue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	protected String getHexaColorFromGrba(String grbaValue) {
		return Color.fromString(grbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getWebElements(driver, xpathLocator).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckDefaultToCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	protected boolean isElementDisplay(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	protected void switchToFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	protected void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator));
		
	}
	
	
	protected Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return jsExecutor.executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	protected void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		WebElement element =  getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();",  getWebElement(driver, locator));
	}

	protected void scrollToElement( WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",  getWebElement(driver, locator));
	}

	protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",  getWebElement(driver, locator));
	}

	protected String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",  getWebElement(driver, locator));
	}

	protected boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",  getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver ) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			
			@Override
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active===0);");
			}
		};
		
		return explicitWait.until(jQueryLoad);
	}
	
	
	protected void  waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	protected void  waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	protected void  waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	protected void  waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathLocator)));
	}
	
	protected void  waitForElementClickAble(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	public UserAddressesPageObject openUserAddressPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.ADDRESSES_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPageObject(driver);
	}
	
	public UserCustomerInfoObject openUserCustomerInfoPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerPageObject(driver);
	}
	
	public UserMyProductReviewsObject openUserMyProductReviewsPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.MY_PRODUCE_REVIEWS_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCE_REVIEWS_LINK);
		return PageGeneratorManager.getUserMyProductReviewsObject(driver);
	}
	
	public UserRewardPonitObject openUserRewardPonitPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPonitObject(driver);
	}
	
	public void openPageURL(WebDriver driver,  String url) {
		openPageUrl(driver, url);
		
	}
	
	public AdminLoginPageObject clickLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPageObject(driver);
	}
	
	public UserHomePageObject clickLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomPageObject(driver);
	}
	
	
	private long longtime = 30;
}
