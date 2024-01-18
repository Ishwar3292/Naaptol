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
		naaptolHomePage.clickOnLogin(driver);
		naaptolHomePage.enterMobileNumber("9637289331");
		naaptolHomePage.clickOnContinueButton();
		naaptolHomePage.clickOnSubmit();
		
		naaptolHomePage.enterSearch("laptop");
		naaptolHomePage.clickOnSearchButton();
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage.clickHereToBuy();
		
		cartPage=new CartPage(driver);
		//double expectedOrderAmount=cartPage.getOrderAmount(driver,0);
		System.out.println(cartPage.getOrderAmount(driver, 0));
		System.out.println(cartPage.getProductName(0));
		
		cartPage.clickOnProceedToCheckout();
		
//		paymentPage=new PaymentPage(driver);
//		paymentPage.selectTitle("Mr.");
//		paymentPage.enterFirstName("Ishwar");
//		paymentPage.enterLastName("Shinde");
//		paymentPage.enterAddress("Murud Tq&Dist-Latur");
//		paymentPage.enterPinCode("413510");
////		paymentPage.selectState("MAHARASHTRA");
////		paymentPage.selectCity("Latur");
//		paymentPage.enterMobileNumber(driver,"(9637289331");
//		paymentPage.clickOnAddNewAddress();
		paymentPage.clickOnaddress(0);
		paymentPage.clickOnPaymentOption(driver,0);
		paymentPage.clickOnClickHereToPlaceOrder();
		
		System.out.println(paymentPage.getOrderProductPrice());
		System.out.println(paymentPage.getOrderProductName());
		
//		Assert.assertTrue(cartPage.getOrderAmount(driver, 0)==paymentPage.getOrderProductPrice());
//		Assert.assertTrue(cartPage.getProductName(0)==paymentPage.getOrderProductName());
		
		naaptolHomePage.clickOnTrackorder();
		naaptolHomePage.clickOnCancelOrder(driver);
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
