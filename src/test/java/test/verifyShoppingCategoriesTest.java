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
import pom.NaaptolHomePage;
import utility.Reports;
@Listeners(test.Listener.class)
public class verifyShoppingCategoriesTest extends BaseTest {
	
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
	
	@Test
	public void verifyIfUserIsAbleToAccessShoppingCategories() {
		
		Test=extentReport.createTest("verifyIfUserIsAbleToAccessShoppingCategories");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.clickOnShoppingCategories();
		naaptolHomePage.selectShoppingCategories(driver, 3);
		String currentTitle =driver.getTitle();
		Assert.assertTrue(currentTitle.contains("Mobile Handset"));
		Assert.assertEquals(naaptolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");	
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