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
import pom.NaaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listener.class)
public class VerifySearchTabTest extends BaseTest {
	
	ExtentReports extentReport;
	ExtentTest Test;
	@BeforeTest
	public void configureReports() {
		extentReport=Reports.generateReport();
	}
	// @Parameters({"browser"})
	// @BeforeMethod
	//  public void openChrome(String browser) {
//
	//  driver=LaunchBrowser.browser(browser);
	//	}
	@BeforeMethod
	public void openApplication() {
		driver=LaunchBrowser1.Chrome();
		
	}

	@Test(priority = 1)
	public void verifyIfProdutsAreDisplayedOnValidSearch() {
		Test=extentReport.createTest("verifyIfUserIsAbleToSearchProduct");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("mobile"));
		//Assert.assertEquals(naaptolHomePage.getMobileHeading(),"mobile" );
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfproducts()>0);
		
	}
	
	@Test(priority = 2)
	public void verifyIfProdutsAreNotDisplayedOnInvalidSearch() {
		Test=extentReport.createTest("verifyIfProdutsAreNotDisplayedOnInvalidSearch");
		NaaptolHomePage naptoolHomePage = new NaaptolHomePage(driver);
		naptoolHomePage.enterSearch("iphone");
		naptoolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("iphone"));
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfproducts()==0);
		
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
