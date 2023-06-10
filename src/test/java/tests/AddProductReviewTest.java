package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	AddProductReviewPage reviewObject;
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1)
	public void registerSuccesssfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Bassel", "Adel", "testt.email4@gmail.com", "12345678");
		Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "registerSuccesssfully", priority = 2)
	public void registeredUserCanLoginSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("testt.email4@gmail.com", "12345678");
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
	public void addReviewSuccessfully() {
		productDetailsObject = new ProductDeatilsPage(driver);
		productDetailsObject.openReviewPage();
		reviewObject = new AddProductReviewPage(driver);
		reviewObject.addReview("Mac Review", "Perfecto");
		Assert.assertTrue(reviewObject.successMsg.isDisplayed());
	}
}
