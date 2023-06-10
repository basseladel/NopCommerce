package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Given("the user is in home page")
	public void the_user_is_in_home_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	}

	@When("the user click on register link")
	public void the_user_click_on_register_link() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}

//	@When("the user enters user data")
//	public void the_user_enters_user_data() {
//		registerObject = new UserRegisterationPage(driver);
//		registerObject.userRegisteration("dvv", "as", "saffa@gmail.com", "1234567");
//	}
	@When("the user enters {string} , {string}, {string}, {string}")
	public void the_user_enters(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	}

	@Then("the user registered successfully")
	public void the_user_regisyered_successfully() {
		Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
}
}
