package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage {
	
	@FindBy (xpath= "//select[@id='fktitle_id']")private WebElement title;
	@FindBy (xpath= "//input[@id='firstName']")private WebElement firstName; 
	@FindBy (xpath= "//input[@id='lastName']")private WebElement lastName; 
	@FindBy (xpath= "//textarea[@id='address']")private WebElement address ;
	@FindBy (xpath= "//input[@id='pincode']")private WebElement pinCode;
	@FindBy (xpath= "//select[@id='state']")private WebElement state ; 
	@FindBy (xpath= "//select[@id='city']")private WebElement city ;
	@FindBy (xpath= "//input[@id='mobile']")private WebElement mobileNo ;
	@FindBy (xpath= "//a[@id='addEditButton']")private WebElement addNewAddress;
	@FindBy (xpath= "//div[@class='shipAddress_Exists']//ul//a//span")private List<WebElement> clickAddress;
	@FindBy (xpath= "//a[text()='Click here to Place Order']")private WebElement clickHereToPlaceOrder;
	
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitle(String Title) {
		Select select=new Select(title);
		select.selectByVisibleText(Title);
		
	}
	public void enterFirstName(String firstN) {
		firstName.sendKeys(firstN);
	}
	public void enterLastName(String lastN) {
		lastName.sendKeys(lastN);
	}
	public void enterAddress(String addr) {
		address.sendKeys(addr);
	}
	public void enterPinCode(String pin) {
		pinCode.sendKeys(pin);
	}
	public void selectState(String State) {
		Select select=new Select(state);
		select.selectByVisibleText(State);
	}
	public void selectCity(String City) {
		Select select=new Select(city);
		 select.selectByVisibleText(City);
	}
	public void enterMobileNumber(String number) throws InterruptedException {
		Thread.sleep(2000);
		mobileNo.sendKeys(number);
	}
	public void clickOnAddNewAddress() {
		addNewAddress.click();
	}
	public void clickOnaddress(int index) {
		clickAddress.get(index).click();
	}
	public void clickOnClickHereToPlaceOrder() {
		clickHereToPlaceOrder.click();
	}
	
}
