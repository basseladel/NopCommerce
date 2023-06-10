package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilsPage extends PageBase {

	public ProductDeatilsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul/li/strong[@class='current-item']")
	public WebElement productName;
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFreindBtn;
	@FindBy(id = "price-value-4")
	public WebElement priceLabel;
	@FindBy(xpath = "//div[@class='product-review-links']/a[2]")
	WebElement addReviewLink;
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement wishlistBtn;
	@FindBy(xpath = "//p/a[@href=\"/wishlist\"]")
	WebElement wishlistLink;
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	@FindBy(xpath = "//p/a[@href='/cart']")
	WebElement addToCartLink;

	

	public void openSendEmial() {
		clickButton(emailFreindBtn);
	}

	public void openReviewPage() {
		clickButton(addReviewLink);
	}

	public void openWishlistPage() {
		clickButton(wishlistBtn);
		clickButton(wishlistLink);
	}

	public void addToCompare() {
		clickButton(addToCompareBtn);
	}

	public void addToCart() {
		clickButton(addToCartBtn);
		clickButton(addToCartLink);
	}

}
