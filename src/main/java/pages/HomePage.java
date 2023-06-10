package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	@FindBy(xpath = "//li/a[@class='ico-account']")
	WebElement myAccountLink;
	@FindBy(xpath = "//div/ul/li/a[@href='/contactus']")
	WebElement contactUs;
	@FindBy(id ="customerCurrency")
	WebElement currencyDdl;
	@FindBy(xpath  = "//div[@class='header-menu']/ul[1]/li[1]/a[1]")
	WebElement computerMenu;
	@FindBy(xpath  = "//div[@class='header-menu']/ul[1]/li[1]/ul/li[2]")
	WebElement notebooksMenu;
	
	public void openRegisterationPage() {
		clickButton(registerLink);
		
	}
	public void openLoginPage() {
		clickButton(loginLink);
	}
	public void logout() {
		clickButton(logoutLink);
	}
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}
	public void openContactUsPage() {
	  scrollToButton();
	  clickButton(contactUs);
	}
	public void changeCurrency() {
		select = new Select(currencyDdl);
		select.selectByVisibleText("Euro");
	}
	public void selectNotebooksMenu() {
		action.moveToElement(computerMenu).moveToElement(notebooksMenu).click().build().perform();
	}

}
