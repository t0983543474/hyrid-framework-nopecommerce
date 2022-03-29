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
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;



public class Level_15_ReportNg_ScreenShot extends BaseTest{

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoObject userCustomerInfoPage;

	String userEmailAddress;
	String userFirstName = "Test", userLastName = "Automation", userPassword = "123456", userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Browser:" +  browserName);
		driver = getBrowser(browserName);
		
		userEmailAddress = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		log.info("Register - Click to link to redirect to register page");
		userRegisterPage= userHomePage.clickToRegisterLink();
		
		log.info("Register - Register to Portal User");
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, userEmailAddress, userPassword, userConfirmPassword);

		log.info("Verify get Message Register Success");
		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		log.info("Register - Click logout");
		userHomePage = userRegisterPage.clickLogOutLink();
	}
	
	
	@Test
	public void Role_01_User_To_Admin() {
		
		log.info("Click login link");
		userLoginPage = userHomePage.clickLoginLink();
		
		log.info("Login - user login to portal user");
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);

		log.info("Login - Verify My Account display");
		Assert.assertFalse(userHomePage.MyAccountIsDisplay());
		
		log.info("Login - open Customer Infor Page ");
		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
		
		log.info("Login - Logout Portal User page");
		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
		
		log.info("Login  Open link Admin page");
	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  	
	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
	    
	    log.info("Login- Login Admin page with email " + adminEmail + " password " + adminPassword);
	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
	    
	    
	    Assert.assertTrue(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
		
	    log.info("Login - Logout Portal Admin page");
		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
	}
	
	@Test
	public void Role_02_Admin_To_User() {

		log.info("Login  Open link Portal page");
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
	  
	  userLoginPage = userHomePage.clickLoginLink();
	  
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);
		log.info("Verify My account is display");
		  Assert.assertTrue(userHomePage.MyAccountIsDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
