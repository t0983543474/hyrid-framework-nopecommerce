package pageObjectFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;
import pageUIs.nopecommerce.user.UserRegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID, using = "register-button")
	private WebElement REGISTER_BTN ;
	

@FindBy(how = How.ID, using = "FirstName-error")
	private WebElement FIRSTNAME_ERROR_MESSAGE_TEXT ;
	

	@FindBy(how = How.ID, using = "LastName-error")
	private WebElement LASTNAME_ERROR_MESSAGE_TEXT ;
	

	@FindBy(how = How.ID, using = "Email-error")
	private WebElement EMAIL_ERROR_MESSAGE_TEXT ;
	

	@FindBy(how = How.ID, using = "Password-error")
	private WebElement PASSWORD_ERROR_MESSAGE_TEXT ;
	



	@FindBy(how = How.ID, using = "ConfirmPassword-error")
	private WebElement CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT ;
	
	@FindBy(how = How.ID, using = "FirstName")
	private WebElement FIRSTNAME_TXT ;
	
	@FindBy(how = How.ID, using = "LastName")
	private WebElement LASTNAME_TXT ;
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement EMAIL_TXT ;
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement PASSWORD_TXT ;
	
	@FindBy(how = How.ID, using = "ConfirmPassword")
	private WebElement CONFIRM_PASSWORD_TXT ;
	
	@FindBy(how = How.CLASS_NAME, using = "result")
	private WebElement REGISTER_SUCCESS_TEXT ;
	
	@FindBy(how = How.CSS, using = "div.message-error li")
	private WebElement REGISTER_EMAIL_EXISTS_TEXT ;
	
	public void clickToRegisterButton() {
		waitForElementClickAble(driver, REGISTER_BTN);
		clickToElement(driver, REGISTER_BTN);
	}

	public void inputToFirstNameTextBox(String firstName) {
		sendKeyToElement(driver, FIRSTNAME_TXT, firstName);
	}
	
	public void inputToLastNameTextBox(String lastName) {
		sendKeyToElement(driver, LASTNAME_TXT, lastName);
	}
	
	public void inputToEmailTextBox(String email) {
		sendKeyToElement(driver, EMAIL_TXT, email);
	}
	
	public void inputToPasswordTextBox(String password) {
		sendKeyToElement(driver, PASSWORD_TXT, password);
	}
	
	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		sendKeyToElement(driver, CONFIRM_PASSWORD_TXT, confirmPassword);
	}
	
	public String getErrorMessageLastnameTextbox() {
		return getElementText(driver, LASTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageEmailTextbox() {
		return getElementText(driver, EMAIL_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessagePasswordTextbox() {
		return getElementText(driver, PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageConfirmPasswordTextbox() {
		return getElementText(driver, CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageFirstnameTextbox() {
		return getElementText(driver, FIRSTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getMessageRegisterSuccess() {
		waitForAllElementVisible(driver, REGISTER_SUCCESS_TEXT);
		return getElementText(driver, REGISTER_SUCCESS_TEXT);
	}
	
	public String getMessageRegisterEmailExists() {
		waitForElementVisible(driver, REGISTER_EMAIL_EXISTS_TEXT);
		return getElementText(driver, REGISTER_EMAIL_EXISTS_TEXT);
	}
	
}
