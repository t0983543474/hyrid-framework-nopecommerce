package com.nopecommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String projectPath = System.getProperty("user.dir");
	String emailValid,firstName, lastName , validPassword, invalidEmail, emailNotRegister, wrongPassword;
	@BeforeClass
	public void beforeClass() {
		firstName = "Test";
		lastName ="automation";
		validPassword ="123456";
		emailValid = "auto" + getRandom() + "@gmail.com";
		invalidEmail = "123!@#";
		emailNotRegister = "auto" + getRandom() + "@abc.vn";
		wrongPassword = "123457";
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Open website");
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		System.out.println("Re-Condition: Register account");
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailValid);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);

		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");
		System.out.println("Re-condition: Logout");
		homePage= registerPage.clickLogOutLink();

	}
	
	@Test
	public void Login_01_Login_Empty_Data() {
		System.out.println("Login 01_Login with empty data");
		homePage.clickLoginLink();
		System.out.println("Step 1: CLick to Login Page");
		loginPage = new LoginPageObject(driver);
		System.out.println("Step2 : Click login button");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getMessageErrorEmail(), "Please enter your email");
		
	}
	
	@Test
	public void Login_02_Login_With_Invalid_Email() {
		System.out.println("Login_02_ Login with invalid email");
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmail(invalidEmail);
		loginPage.inputToPassword(validPassword);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getMessageErrorEmail(), "Wrong email");
		
	}
	
	@Test
	public void Login_03_Login_With_Email_Not_Register() {
		System.out.println("Login_03 Login with email not register");
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmail(emailNotRegister);
		loginPage.inputToPassword(validPassword);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getMessageErrorSumary(), 
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
		
	}
	
	@Test
	public void Login_04_Login_With_Email_Valid_Blank_Password() {
		System.out.println("Login_04: Login with email valid and blank password");
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmail(emailValid);
		loginPage.inputToPassword("");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getMessageErrorSumary(),
	"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void Login_05_Login_Wrong_Password() {
		System.out.println("Login_05_ Login with email valid and wrong password");
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmail(emailValid);
		loginPage.inputToPassword(wrongPassword);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getMessageErrorSumary(),
	"Login was unsuccessful. Please correct the errors and try again.\n" + 
	"The credentials provided are incorrect");
		
	}
	
	@Test
	public void Login_06_Login_With_Email_Password_Correct() {
		System.out.println("Login_06: Login with email and passwor correct");
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmail(emailValid);
		loginPage.inputToPassword(validPassword);
		loginPage.clickLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.MyAccountIsDisplay());
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
