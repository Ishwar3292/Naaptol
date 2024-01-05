package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listener.class)
public class AddToCartTest extends BaseTest {
	
	ExtentReports extentReport;
	ExtentTest Test;
	@BeforeTest
	public void configureReports() {
		extentReport=Reports.generateReport();
	}
	
	@BeforeMethod
	public void openApplication() {
		driver=LaunchBrowser.chrome();
	}
	
	@Test(priority=1)
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() {
		Test=extentReport.createTest("verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption()");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=mobile"));
		//Assert.assertEquals(naaptolHomePage.getMobileHeading(),"mobiles" );
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		Assert.assertTrue(productResultPage.getNumberOfproducts()>0);
		
		ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		CartPage cartPage=new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProduct(driver),1);
		
	}
	
	@Test(priority=2)
	public void verifyIfUserIsAbleToAddMultipleProductToCartUsingQuickViewOption() {
		Test=extentReport.createTest("verifyIfUserIsAbleToAddMultipleProductToCartUsingQuickViewOption()");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=mobile"));
		//Assert.assertEquals(naaptolHomePage.getMobileHeading(),"mobiles" );
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		Assert.assertTrue(productResultPage.getNumberOfproducts()>0);
		
		ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnContinueShopping();
		
		ProductResultPage productResultPage1=new ProductResultPage(driver);
		productResultPage1.clickOnQuickView(driver, 1);
		Assert.assertTrue(productResultPage.getNumberOfproducts()>0);
		
		ProductQuickViewPage productQuickViewPage1=new ProductQuickViewPage(driver);
		productQuickViewPage1.clickHereToBuy();
		
		CartPage cartPage1=new CartPage(driver);
		//Assert.assertEquals(cartPage1.getNumberOfProduct(driver), 2);
		cartPage1.clickOnRemove(0);
		
	}
//	@AfterMethod
//	public void addTestStatus(ITestResult result) {
//		
//		if(result.getStatus()==ITestResult.SUCCESS) {
//			
//			Test.log(Status.PASS, result.getName());
//		}
//		else if(result.getStatus()==ITestResult.FAILURE) {
//			
//			Test.log(Status.FAIL, result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			
//			Test.log(Status.SKIP, result.getName());
//		}
//    
//	}
//	
//	 @AfterTest
//     public void publishReports() {
//
//    	 extentReport.flush();
//        }
//	

}
