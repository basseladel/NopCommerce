package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationDDTDataProvider extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name = "testData")
	public static Object [][] userData(){
		return new Object[][] {
			{"Bassel", "Adel", "testtt.emaill@gmail.com", "12345678"},
			{"Bassell", "Adell", "testtr.emaill@gmail.com", "12345678"}
			};
	}
	 @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	    public void registerSuccesssfully(String firstName, String lastName, String email, String password) {
	    	homeObject = new HomePage(driver);
	    	homeObject.openRegisterationPage();
	    	registerObject = new UserRegisterationPage(driver);
	    	registerObject.userRegisteration(firstName, lastName, email, password);
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
