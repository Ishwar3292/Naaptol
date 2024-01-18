package pom;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import freemarker.core.JavaScriptCFormat;

public class CartPage extends BasePage {

	@FindBy (xpath = "//div[@id='cartItems']")private List<WebElement> products;
	@FindBy (xpath = "(//a[@class='red_button2'])[1]")private WebElement proceedToCheckout;
	@FindBy (xpath = "(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy (xpath = "//a[text()='Remove']")private List<WebElement> remove;
	@FindBy (xpath = "//ul[@id='cartData']")private WebElement removeButton;
	@FindBy (xpath = "//ul[@id='cartData']//h2//a")private List<WebElement> productName;
	@FindBy (xpath = "//ul[@id='cartData']//li[3]")private List<WebElement> unitPrice;
	@FindBy (xpath = "//ul[@id='cartData']//li[4]")private List<WebElement> shippingPrice;
	@FindBy (xpath = "//ul[@id='cartData']//li[5]")private List<WebElement> orderAmount;
	@FindBy (xpath = "(//ul[@id='cartTotal']//label)[1]") private WebElement cartAmount;
	
	

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberOfProduct(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return products.size();
	}
	
	public void clickOnProceedToCheckout() {
		proceedToCheckout.click();
	}

	public void clickOnContinueShopping(WebDriver driver)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(continueShopping));
		continueShopping.click();
	}

	public void clickOnRemove(WebDriver driver,int index) throws InterruptedException {
		Thread.sleep(1000);
		remove.get(index).click();
		
		}
	
	public String getProductName(int index) {
		
		return productName.get(index).getText();
	}
	public double getUnitPrice(int index) {
	return	Double.parseDouble(unitPrice.get(index).getText().substring(3).replace(",", ""));
	}
	
	public double getShippingPrice(int index) {
		return Double.parseDouble(shippingPrice.get(index).getText().substring(3).replace(",", ""));
	}
	
	public double getOrderAmount(WebDriver driver,int index) throws InterruptedException  {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(cartAmount));
//		Thread.sleep(2000);
		return Double.parseDouble(orderAmount.get(index).getText().replace(",", ""));
	}
	
	public double getCartAmount() {
		return Double.parseDouble(cartAmount.getText().substring(3).replace(",", ""));
//		String a=cartAmount.getText().substring(3).replace(",", "");
//		return Double.parseDouble(a);
	}
		
	
}



