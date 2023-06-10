package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
  HomePage homeObject;
  ContactUsPage contactUsObject;
  String name =  "Bassel";
  String email = "b.aaa@yahoo.com";
  String enquiry ="duaa";
  
  @Test
  public void contactUs() {
	  homeObject = new HomePage(driver);
	  homeObject.openContactUsPage();
	  contactUsObject = new ContactUsPage(driver);
	  contactUsObject.contactUs(name, email, enquiry);
	  Assert.assertTrue(contactUsObject.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
  }
}
