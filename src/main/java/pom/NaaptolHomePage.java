package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaaptolHomePage extends BasePage{
	
	@FindBy (xpath= "//a[@id='login-panel-link']") private WebElement login;
	@FindBy (xpath= "//a[text()='Track Order']") private WebElement trackOrder;
	@FindBy (xpath= "//div[@class='cate_head']") private WebElement shoppingCategories;
	@FindBy (xpath= "(//ul[@id='mainMenu_UL'])[1]//li")private List<WebElement> categories;
	@FindBy (xpath= "(//a[text()='Mobile Handsets'])[1]")private WebElement subCategories;
	@FindBy (xpath= "//li[@class='head']//h1")private WebElement categoriesHeading;
	@FindBy (xpath= "(//li[@class='head'])[1]//h1")private WebElement mobileHeading;
	@FindBy (xpath= "//input[@id='header_search_text']") private WebElement search;
	@FindBy (xpath= "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]") private WebElement searchButton;
	@FindBy (xpath= "(//a[@id='cart-panel-link'])[2]") private WebElement cart;
	@FindBy (xpath= "//input[@id='registration-basic-panel-mobile']")private WebElement mobileNumber;
	@FindBy (xpath= "//input[@id='registration-basic-panel-submit']")private WebElement continueButton;
	@FindBy (xpath= "(//input[@type='button'])[2]")private WebElement submit;
	@FindBy (xpath= "//a[@id='cancelOrder']")private WebElement cancelOrder;
	
	public NaaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin(WebDriver driver) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2));
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}
	
	public void clickOnTrackorder() throws InterruptedException {
		Thread.sleep(3000);
		trackOrder.click();
	}
	public void clickOnShoppingCategories() {
		
		shoppingCategories.click();
	}
	public void selectShoppingCategories(WebDriver driver,int index) {
		Actions action=new Actions(driver);
		action.moveToElement(categories.get(index));
		action.perform();
		subCategories.click();
	}
	public String getCategoryHeading() {
		return categoriesHeading.getText();
	}
	
	public String getMobileHeading() {
		return mobileHeading.getText();
	}
	
	public void enterSearch(String product) {
		
		search.sendKeys(product);
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void clickOnCart() {
		cart.click();
	}
	
	public void enterMobileNumber(String number) {
		mobileNumber.sendKeys(number);
	}
	
	public void clickOnContinueButton()  {
		continueButton.click();
	}
	
	public void clickOnSubmit() throws InterruptedException {
		Thread.sleep(50000);
		submit.click();
		Thread.sleep(3000);	
	}
	
	public void clickOnCancelOrder(WebDriver driver) {
		cancelOrder.click();
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
}
