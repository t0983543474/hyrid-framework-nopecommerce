package com.nopecommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import reportExtentV5Config.ExtentTestManager;



public class Level_15_Allure_Report extends BaseTest{

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
		
		driver = getBrowser(browserName);
		
		userEmailAddress = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		
		userRegisterPage= userHomePage.clickToRegisterLink();
		
		
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, userEmailAddress, userPassword, userConfirmPassword);

		
		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		
		userHomePage = userRegisterPage.clickLogOutLink();
	}
	
	@Description("Role_01_User_To_Admin")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Role_01_User_To_Admin(Method method) {
		
		userLoginPage = userHomePage.clickLoginLink();
		
	
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);

		
		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
		
		
		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
		
		
		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
		
		
	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  	
	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
	    
	   
	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
	    
	    
	    Assert.assertFalse(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
		
	   
	}
	
	@Description("Role_02_Admin_To_User")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Role_02_Admin_To_User(Method method) {
		
		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
		
	
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
	  
	  userLoginPage = userHomePage.clickLoginLink();
	  
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);
	
		  Assert.assertTrue(userHomePage.MyAccountIsDisplay());
	}

	@AfterClass
	public void afterClass() {
//		 extent.flush();
		driver.quit();
	}
}