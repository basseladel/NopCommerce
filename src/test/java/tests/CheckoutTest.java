package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class CheckoutTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;

	@Test(priority = 1)
	public void registerSuccesssfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Bassel", "Adel", "w2334r4.email@gmail.com", "12345678");
		Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "registerSuccesssfully", priority = 2)
	public void registeredUserCanLoginSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("w2334r4.email@gmail.com", "12345678");
		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}

	@Test(priority = 3)
	public void searchProductSuccessfully() {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDeatilsPage(driver);
		searchObject.searchProductAutoComplete("mac");
		Assert.assertEquals(productDetailsObject.productName.getText(), productName);

	}

	@Test(priority = 4)
	public void addToCartSuccessfully() {
		productDetailsObject = new ProductDeatilsPage(driver);
		productDetailsObject.addToCart();
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.updateCart("4");
		Assert.assertTrue(shoppingCartObject.totalPriceLbl.getText().equals("$7,200.00"));
		shoppingCartObject.openCheckoutPage();

	}

	@Test(priority = 5)
	public void registeredUserCheckout() {
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.productCheckout("Brazil", "Rio", "Roxy", "0123224434", "4566");
		Assert.assertTrue(checkoutObject.sucessMsg.isDisplayed());
		checkoutObject.openOrderDetails();
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.print();
//		orderDetailsObject.pdfInvoice();
		
	}
}