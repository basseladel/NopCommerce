package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FriendEmail")
	 WebElement emailFriendTxtBox;
	@FindBy(id ="PersonalMessage")
	WebElement messageTxtArea;
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendBtn;
	@FindBy(css= "div.result")
	public WebElement successMsg;
	
	public void emailFriend(String emailFriend, String message) {
		setText(emailFriendTxtBox, emailFriend);
		setText(messageTxtArea, message);
		clickButton(sendBtn);
	}
	

}
