package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	@FindBy(tagName = "td")
	public List<WebElement> allColms;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement firstProductLbl;
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement secondProductLbl;
	@FindBy(css = "a.clear-list")
	WebElement clearBtn;
	@FindBy(css = "div.no-data")
	public WebElement nodataLbl;

	public void compareProducts() {
		System.out.println(allRows.size());
		for (WebElement row : allRows) {
			System.out.println(row.getText() + "\t");
			for (WebElement col : allColms) {
				System.out.println(col.getText() + "\t");
			}
		}
		clickButton(clearBtn);
	}
}
