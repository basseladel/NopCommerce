package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;

public class SearchTest extends TestBase {
   String productName ="Apple MacBook Pro 13-inch";
   SearchPage searchObject;
   ProductDeatilsPage productDetailsObject;
   
   @Test
   public void searchProductSuccessfully() {
	   searchObject = new SearchPage(driver);
	   searchObject.searchProduct(productName);
	   searchObject.openProductDetailPage();
	   productDetailsObject = new ProductDeatilsPage(driver);
	   //Assert.assertTrue(productDetailsObject.productName.getText().equals(productName));
	   Assert.assertEquals(productDetailsObject.productName.getText(), productName);
   }
}
