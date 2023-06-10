package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;

public class SearchAutoCompleteTest extends TestBase {
	String productName ="Apple MacBook Pro 13-inch";
   SearchPage searchObject;
   ProductDeatilsPage productDetailsObject;
   
   @Test
   public void searchProductSuccessfully() {
	   searchObject = new SearchPage(driver);
	   productDetailsObject = new ProductDeatilsPage(driver);
	   searchObject.searchProductAutoComplete("mac");
	   Assert.assertEquals(productDetailsObject.productName.getText(), productName);
	   
}
}
