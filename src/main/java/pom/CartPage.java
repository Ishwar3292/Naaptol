package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	@FindBy (xpath= "//div[@id='cartItems']")private List<WebElement> products;
	@FindBy (xpath= "(//a[@class='red_button2'])[1]")private WebElement proceedToCheckout;
	@FindBy (xpath= "(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy (xpath= "//a[text()='Remove']")private List<WebElement> remove;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProduct(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return products.size();
	}
	
	public void clickOnContinueShopping() {
		
		continueShopping.click();
	}
	
	public void clickOnRemove(int index) {
		remove.get(index).click();
		}
	}

