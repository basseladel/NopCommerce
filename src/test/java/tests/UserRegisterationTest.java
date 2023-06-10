package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
   
    @Test(priority = 1)
    public void registerSuccesssfully() {
    	homeObject = new HomePage(driver);
    	homeObject.openRegisterationPage();
    	registerObject = new UserRegisterationPage(driver);
    	registerObject.userRegisteration("Bassel", "Adel", "testt.email@gmail.com", "12345678");
    	Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods = "registerSuccesssfully")
    public void registeredUserCanLoginSuccessfully() {
    	homeObject = new HomePage(driver);
    	homeObject.openLoginPage();
    	loginObject = new LoginPage(driver);
    	loginObject.userLogin("testt.email@gmail.com", "12345678");
    	Assert.assertTrue(homeObject.logoutLink.isDisplayed());
    }
    
}
