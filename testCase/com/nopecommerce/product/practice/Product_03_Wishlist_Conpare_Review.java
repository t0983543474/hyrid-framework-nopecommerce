package com.nopecommerce.product.practice;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopecommerce.common.Common_01_Register;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.product.UserCompareProductPageObject;
import pageObjects.nopecommerce.product.UserDetailProductPageObject;
import pageObjects.nopecommerce.product.UserProductPageObject;
import pageObjects.nopecommerce.product.UserShopingCardPageObject;
import pageObjects.nopecommerce.product.UserWishlistPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import reportExtentV5Config.ExtentTestManager;

public class Product_03_Wishlist_Conpare_Review extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductPageObject productPage;
	UserLoginPageObject loginPage;
	String productName = "Apple MacBook Pro 13-inch", product2= "HTC One M8 Android L 5.0 Lollipop";
	UserDetailProductPageObject detailProductPage;
	UserWishlistPageObject wishlistPage;
	UserShopingCardPageObject shopingCartPage;
	UserCompareProductPageObject compareProductPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		loginPage = homePage.clickLoginLink();
		
		homePage = loginPage.LoginPortalUser(Common_01_Register.email, Common_01_Register.userPassword);
	}
	
	@Test 
	public void Wishlist_Conpare_Review_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort_Paging_01_Add_To_Wishlist");

		ExtentTestManager.getTest().log(Status.INFO, "Click view a product");
		homePage.clickToLinkByText(driver, productName);
		
		detailProductPage = PageGeneratorManager.getUserDetailProductPageObject(driver);
		
		detailProductPage.clickAddWishlist();
		
		
		Assert.assertEquals(detailProductPage.messageAddWishlistSuccess(), "The product has been added to your wishlist");
		
		detailProductPage.clickToLinkByText(driver, "wishlist");
		
		
		wishlistPage = PageGeneratorManager.getUserWishlistPageObject(driver);
		Assert.assertTrue(wishlistPage.getproductListinWishlist().contains(productName));
		
		wishlistPage.clickShareLink();
		
		Assert.assertTrue(wishlistPage.getPageTitleWishlist().contains(Common_01_Register.userFirstName));
		
		Assert.assertTrue(wishlistPage.getPageTitleWishlist().contains(Common_01_Register.userLastName));
		
	}
	
	@Test
	public void Wishlist_Conpare_Review_02_Add_Product_To_Cart_From_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_02_Add_Product_To_Cart_From_Wishlist");
		
		wishlistPage.backToPage(driver);
		
		wishlistPage.clickCheckAddToCartByProductName(productName);
		
		wishlistPage.clickAddToCartButton();
		
		shopingCartPage = PageGeneratorManager.getUserShopingCardPageObject(driver);
		
		List<String> productNames = shopingCartPage.getAllProductNameInShoppongCart();
		
		Assert.assertTrue(productNames.contains(productName));
		
		Assert.assertEquals(0 , Integer.parseInt(shopingCartPage.getQuantityWishlist(driver)));
	}
	
	@Test
	public void Wishlist_Conpare_Review_03_Remove_Product_From_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_03_Remove_Product_From_Wishlist");
		
		shopingCartPage.clickLogo(driver);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		homePage.clickToLinkByText(driver, product2);
		
		detailProductPage = PageGeneratorManager.getUserDetailProductPageObject(driver);
		
		detailProductPage.clickAddWishlist();
		
		detailProductPage.clickToLinkByText(driver, "wishlist");

		wishlistPage = PageGeneratorManager.getUserWishlistPageObject(driver);
		
		wishlistPage.clickRemoveProductFromWishlistByName(product2);
		
		Assert.assertEquals("The wishlist is empty!", wishlistPage.getMessageEmptyWishlistPage());
		
		Assert.assertTrue(wishlistPage.isNotDisplayProduct(product2));
	}
	
	@Test
	public void Wishlist_Conpare_Review_04_Add_Product_To_Compare(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_04_Add_Product_To_Compare");
		
		
		wishlistPage.clickLogo(driver);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		homePage.clickAddCompareByProductName(productName);
		homePage.clickAddCompareByProductName(product2);
		
		Assert.assertEquals("The product has been added to your product comparison", homePage.getMessageAddCompare());
		
		homePage.clickCompareProductLink();
		
		Assert.assertTrue(compareProductPage.displayRemoveProductByProductName(productName));
		
		Assert.assertTrue(compareProductPage.displayRemoveProductByProductName(product2));
		
		Assert.assertTrue(compareProductPage.getProductListInComparePage().contains(productName));
		
		Assert.assertTrue(compareProductPage.getProductListInComparePage().contains(product2));
		
		Assert.assertEquals(false, compareProductPage.getPriceByProductName(productName));
		
		Assert.assertEquals(false, compareProductPage.getPriceByProductName(product2));
		
		compareProductPage.clickClearList();
		
		Assert.assertEquals("", compareProductPage.getMessageClearList());
		
		Assert.assertTrue(compareProductPage.isNotDisplayProductInCompage());
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
