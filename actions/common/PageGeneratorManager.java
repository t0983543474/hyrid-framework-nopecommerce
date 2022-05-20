package common;

import org.openqa.selenium.WebDriver;

import com.nopecommerce.product.practice.UserTopComponentPageObject;

import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.product.RecentlyViewedProductsPageObject;
import pageObjects.nopecommerce.product.UserCompareProductPageObject;
import pageObjects.nopecommerce.product.UserDetailProductPageObject;
import pageObjects.nopecommerce.product.UserProductPageObject;
import pageObjects.nopecommerce.product.UserShopingCardPageObject;
import pageObjects.nopecommerce.product.UserWishlistPageObject;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserChangePasswordPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserProductReviewPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import pageObjects.nopecommerce.user.UserRewardPonitObject;


public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomPageObject(WebDriver driver) {
		return  new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPageeObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getUserCustomerPageObject(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	
	public static UserAddressesPageObject getUserAddressesPageObject(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserMyProductReviewsObject getUserMyProductReviewsObject(WebDriver driver) {
		return new UserMyProductReviewsObject(driver);
	}
	public static UserRewardPonitObject getUserRewardPonitObject(WebDriver driver) {
		return new UserRewardPonitObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	
	public static UserProductReviewPageObject getUserProductReviewPageObject(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}
	// Jquery DataTable 

	
	public static UserProductPageObject getUserProductPageObject(WebDriver driver) {
		return new UserProductPageObject(driver);
	}

	public static UserDetailProductPageObject getUserDetailProductPageObject(WebDriver driver) {
		return new UserDetailProductPageObject(driver);
	}

	public static UserWishlistPageObject getUserWishlistPageObject(WebDriver driver) {
		return new UserWishlistPageObject(driver);
	}
	
	public static UserShopingCardPageObject getUserShopingCardPageObject(WebDriver driver) {
		return new UserShopingCardPageObject(driver);
	}

	public static UserCompareProductPageObject getUserCompareProductPageObject(WebDriver driver) {
		 return new UserCompareProductPageObject(driver);
	}
	
	public static RecentlyViewedProductsPageObject getRecentlyViewedProductsPageObject(WebDriver driver ) {
		return new RecentlyViewedProductsPageObject(driver);
	}
	
	public static UserTopComponentPageObject getUserTopComponentPageObject(WebDriver driver) {
		return new UserTopComponentPageObject(driver);
	}
}
