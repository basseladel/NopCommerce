package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObject;
	ProductDeatilsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	@Test
	public void changeCurrencySuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}

	@Test
	public void searchProductSuccessfully() {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDeatilsPage(driver);
		searchObject.searchProductAutoComplete("mac");
		Assert.assertEquals(productDetailsObject.productName.getText(), productName);
		Assert.assertTrue(productDetailsObject.priceLabel.getText().contains("€"));
		System.out.println(productDetailsObject.priceLabel.getText());

	}

	
}
