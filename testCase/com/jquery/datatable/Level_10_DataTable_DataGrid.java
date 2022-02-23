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

	

//	@Test
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

//	@Test
	public void Table_02_Enter_Searchbox() {
		homePage.freshCurrentPage(driver);

		homePage.enterValueSearchHeading("Country", "Afghanistan");
		sleepSecond(1);
		
		
		homePage.enterValueSearchHeading("Females", "384187");
		sleepSecond(1);
		
		homePage.enterValueSearchHeading("Males", "407124");
		sleepSecond(1);
		
		homePage.enterValueSearchHeading("Total", "791312");
		sleepSecond(1);
	}
	
//	@Test
	public void Table_03_GetDataTable() {
		homePage.freshCurrentPage(driver);
		homePage.getDataTable();
	}
	
	
	@Test
	public void Table_04_Input_Data_Table() {
		homePage.loadDataDummy();
		homePage.inputDataOnRowAtColumn("Album", "1", "Trang");
		
		homePage.inputDataOnRowAtColumn("Artist", "2", "Itzy");
		
		homePage.inputDataOnRowAtColumn("Year", "3", "1995");
		
		homePage.inputDataOnRowAtColumn("Price", "4", "2000");
		
		homePage.selectDataOnRowAtColumn("Origin", "5", "Korea");
		
		homePage.checkDataOnRowAtColumn("With Poster?", "3");
		
		homePage.checkDataOnRowAtColumn("With Poster?", "5");
		
		homePage.uncheckDataOnRowAtColumn("With Poster?", "1");
		
		homePage.uncheckDataOnRowAtColumn("With Poster?", "2");
		
		homePage.uncheckDataOnRowAtColumn("With Poster?", "4");

		sleepSecond(5);
		
	}
	
	@Test
	public void Table_05_Action_On_Table() {
		
	}
	

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

