package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class CompareTest extends TestBase {
	String firstProduct = "Apple MacBook Pro 13-inch";
	String secondProduct = "Asus N551JK-XO076H Laptop";
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	ComparePage compareObject;

	@Test
	public void compareProductSuccessfully() {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDeatilsPage(driver);
		compareObject = new ComparePage(driver);
		searchObject.searchProductAutoComplete("mac");
		Assert.assertEquals(productDetailsObject.productName.getText(), firstProduct);
		productDetailsObject.addToCompare();
		searchObject.searchProductAutoComplete("Asus");
		Assert.assertEquals(productDetailsObject.productName.getText(), secondProduct);
		productDetailsObject.addToCompare();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertEquals(compareObject.firstProductLbl.getText(), "Apple MacBook Pro 13-inch");
		Assert.assertEquals(compareObject.secondProductLbl.getText(), "Asus N551JK-XO076H Laptop");
		compareObject.compareProducts();
		Assert.assertTrue(compareObject.nodataLbl.getText().contains("You have no items to compare."));

	}
}
