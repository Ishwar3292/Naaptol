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

	@FindBy(xpath = "//div[@id='cartItems']")private List<WebElement> products;
	@FindBy(xpath = "(//a[@class='red_button2'])[1]")private WebElement proceedToCheckout;
	@FindBy(xpath = "(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy(xpath = "//a[text()='Remove']")private List<WebElement> remove;
	@FindBy(xpath = "//ul[@id='cartData']")private WebElement removeButton;
	

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberOfProduct(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return products.size();
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
//	public void clickOnRemove(WebDriver driver) throws InterruptedException {
//				
//		try {
//			Thread.sleep(1000);
//			WebElement a = driver.findElement(By.xpath("//span[@class='font-bold-imp']"));
//			System.out.println(a.getText());
//			String ab = a.getText().toString().replace("(", "").replace(")", "");
//			System.out.println(ab);
//			int y = Integer.parseInt(ab);
//			int number = y;
//		
//			for (int i = 0; i <= number - 1; i++) {
//				Thread.sleep(1000);
//				WebElement b = driver.findElement(By.xpath("(//a[text()='Remove'])[1]"));
//				Thread.sleep(1000);
//				b.click();
//			}
//		} catch (Exception e) {
//
//		}
//      }
}
