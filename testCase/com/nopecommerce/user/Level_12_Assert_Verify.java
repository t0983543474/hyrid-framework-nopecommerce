package com.nopecommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;



public class Level_12_Assert_Verify extends BaseTest{

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoPageObject userCustomerInfoPage;

	String userEmailAddress;
	String userFirstName = "Test", userLastName = "Automation", userPassword = "123456", userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName);
		
		userEmailAddress = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		userRegisterPage= userHomePage.clickToRegisterLink();
		System.out.println(userEmailAddress);
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, userEmailAddress, userPassword, userConfirmPassword);

		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		userHomePage = userRegisterPage.clickLogOutLink();
	}
	
	
	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickLoginLink();
		
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);

		verifyFail(userHomePage.MyAccountIsDisplay());
		
		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
		
		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
		
	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
	    
	    
	    verifyTrue(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
		
		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
	}
	
	@Test
	public void Role_02_Admin_To_User() {
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
	  
	  userLoginPage = userHomePage.clickLoginLink();
	  
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);

		verifyTrue(userHomePage.MyAccountIsDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
