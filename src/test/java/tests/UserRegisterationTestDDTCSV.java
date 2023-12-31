package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestDDTCSV extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	@Test(priority = 1)
    public void registerSuccesssfully() throws IOException {
		String csv_file = System.getProperty("user.dir") + "/src/test/java/data/TestData.csv";
		reader = new CSVReader(new FileReader(csv_file));
		String[] csvCell;
		
		while(((csvCell = reader.readNext()) != null)) {
			
			String firstname = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			homeObject = new HomePage(driver);
	    	homeObject.openRegisterationPage();
	    	registerObject = new UserRegisterationPage(driver);
	    	registerObject.userRegisteration(firstname, lastName, email, password);
	    	Assert.assertTrue(registerObject.sucessMsg.getText().contains("Your registration completed"));
	    	homeObject.openLoginPage();
	    	loginObject = new LoginPage(driver);
	    	loginObject.userLogin(email, password);
	    	Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	    	homeObject.logout();
		}
    	
    }
  
    
}
