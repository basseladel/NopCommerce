package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.qty-input")
	WebElement quantityInput;
	@FindBy(css = "span.product-subtotal")
	public WebElement totalPriceLbl;
	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	@FindBy(id = "updatecart")
	WebElement updateCartBtn;
	@FindBy(css = "div.no-data")
	public WebElement nodataLbl;
	@FindBy(id = "termsofservice")
	WebElement termsInput;
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public void updateCart(String quantity) {
		clearText(quantityInput);
		setText(quantityInput, quantity);
		clickButton(updateCartBtn);
	}

	public void removeProduct() {
		clickButton(removeBtn);
	}
	public void openCheckoutPage() {
		clickButton(termsInput);
		clickButton(checkoutBtn);
	}

}
