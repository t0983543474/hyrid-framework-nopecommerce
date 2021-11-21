
package com.nopecommerce.user;

import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewsObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPonitObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Page extends BaseTest{

	
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoObject customerInfoPage;
	AddressesPageObject addressesPage ;
	MyProductReviewsObject myProductReviewsPage;
	RewardPonitObject rewardPonitPage;
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
	public void User_01_Register() {
		registerPage= homePage.clickToRegisterLink();
		System.out.println(emailAddress);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);

		registerPage.clickToRegisterButton();

		// div.result

		Assert.assertEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");

		homePage = registerPage.clickLogOutLink();

	}

	@Test
	public void User_02_Login() {

	
		System.out.println("Login_06: Login with email and passwor correct");
		loginPage= homePage.clickLoginLink();
		
		loginPage.inputToEmail(emailAddress);
		loginPage.inputToPassword(password);
		homePage = loginPage.clickLoginButton();

		Assert.assertTrue(homePage.MyAccountIsDisplay());

	}
	
	@Test
	public void User_03_Customer_Info() {
		customerInfoPage =  homePage.openCustomerInfoPage();
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplay());
	}
	
	@Test
	public void User_04_Switch_Page() {
		addressesPage = customerInfoPage.openAddressPage(driver);
		
		myProductReviewsPage = addressesPage.openMyProductReviewsPage(driver);
		
		rewardPonitPage  = myProductReviewsPage.openRewardPonitPage(driver);
		
		addressesPage = myProductReviewsPage.openAddressPage(driver);
		
		myProductReviewsPage = addressesPage.openMyProductReviewsPage(driver);
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
