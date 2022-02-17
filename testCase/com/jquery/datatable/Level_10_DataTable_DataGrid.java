package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;


public class Level_10_DataTable_DataGrid extends BaseTest{

	WebDriver driver;


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName, url);
		
	
	}

	

	@Test
	public void Table_01() {
		

	}

	@Test
	public void Table_02() {

	
		
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

