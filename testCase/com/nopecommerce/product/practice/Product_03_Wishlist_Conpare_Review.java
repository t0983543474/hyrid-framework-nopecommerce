package com.nopecommerce.product.practice;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.product.UserProductPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import reportExtentV5Config.ExtentTestManager;

public class Product_03_Wishlist_Conpare_Review extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductPageObject productPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_01_Add_To_Wishlist");
		
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_02_Add_Product_To_Cart_From_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_02_Add_Product_To_Cart_From_Wishlist");
		
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_03_Remove_Product_From_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_03_Remove_Product_From_Wishlist");
		
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_04_Add_Product_To_Compare(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_04_Add_Product_To_Compare");
		
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_05_Recently_Reviewd_Prouct(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_05_Recently_Reviewd_Prouct");
		
		
	}

	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
}
