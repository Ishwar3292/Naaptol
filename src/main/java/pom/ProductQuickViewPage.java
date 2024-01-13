package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductQuickViewPage extends BasePage {

	@FindBy (xpath= "//div[@class='item_title']//a")private List<WebElement> productTitle;
	@FindBy(xpath = "//div[@id='square_Details']//h1")private WebElement productName;
	@FindBy (xpath= "//div[@id='square_Details']//h1") private WebElement quickViewTitle;
	@FindBy(xpath = "//span[@class='offer-price']")private WebElement price;
	@FindBy(xpath = "//span[@class='ship-price']")private WebElement shippingCharges;
	@FindBy(xpath = "//a[@id='cart-panel-button-0']")private WebElement clickHereToBuy;
	

	public ProductQuickViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}
	
	public String getProductName(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(clickHereToBuy));
		
		return productName.getText();
	}
	
	public String getQuickViewTitle() {
		return quickViewTitle.getText();
	}

	public double getProductPrice(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(clickHereToBuy));
		
		return Double.parseDouble( price.getText());
	}

	public double getShippingCharges() {
		String charges = shippingCharges.getText();
		String[] charge = charges.split(" ");
		return Double.parseDouble(charge[1]);

	}

	public void clickHereToBuy() {
		clickHereToBuy.click();
	}

}
