package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pojo.LaunchBrowser1;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.PaymentPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listener.class)
public class PaymentTest extends BaseTest{
	
	NaaptolHomePage naaptolHomePage;
	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	
	ExtentReports extentReport;
	ExtentTest Test;
	
	@BeforeTest
	public void configureReports() {
		extentReport=Reports.generateReport();
	}
	@BeforeMethod
	public void openApplication() {
		driver=LaunchBrowser1.Chrome();
		
	}
//	@Parameters({"browser"})
//	@BeforeMethod
//	public void openApplication(String browser) {
//		driver=LaunchBrowser.browser(browser);
//	}
	@Test
	public void paymentOption() throws InterruptedException {
		Test=extentReport.createTest("paymentOption");
		naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobile");
		naaptolHomePage.clickOnSearchButton();
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage=new CartPage(driver);
		double expectedOrderAmount=cartPage.getOrderAmount(driver,0);
		System.out.println(expectedOrderAmount);
		Assert.assertTrue(cartPage.getUnitPrice(0)+cartPage.getShippingPrice(0)==expectedOrderAmount);
		
		cartPage.clickOnProceedToCheckout();
		
		naaptolHomePage.clickOnLogin();
		naaptolHomePage.enterMobileNumber("9673889954");
		naaptolHomePage.clickOnContinueButton();
		naaptolHomePage.clickOnSubmit(driver);
		
		paymentPage=new PaymentPage(driver);
		paymentPage.selectTitle("Mr.");
		paymentPage.enterFirstName("Ishwar");
		paymentPage.enterLastName("Shinde");
		paymentPage.enterAddress("At.POST Niwali,Tq&Dist-Latur");
		paymentPage.enterPinCode("413511");
		paymentPage.selectState("MAHARASHTRA");
		paymentPage.selectCity("LATUR");
		paymentPage.enterMobileNumber("9637289331");
		paymentPage.clickOnAddNewAddress();
		paymentPage.clickOnaddress(0);
		paymentPage.clickOnClickHereToPlaceOrder();
		
	}
	@AfterMethod
	public void addTestStatus(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			
			Test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			Test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			
			Test.log(Status.SKIP, result.getName());
		}
    
	}
	
	 @AfterTest
     public void publishReports() {

    	 extentReport.flush();
        }
	


}
