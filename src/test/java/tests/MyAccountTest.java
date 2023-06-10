package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword ="12345678";
	String newPassword="123456";
	String firstname ="Bassel";
	String lastname="Adel";
	String email ="test110.email@gmail.com";
	
    @Test(priority = 1)
    public void registerSuccesssfully() {
    	homeObject = new HomePage(driver);
    	homeObject.openRegisterationPage();
    	registerObject = new UserRegisterationPage(driver);
    	registerObject.userRegisteration(firstname, lastname, email, oldPassword);
    	Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods = "registerSuccesssfully")
    public void registeredUserCanLoginSuccessfully() {
    	homeObject = new HomePage(driver);
    	homeObject.openLoginPage();
    	loginObject = new LoginPage(driver);
    	loginObject.userLogin(email, oldPassword);
    	Assert.assertTrue(homeObject.logoutLink.isDisplayed());
    }
    @Test(dependsOnMethods = "registeredUserCanLoginSuccessfully")
    public void changePasswordSuccessfully() {
    	homeObject = new HomePage(driver);
    	homeObject.openMyAccountPage();
    	myAccountObject = new MyAccountPage(driver);
    	myAccountObject.changePassword(oldPassword, newPassword);
    	Assert.assertTrue(myAccountObject.successMsg.getText().contains("Password was changed"));
    }
}
