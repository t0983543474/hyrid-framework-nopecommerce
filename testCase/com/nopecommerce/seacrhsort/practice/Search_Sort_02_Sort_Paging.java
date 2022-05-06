package com.nopecommerce.seacrhsort.practice;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.product.UserProductPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import reportExtentV5Config.ExtentTestManager;

public class Search_Sort_02_Sort_Paging extends BaseTest {
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
	public void Sort_Paging_01_Sort_With_Name_A_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_01_Sort_With_Name_A_Z");
		
		homePage.clickSubMenuInMenuByText(driver, "Computers ", "Notebooks ");
		
		productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
		productPage.selectSortBy("Name: A to Z");
		
		List<String> products = productPage.getListProducts();

		boolean sorted = Ordering.natural().isOrdered(products);
		
		Assert.assertTrue(sorted);
	}
	
	@Test
	public void Sort_Paging_02_Sort_With_Name_Z_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_02_Sort_With_Name_Z_A");
		
		
		productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
		productPage.selectSortBy("Name: Z to A");
		List<String> products = productPage.getListProducts();
		for (String double1 : products) {
			System.out.println(double1);
		}

		boolean sorted = Ordering.natural().reverse().isOrdered(products);
		
		Assert.assertTrue(sorted);
	}
	
	@Test
	public void Sort_Paging_03_Sort_With_Price_Low_High(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_03_Sort_With_Price_Low_High");
		
		
		productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
		productPage.selectSortBy("Price: Low to High");
		List<Double> products = productPage.getListPrices();
		
	
		boolean sorted = Ordering.natural().isOrdered(products);
		
		Assert.assertTrue(sorted);
	}
	
	@Test
	public void Sort_Paging_04_Sort_With_Price_High_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_01_Sort_With_Name_A_Z");
		
	productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
		productPage.selectSortBy("Price: High to Low");
		List<Double> products = productPage.getListPrices();
		
	
		boolean sorted = Ordering.natural().reverse().isOrdered(products);
		
		Assert.assertTrue(sorted);
	}
	
	
	@Test
	public void Sort_Paging_05_Display_3_Product_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_05_Display_3_Product_Page");
		
		productPage.selectDisplayPerPaging("3");
		
		List<String> products = productPage.getListProducts();
		
		Assert.assertTrue(products.size()<=3);
		
		
		
		
	}
	
	@Test
	public void Sort_Paging_06_Display_6_Product_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_06_Display_6_Product_Page");
		
		
	}
	
	@Test
	public void Sort_Paging_07_Display_9_Product_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_07_Display_9_Product_Page");
		
		
	}
	

	
	@AfterClass
	public void afterClass() {
//		 extent.flush();
		closeBrowserAndDriver();
	}
	
	
}
