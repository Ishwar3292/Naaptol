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
import pom.CheckDetailPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listener.class)
public class CheckDetailTest extends BaseTest {
	
	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;
	
	ExtentReports extentReport;
	ExtentTest Test;
	
	@BeforeTest
	public void configureReports() {
		extentReport=Reports.generateReport();
	}
	@BeforeMethod
	public void openBrowser() {
		driver=LaunchBrowser1.Chrome();
	}
//	@Parameters({"browser"})
//	@BeforeMethod
//	public void openApplication(String browser) {
//		driver=LaunchBrowser.browser(browser);
//	}
	
	@Test(priority = 1)
	public void VerifyIfuserIsAbleToAddProductToCartFromProductDescriptionPage() {
		Test=extentReport.createTest("VerifyIfuserIsAbleToAddProductToCartFromProductDescriptionPage");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		CheckDetailPage checkDetailPage=new CheckDetailPage(driver);
		String Title=checkDetailPage.getProductTitle(1);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		String Title1=productQuickViewPage.getQuickViewTitle();
		Assert.assertTrue(Title.contentEquals(Title1));
		
		
	}
	@Test(priority = 2)
	public void VerifyIfProductsDetailsOnQuickViewTab() throws InterruptedException {
		Test=extentReport.createTest("VerifyIfProductsDetailsOnQuickViewTab");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("Laptop");
		naaptolHomePage.clickOnSearchButton();
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		String expectedProductName=productQuickViewPage.getProductName(driver);
		
		double expectedProductPrice=productQuickViewPage.getProductPrice(driver);
		
		double expectedShippingCharges=productQuickViewPage.getShippingCharges();
		
		productQuickViewPage.clickHereToBuy();
		
		CartPage cartPage=new CartPage(driver);
		Assert.assertEquals(cartPage.getProductName(0),expectedProductName );
		Assert.assertEquals(cartPage.getUnitPrice(0),expectedProductPrice );
		Assert.assertEquals(cartPage.getShippingPrice(0), expectedShippingCharges);
			
	}
	@Test(priority = 3)
	public void AddSingleToCartAndVerifyIfUnitPriceAdditionShippingPriceIsEqualToOrderAmount() throws InterruptedException  {
		Test=extentReport.createTest("AddSingleToCartAndVerifyIfUnitPriceAdditionShippingPriceIsEqualToOrderAmount");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
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
	}
	
	@Test(priority = 4)
	public void AddTwoProductToCartAndVerifyIfUnitPriceAddShippingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount() throws InterruptedException {
		Test=extentReport.createTest("AddTwoProductToCartAndVerifyIfUnitPriceAddShippingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobile");
		naaptolHomePage.clickOnSearchButton();
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage=new CartPage(driver);
		cartPage.clickOnContinueShopping(driver);
		
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage.clickHereToBuy();
		
		double orderAmount1=cartPage.getOrderAmount(driver, 0);
		
		double orderAmount2=cartPage.getOrderAmount(driver, 1);
		
		double expectedCartAmount=cartPage.getCartAmount();
		
		Assert.assertTrue(orderAmount1+orderAmount2==expectedCartAmount);
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

