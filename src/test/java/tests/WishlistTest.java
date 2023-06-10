package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistTest extends TestBase {
	String productName ="Apple MacBook Pro 13-inch";
	   SearchPage searchObject;
	   ProductDeatilsPage productDetailsObject;
	   WishlistPage wishlistObject;
	   
	   @Test 
	   public void searchProductSuccessfully() {
		   searchObject = new SearchPage(driver);
		   productDetailsObject = new ProductDeatilsPage(driver);
		   searchObject.searchProductAutoComplete("mac");
		   Assert.assertEquals(productDetailsObject.productName.getText(), productName);
		   
	}
	   @Test (dependsOnMethods = "searchProductSuccessfully")
	   public void addToWishlist() {
		   productDetailsObject = new ProductDeatilsPage(driver);
		   productDetailsObject.openWishlistPage();
		   wishlistObject = new WishlistPage(driver);
		   Assert.assertTrue(wishlistObject.productLabel.isDisplayed());
		   wishlistObject.removeProduct();
		   Assert.assertTrue(wishlistObject.successMsg.isDisplayed());
	   }
}
