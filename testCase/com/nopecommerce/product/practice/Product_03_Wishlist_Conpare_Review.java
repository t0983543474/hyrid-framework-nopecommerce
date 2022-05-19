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
import pageObjects.nopecommerce.product.RecentlyViewedProductsPageObject;
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
	RecentlyViewedProductsPageObject recentlyViewedProductPage;
	

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
		
		String price1 = homePage.getPriceOfProductName(productName);
		String price2 = homePage.getPriceOfProductName(product2);
		homePage.clickAddCompareByProductName(productName);
		Assert.assertEquals("The product has been added to your product comparison", homePage.getMessageAddCompare());
		homePage.clickCloseMessageCompare();
		sleepSecond(2);
		homePage.clickAddCompareByProductName(product2);
	
		Assert.assertEquals("The product has been added to your product comparison", homePage.getMessageAddCompare());
	
		compareProductPage= homePage.clickCompareProductLink();
		
		List<String> productNameList = compareProductPage.getListProductName();
		System.out.println("size = " + productNameList.size());
		for (int i = 0; i < productNameList.size(); i++) {
			String index = Integer.toString(i+2);
			String price = compareProductPage.getPriceByIndex(index);
			String name = compareProductPage.getProductNameByIndex(index);
		
			
			if(name.equals(productName)) {
				
				Assert.assertTrue(compareProductPage.isDisplayRemoveByIndex(index));
				Assert.assertEquals(price, price1);
				Assert.assertEquals(name, productName);
			}else if(name.equals(product2)) {
				Assert.assertTrue(compareProductPage.isDisplayRemoveByIndex(index));
				Assert.assertEquals(price, price2);
				Assert.assertEquals(name, product2);
			}
		}
		
		
		compareProductPage.clickClearList();
		
		Assert.assertEquals("You have no items to compare.", compareProductPage.getMessageClearList());
		
		Assert.assertTrue(compareProductPage.isNotDisplayProductInCompage());
	}
	
	@Test
	public void Wishlist_Conpare_Review_05_Recently_Reviewd_Prouct(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist_Conpare_Review_05_Recently_Reviewd_Prouct");
		
		// change
		compareProductPage.clickSubMenuInMenuByText(driver, "Computers ", "Notebooks ");
		String prod1 = "Apple MacBook Pro 13-inch", prod2 =  "Asus N551JK-XO076H Laptop", prod3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook", prod4 = "HP Spectre XT Pro UltraBook" , prod5 = "Lenovo Thinkpad X1 Carbon Laptop";
		
		productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
	 	detailProductPage =  productPage.clickViewDetailProduct(prod1);
	 	
	 	Assert.assertEquals(prod1, detailProductPage.getProductName());
	 	
	 	detailProductPage.backToPage(driver);
	 	
	 	productPage = PageGeneratorManager.getUserProductPageObject(driver);
	 	
	 
	 	detailProductPage =  productPage.clickViewDetailProduct(prod2);
	 	
	 	Assert.assertEquals(prod2, detailProductPage.getProductName());
	 	
	 	detailProductPage.backToPage(driver);
	 	
	 	productPage = PageGeneratorManager.getUserProductPageObject(driver);
	 	
	 	detailProductPage =  productPage.clickViewDetailProduct(prod3);
	 	
	 	Assert.assertEquals(prod3, detailProductPage.getProductName());
	 	
	 	detailProductPage.backToPage(driver);
	 	
	 	productPage = PageGeneratorManager.getUserProductPageObject(driver);
	 	
	 	detailProductPage =  productPage.clickViewDetailProduct(prod4);
	 	
	 	Assert.assertEquals(prod4, detailProductPage.getProductName());
	 	
	 	detailProductPage.backToPage(driver);
	 	
	 	productPage = PageGeneratorManager.getUserProductPageObject(driver);
	 	
	 	detailProductPage =  productPage.clickViewDetailProduct(prod5);
	 	
	 	Assert.assertEquals(prod5, detailProductPage.getProductName());
	 	
	 	detailProductPage.clickToLinkByText(driver, "Recently viewed products");
	 	
	 	recentlyViewedProductPage = PageGeneratorManager.getRecentlyViewedProductsPageObject(driver);
	 	
	 	List<String> products = recentlyViewedProductPage.getProductNameList();
	 	
	 	for (String string : products) {
			Assert.assertTrue(string.equals(prod3) || string.equals(prod4) || string.equals(prod5));
		}
	}

	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
}
