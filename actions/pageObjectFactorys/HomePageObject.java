package pageObjectFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;


public class HomePageObject extends BasePageFactory {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement REGISTER_LINK ;
	
	@FindBy(how = How.CSS, using = "a.ico-logout")
	private WebElement LOGOUT_LINK ;
	
	@FindBy(how = How.CSS, using = "a.icon-login")
	private WebElement LOGIN_LINK ;
	
	@FindBy(how = How.XPATH, using = "a.icon-account")
	private WebElement MYACCOUNT_LINK ;
	
	public void clickToRegisterLink() {
		waitForElementClickAble(driver, REGISTER_LINK);
		clickToElement(driver,REGISTER_LINK);
	}
	
	public void clickLogOutLink() {
		waitForElementClickAble(driver, LOGOUT_LINK);
		clickToElement(driver, LOGOUT_LINK);
	}
	
	public void clickLoginLink() {
		waitForElementClickAble(driver, LOGIN_LINK);
		clickToElement(driver, LOGIN_LINK);
	}
	
	public boolean MyAccountIsDisplay() {
		waitForElementVisible(driver,MYACCOUNT_LINK);
		return isElementDisplay(driver, MYACCOUNT_LINK);
	}

}
