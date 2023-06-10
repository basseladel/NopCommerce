package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationDDTJavaFaker extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1)
	public void registerSuccesssfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, password);
		System.out.println("user data is:" + " " + firstName + " " + lastName + " " + email + " " + password);
		Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "registerSuccesssfully")
	public void registeredUserCanLoginSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
		homeObject.logout();
	}

}
