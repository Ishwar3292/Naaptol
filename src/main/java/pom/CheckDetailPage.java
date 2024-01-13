package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckDetailPage {
	
	@FindBy (xpath= "//div[@class='item_title']//a")private List<WebElement> productTitle;
	@FindBy (xpath= "//div[@id='square_Details']//h1") private WebElement quickViewTitle;
	@FindBy (xpath= "//div[@id='cartItems']//h2")private List <WebElement> cartTitle;
	@FindBy (xpath="//ul[@id='cartData']//li[3]")private List<WebElement> unitPrice;
	@FindBy (xpath="//ul[@id='cartData']//li[4]")private List<WebElement> shipping;
	@FindBy (xpath="//ul[@id='cartData']//li[5]")private List<WebElement> orderAmount;
	@FindBy (xpath="//ul[@id='cartTotal']//li[3]")private List<WebElement> totalAmount;
	
	public CheckDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}
	
	public String getQuickViewTitle() {
		return quickViewTitle.getText();
	}
	
	public String getCartTitle(int index) throws InterruptedException {
		Thread.sleep(2000);
		return cartTitle.get(index).getText();	
	}
	public String getUnitPrice(int index) {
		return unitPrice.get(index).getText();
		
	}
	
	public int getShippingPrice(int index) {
		 String a=shipping.get(index).getText();
		return Integer.parseInt(a);
	}
	
	public int getOrderAmount(int index) {
		String b =orderAmount.get(index).getText();
		return Integer.parseInt(b);
	}
	
	public int getTotalAmount() {
		String c=totalAmount.get(0).getText();
		return Integer.parseInt(c);
	}

}
