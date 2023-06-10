package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "a.product-name")
	public WebElement productLabel;
	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	@FindBy(css = "div.no-data")
	public WebElement successMsg;
	
	
	public void removeProduct() {
	 clickButton(removeBtn);	
	}

}
