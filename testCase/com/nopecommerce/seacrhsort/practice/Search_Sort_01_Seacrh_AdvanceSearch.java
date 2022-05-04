package com.nopecommerce.seacrhsort.practice;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.searchSort.UserSearchPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import reportExtentV5Config.ExtentTestManager;

public class Search_Sort_01_Seacrh_AdvanceSearch extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String invalidEmail = "imavlidemail@";
	UserSearchPageObject searchPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		
	}
	
	@Test
	public void Search_01_Search_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_01_Search_With_Empty_Data");
		
		searchPage = homePage.inputSearchTextAndSearch(driver, " ");
		
		Assert.assertEquals("Search term minimum length is 3 characters", searchPage.getWarningMessage());
	}
	
	@Test
	public void Search_02_Search_With_Data_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_02_Search_With_Data_Not_Exist");
		
		searchPage.inputSearchTextAndSearch(driver, "Macbook pro 2050");
		
		Assert.assertEquals("No products were found that matched your criteria.", searchPage.getNoDataMessage());
	}
	
	@Test
	public void Search_03_Search_With_Product_Name(Method method) {
		
		String searchText = "Lenovo";
		ExtentTestManager.startTest(method.getName(), "Search_03_Search_With_Product_Name");
		
		searchPage.inputSearchTextAndSearch(driver, searchText);
		
		List<String> seacrhResult = searchPage.getListSearchResult();
		
		Assert.assertEquals(2, seacrhResult.size());
		
		for (String result : seacrhResult) {
			Assert.assertTrue(result.contains(searchText));
		}
		
	}
	
	
	@Test
	public void Search_04_Search_With_Product_Name_Absolute(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_04_Search_With_Product_Name_Absolute");
		
		String searchText = "Thinkpad X1 Carbon Laptop";
		
		searchPage.inputSearchTextAndSearch(driver, searchText);
		
		List<String> seacrhResult = searchPage.getListSearchResult();
		
		Assert.assertEquals(1, seacrhResult.size());
		
		for (String result : seacrhResult) {
			Assert.assertTrue(result.contains(searchText));
		}
	}
	
	
	@Test
	public void Search_05_Advance_Search_With_Parent_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_05_Advance_Search_With_Parent_Categories");
		
		
	}
	
	
	@Test
	public void Search_06_Advance_Search_With_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_06_Advance_Search_With_Sub_Categories");
		
		
	}
	
	
	@Test
	public void Search_07_Advance_Search_With_Incorrect_Manufacture(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_07_Advance_Search_With_Incorrect_Manufacture");
		
		
	}
	
	
	@Test
	public void Search_08_Advance_Search_With_Correct_Manufacture(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_08_Advance_Search_With_Correct_Manufacture");
		
		
	}
	
	

	
	
	
	
	@AfterClass
	public void afterClass() {
//		 extent.flush();
		closeBrowserAndDriver();
	}
	
}
