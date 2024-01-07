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
		Assert.assertTrue(currenturl.contains("mobile"));
		//Assert.assertEquals(naaptolHomePage.getMobileHeading(),"mobiles" );
		
		productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
		cartPage=new CartPage(driver);
		//cartPage.clickOnRemove();
		Assert.assertEquals(cartPage.getNumberOfProduct(driver),1);
		
	}
	
	@Test(priority=2)
	public void verifyIfUserIsAbleToAddMultipleProductToCartUsingQuickViewOption() throws InterruptedException {
		Test=extentReport.createTest("verifyIfUserIsAbleToAddMultipleProductToCartUsingQuickViewOption()");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=mobile"));
		
	    productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
	
		productQuickViewPage=new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();
		
	    cartPage=new CartPage(driver);
		cartPage.clickOnContinueShopping(driver);
		
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage.clickHereToBuy();
		
		cartPage=new CartPage(driver);
		//Assert.assertEquals(cartPage.getNumberOfProduct(driver), 2);
		cartPage.clickOnRemove(driver, 1);
		cartPage.clickOnRemove(driver, 0);
		
		
		
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
