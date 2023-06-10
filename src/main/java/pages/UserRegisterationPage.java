package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(css = "div.result")
	public WebElement sucessMsg;

	public void userRegisteration(String firstname, String lastname, String email, String password) {

		clickButton(genderRdoBtn);
		setText(fnTxtBox, firstname);
		setText(lnTxtBox, lastname);
		setText(emailTxtBox, email);
		setText(passwordTxtBox, password);
		setText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}

}
