
package com.nopecommerce.user;

import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager extends BaseTest{

	
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	String firstName = "Test", lastName = "Automation", password = "123456", confirmPassword = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName);
		
		emailAddress = "auto" + getRandom() + "@gmail.com";
		
		homePage = PageGeneratorManager.getHomPageObject(driver);
	}

	@Test
	public void Register_01_Register_Empty_Data() {
		registerPage= homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageFirstnameTextbox(), "First name is required.");

		Assert.assertEquals(registerPage.getErrorMessageLastnameTextbox(), "Last name is required.");

		Assert.assertEquals(registerPage.getErrorMessageEmailTextbox(), "Email is required.");

		Assert.assertEquals(registerPage.getErrorMessagePasswordTextbox(), "Password is required.");

		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("123!@#");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Register_Valid_Infomation() {
		registerPage= homePage.clickToRegisterLink();
	
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
	public void Register_04_Register_Email_Exists() {

		registerPage= homePage.clickToRegisterLink();
	
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
	public void Register_05_Register_Password_LessThan_6() {
		registerPage= homePage.clickToRegisterLink();
		
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
	public void Register_06_ConfirmPassword_NotMatch() {
		registerPage= homePage.clickToRegisterLink();
		
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
