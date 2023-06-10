package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productDetailsObject;
	EmailFriendPage emailFriendObject;

	@Test(priority = 1)
	public void registerSuccesssfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Bassel", "Adel", "ttestt.email@gmail.com", "12345678");
		Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "registerSuccesssfully", priority = 2)
	public void registeredUserCanLoginSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("ttestt.email@gmail.com", "12345678");
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
	public void emailFriendSuccessfully() {
		productDetailsObject = new ProductDeatilsPage(driver);
		emailFriendObject = new EmailFriendPage(driver);
		productDetailsObject.openSendEmial();
		emailFriendObject.emailFriend("a.t@yahoo.com", "rate this product");
		Assert.assertTrue(emailFriendObject.successMsg.isDisplayed());
	}

}
