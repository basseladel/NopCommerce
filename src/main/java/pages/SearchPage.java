package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id ="small-searchterms")
	WebElement searchTxtBox;
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	@FindBy(xpath = "//div/h2/a[@href='/apple-macbook-pro-13-inch']")
	WebElement productDetailLink;
	
	public void searchProduct(String productName) {
		setText(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	public void openProductDetailPage() {
		clickButton(productDetailLink);
	}
	
	public void searchProductAutoComplete(String productName) {
		setText(searchTxtBox, productName);
		productList.get(0).click();
	}
	
}
