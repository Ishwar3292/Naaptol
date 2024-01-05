package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {
	
	@FindBy (xpath= "//div[@id='square_Details']//h1")private WebElement productName;
	@FindBy (xpath= "//span[@class='offer-price']")private WebElement price;
	@FindBy (xpath= "//span[@class='ship-price']")private WebElement shippingCharges;
	@FindBy (xpath= "//a[@id='cart-panel-button-0']")private WebElement clickHereToBuy;
	
	public ProductQuickViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductPrice() {
		return price.getText();
	}
	
	public String getShippingCharges() {
		String charges= shippingCharges.getText();
		String [] charge=charges.split(" ");
		return charge[1];
		
	}
	
	public void clickHereToBuy() {
		clickHereToBuy.click();
	}
	

}
