package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDrppwn;
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxtBox;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxtBox;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxtBox;
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipTxtBox;
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShippingmethodBtn;
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continuePaymentmethodBtn;
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continuePaymentinfoBtn;
	@FindBy(css = "a.product-name")
	public WebElement productName;
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	@FindBy(xpath = "//div[@class='section order-completed']/div[1]")
	public WebElement sucessMsg;
	@FindBy(css="div.details-link")
	WebElement orderDetailsLink;
	
	
	public void productCheckout(String country, String city, String address, String phoneNumber, String zip) {
		select = new Select(countryDrppwn);
		select.selectByVisibleText(country);
		setText(cityTxtBox, city);
		setText(addressTxtBox, address);
		setText(phoneTxtBox, phoneNumber);
		setText(ZipTxtBox, zip);
		clickButton(continueBtn);
		clickButton(continueShippingmethodBtn);
		clickButton(continuePaymentmethodBtn);
		clickButton(continuePaymentinfoBtn);
		clickButton(confirmBtn);
	}
	public void openOrderDetails() {
		clickButton(orderDetailsLink);
	}
}
