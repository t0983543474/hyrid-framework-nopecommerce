package com.nopecommerce.user;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	String firstName = "Test", lastName = "Automation", password = "123456", confirmPassword = "123456";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		emailAddress = "auto" + getRandom() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageFirstnameTextbox(), "First name is required.");

		Assert.assertEquals(registerPage.getErrorMessageLastnameTextbox(), "Last name is required.");

		Assert.assertEquals(registerPage.getErrorMessageEmailTextbox(), "Email is required.");

		Assert.assertEquals(registerPage.getErrorMessagePasswordTextbox(), "Password is required.");

		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("123!@#");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Valid_Infomation() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);

		registerPage.clickToRegisterButton();

		// div.result

		Assert.assertEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");

		homePage.clickLogOutLink();

	}

	@Test
	public void TC_04_Register_Email_Exists() {

		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);

		registerPage.clickToRegisterButton();

		// div.message-error li
		Assert.assertEquals(registerPage.getMessageRegisterEmailExists(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_LessThan_6() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("auto" + getRandom() + "@gmail.com");
		registerPage.inputToPasswordTextBox("123");
		registerPage.inputToConfirmPasswordTextBox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessagePasswordTextbox(),
				"Password must meet the following rules:" + "\n" + "must have at least 6 characters");

	}

	@Test
	public void TC_06_ConfirmPassword_NotMatch() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("auto" + getRandom() + "@gmail.com");
		registerPage.inputToPasswordTextBox("1234567");
		registerPage.inputToConfirmPasswordTextBox("1234568");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandom() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
