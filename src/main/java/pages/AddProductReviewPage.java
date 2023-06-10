package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase {

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "AddProductReview_Title")
   WebElement reviewTitleTxtBox;
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTextTxtArea;
	@FindBy(id = "addproductrating_4")
	WebElement ratingRadBtn;
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitBtn;
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void addReview(String reviewTitle, String review) {
		setText(reviewTitleTxtBox, reviewTitle);
		setText(reviewTextTxtArea, review);
		clickButton(ratingRadBtn);
		clickButton(submitBtn);
	}
}