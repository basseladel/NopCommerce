package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;

	@Test(priority = 1)
	public void searchProductSuccessfully() {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDeatilsPage(driver);
		searchObject.searchProductAutoComplete("mac");
		Assert.assertEquals(productDetailsObject.productName.getText(), productName);

	}
	@Test(priority = 2)
	public void addToCartSuccessfully() {
		productDetailsObject = new ProductDeatilsPage(driver);
		productDetailsObject.addToCart();
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.updateCart("4");
		Assert.assertTrue(shoppingCartObject.totalPriceLbl.getText().equals("$7,200.00"));
		
	}
	@Test(priority = 3)
	public void removeFromCartSuccessfully() {
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.removeProduct();
		Assert.assertTrue(shoppingCartObject.nodataLbl.getText().contains("Your Shopping Cart is empty!"));
	}
}
