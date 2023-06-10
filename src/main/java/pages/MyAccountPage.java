package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//li/a[@href=\"/customer/changepassword\"]")
	WebElement changePasswordLink;
	@FindBy(id ="OldPassword")
	WebElement oldPasswordTxtBox;
	@FindBy(id ="NewPassword")
	WebElement newPasswordTxtBox;
	@FindBy(id ="ConfirmNewPassword")
	WebElement confirmPasswordTxtBox;
	@FindBy(css ="button.button-1.change-password-button")
	WebElement changePasswordBtn;
	@FindBy(css="div.bar-notification.success")
	public WebElement successMsg;
	
	public void changePassword(String oldPassword, String newPassword) {
		clickButton(changePasswordLink);
		setText(oldPasswordTxtBox, oldPassword);
		setText(newPasswordTxtBox, newPassword);
		setText(confirmPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);
	}

}
