package common;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopecommerce.common.Common_01_Register_Cookies;

import io.qameta.allure.Step;
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
	
	public void freshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		
		for(Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		
		sleepSecond(3);
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
	
	
	
	private By getByLocatorType(String locatorType) {
		By by = null;
		if(locatorType.startsWith("ID") || locatorType.startsWith("Id") || locatorType.startsWith("id") ) {
			by=  By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath") || locatorType.startsWith("xpath")) {
			by= By.xpath(locatorType.substring(6));
		}else if (locatorType.startsWith("CSS") || locatorType.startsWith("Css") || locatorType.startsWith("css")) {
			by= By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("NAME") || locatorType.startsWith("Name") || locatorType.startsWith("name")) {
			by= By.name(locatorType.substring(5));
		}else if(locatorType.startsWith("TAGNAME") || locatorType.startsWith("TagName") || locatorType.startsWith("tagname")) {
			by= By.tagName(locatorType.substring(8));
		}else if(locatorType.startsWith("CLASSNAME") || locatorType.startsWith("ClassName") || locatorType.startsWith("classname")) {
			by= By.className(locatorType.substring(10));
		}else if(locatorType.startsWith("PARTIALLINKTEXT") || locatorType.startsWith("PartialLinkText") || locatorType.startsWith("partiallinktext")) {
			by= By.partialLinkText(locatorType.substring(16));
		}else if(locatorType.startsWith("LINKTEXT") || locatorType.startsWith("LinkText") || locatorType.startsWith("linktext")) {
			by= By.linkText(locatorType.substring(9));
		}else {
			throw new RuntimeException("Locator not correct format");
		}
		return by;
	}
	
	private String getDynamicXpath(String locatorType , String... value) {
		
		
		 if(locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath") || locatorType.startsWith("xpath")) 
			 {
				 locatorType = String.format(locatorType, (Object[]) value);
			 }
		
		return locatorType;
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocatorType(locator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String locator){
		return driver.findElements(getByLocatorType(locator));
	}
	
	protected void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	protected void clickToElementByWebElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	protected void clickToElement(WebDriver driver, String locatorType , String... dynamicValue) {
		locatorType = getDynamicXpath(locatorType, dynamicValue);
		getWebElement(driver, locatorType).click();
//		getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
	}
	
	protected void sendKeyToElement(WebDriver driver, String xpathLcaotor, String value) {
		WebElement element = getWebElement(driver, xpathLcaotor);
		element.clear();
		element.sendKeys(value);
	}
	
	protected void sendKeyToElement(WebDriver driver, String locatorType, String value, String...dynamicValue) {
		 locatorType = getDynamicXpath(locatorType, dynamicValue);
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(value);
	}
	
	protected void uploadFilesBySendKey(WebDriver driver, String locatorXpath, String...fileNames) {
		
		String filePath = GlobalConstants.FILEPATH_UPLOAD ;
		String fullNameFiles ="";
		for (String fileName : fileNames) {
			fullNameFiles += filePath + fileName + "\n";
		}
		fullNameFiles = fullNameFiles.trim();
		System.out.println(fullNameFiles);
		WebElement element = getWebElement(driver, locatorXpath);
		element.sendKeys(fullNameFiles);
	}
	
	protected void selectItemDefaultDropdowList(WebDriver driver, String locator, String item) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(item);
	}
	
	protected void selectItemDefaultDropdowList(WebDriver driver, String locatorType, String item, String...dynamicValue) {
		 locatorType = getDynamicXpath(locatorType, dynamicValue);
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(item);
	}
	
	
	protected String getSelectedItemDefaultDropdowList (WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdowListMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdow(WebDriver driver, String parentElement, String childXpath, String expectedText) {
		getWebElement(driver, parentElement).click();
		driver.findElement(By.xpath(parentElement)).click();
		sleepSecond(1);
		WebDriverWait expliciWait = new WebDriverWait(driver, longtime);
		List<WebElement> allItems = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocatorType(childXpath)));
		
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
	
	protected String getElementAttribute(WebDriver driver, String locator, String attribute) {
		return getWebElement(driver, locator).getAttribute(attribute);
	}
	
	protected String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	protected String getElementCssvalue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}
	
	protected String getHexaColorFromGrba(String grbaValue) {
		return Color.fromString(grbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String locator) {
		return getWebElements(driver, locator).size();
	}
	
	protected int getElementSize(WebDriver driver, String typeLocator, String...dynamicValue) {
		typeLocator = getDynamicXpath(typeLocator, dynamicValue);
		return getWebElements(driver, typeLocator).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}   
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String typeLocator, String...dynamicValue) {
		typeLocator = getDynamicXpath(typeLocator, dynamicValue);
		WebElement element = getWebElement(driver, typeLocator);
		if(!element.isSelected()) {
			element.click();
		}   
	}
	
	protected void uncheckDefaultToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	protected void uncheckDefaultToCheckbox(WebDriver driver, String typeLocator, String...dynamicValue) {
		typeLocator = getDynamicXpath(typeLocator, dynamicValue);
		WebElement element = getWebElement(driver, typeLocator);
		if(element.isSelected()) {
			element.click();
		}   
	}
	
	protected boolean isElementDisplay(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	protected boolean isElementDisplay(WebDriver driver, String locator, String...dynamicValue) {
		String typeLocator = getDynamicXpath(locator, dynamicValue);
		return getWebElement(driver, typeLocator).isDisplayed();
	}
	
	protected boolean isElementUnDisplay(WebDriver driver, String locator) {
		
			boolean undisplay = true;
			overiteImplicitTimeout(driver, shorttime);
		
			List<WebElement> elements = getWebElements(driver, locator);
		
			overiteImplicitTimeout(driver, longtime);
			if(elements.size()==0) {
				
				undisplay=  true;
			}else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
				
				undisplay=  true;
			}else {
			
				undisplay = false;
			}
		
			return undisplay;
	}
	
	
	protected boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	protected void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	
	protected void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
		
	}
	
	public void pressKeyToElement(WebDriver driver,String typeLocator,  Keys key,  String...dynamicValue) {
		Actions action = new Actions(driver);
		typeLocator = getDynamicXpath(typeLocator, dynamicValue);
		action.sendKeys(getWebElement(driver, typeLocator), key).perform();
//		action.sendKeys(keys)(getWebElement(driver, locator));
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
	
	protected boolean isImageLoaded(WebDriver driver, String locator, String...dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		locator = getDynamicXpath(locator, dynamicValue);
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
	
	
	protected void  waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocatorType(locator)));
	}
	
	protected void  waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		locatorType = getDynamicXpath(locatorType, dynamicValue);
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocatorType(locatorType)));
	}
	
	protected void  waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocatorType(locatorType)));
	}
	
	protected void  waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicvalue) {
		locatorType = getDynamicXpath(locatorType, dynamicvalue);
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocatorType(locatorType)));
	}
	
	protected void  waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocatorType(locatorType)));
	}
	
	protected void  waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		locatorType = getDynamicXpath(locatorType, dynamicValue);
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocatorType(locatorType)));
	}
	
	protected void  waitForAllElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locator)));
	}
	
	protected void  waitForAllElementInvisible(WebDriver driver, String locatorType, String... dynamicValue) {
		locatorType = getDynamicXpath(locatorType, dynamicValue);
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locatorType)));
	}
	
	protected void  waitForElementClickAble(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(locator)));
	}
	
	protected void  waitForElementClickAble(WebDriver driver, String locatorType, String... dynamicValue) {
		locatorType = getDynamicXpath(locatorType, dynamicValue);
		WebDriverWait explicitWait = new WebDriverWait(driver, longtime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocatorType(locatorType)));
	}
	
	

	public BasePage openMyAccountPageByName(WebDriver driver , String pageName) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPageObject(driver);
		case "Customer info":
			return PageGeneratorManager.getUserCustomerPageObject(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPonitObject(driver);
		case "My product reviews":
			
			return PageGeneratorManager.getUserMyProductReviewsObject(driver);
		default:
			throw new RuntimeException("Invalid page name");
		}
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
	
	public void clickLogo(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGO_IMAGE_LINK);
		clickToElement(driver, BasePageUI.LOGO_IMAGE_LINK);
	}
	
	public void openPageURL(WebDriver driver,  String url) {
		openPageUrl(driver, url);
		
	}
	
	public AdminLoginPageObject clickLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPageObject(driver);
	}
	
	@Step("Logout Admin page")
	public UserHomePageObject clickLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomPageObject(driver);
	}
	
	private void overiteImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	private long shorttime = 5;
	private long longtime = 30;
}
