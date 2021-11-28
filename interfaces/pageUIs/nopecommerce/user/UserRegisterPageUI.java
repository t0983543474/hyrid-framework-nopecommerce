package pageUIs.nopecommerce.user;

public class UserRegisterPageUI {
	
	public static final String REGISTER_BTN = "xpath=//button[@id='register-button']";
	

	public static final String FIRSTNAME_ERROR_MESSAGE_TEXT = "xpath=//span[@id='FirstName-error']";
	
	
	public static final String LASTNAME_ERROR_MESSAGE_TEXT = "xpath=//span[@id='LastName-error']";
	
	public static final String EMAIL_ERROR_MESSAGE_TEXT = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE_TEXT = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT = "xpath=//span[@id='ConfirmPassword-error']";
	
	public static final String FIRSTNAME_TXT = "xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TXT = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TXT = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TXT = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TXT = "xpath=//input[@id='ConfirmPassword']";
	
	public static final String REGISTER_SUCCESS_TEXT = "xpath=//div[@class='result']";
	public static final String REGISTER_EMAIL_EXISTS_TEXT = "xpath=//div[contains(@class, 'message-error')]//li";
	
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
}
