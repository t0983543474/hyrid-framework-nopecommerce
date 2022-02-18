package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.jquery.HomePageObject;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;


public class Level_10_DataTable_DataGrid extends BaseTest{

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	
	}

	

	@Test
	public void Table_01_Paging() {
		homePage.clickPageNumber("10");
		sleepSecond(2);
		Assert.assertTrue(homePage.isActivePageNumber("10"));
		
		homePage.clickPageNumber("17");
		sleepSecond(2);
		Assert.assertTrue(homePage.isActivePageNumber("17"));
		
		homePage.clickPageNumber("24");
		sleepSecond(2);
		Assert.assertTrue(homePage.isActivePageNumber("24"));
		
		homePage.clickPageNumber("1");
		sleepSecond(2);
		Assert.assertTrue(homePage.isActivePageNumber("1"));
		
	}

	@Test
	public void Table_02_Enter_Searchbox() {

	
		
	}
	
	@Test
	public void Table_03() {
		
	}
	
	
	@Test
	public void Table_04() {
		
	}
	

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

