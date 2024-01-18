package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy (xpath= "//div[@class='shipAddress_Exists']//ul//a//span")private List<WebElement> shipToThisAddress;
	@FindBy (xpath= "//a[text()='Click here to Place Order']")private WebElement clickHereToPlaceOrder;
	@FindBy (xpath= "//ul[@class='verticalslider_tabs']//li")private List<WebElement>paymentOption;
	@FindBy (xpath= "(//td//p)[2]")private WebElement orderProductName;
	@FindBy (xpath= "(//td//span)[6]")private WebElement orderProductPrice;
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
	public void selectState(String State) throws InterruptedException {
		Thread.sleep(2000);
		Select select=new Select(state);
		select.selectByVisibleText(State);
	}
	public void selectCity(String City) throws InterruptedException {
		Thread.sleep(2000);
		Select select=new Select(city);
		 select.selectByVisibleText(City);
	}
	public void enterMobileNumber(WebDriver driver,String number) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(mobileNo));
		mobileNo.sendKeys(number);
	}
	public void clickOnAddNewAddress() {
		addNewAddress.click();
	}
	public void clickOnaddress(int index) throws InterruptedException {
		Thread.sleep(2000);
		shipToThisAddress.get(index).click();
	}
	public void clickOnClickHereToPlaceOrder() {
		clickHereToPlaceOrder.click();
	}
	public String getOrderProductName() {
		return orderProductName.getText();
	}
	public double getOrderProductPrice() {
		return Double.parseDouble(orderProductPrice.getText().replace(",", "").replace("/-", ""));
	}
	public void clickOnPaymentOption(WebDriver driver,int index) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(clickHereToPlaceOrder));		
		paymentOption.get(index).click();
	}
}
