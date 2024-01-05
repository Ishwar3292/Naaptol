package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.AddProductfromDescriptionPage;
import pom.NaaptolHomePage;
import utility.Reports;

public class AddProductUsingDescription extends BaseTest {
	
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
   public void verifyIfUserIsAbleToAddProductToCartUsingDescription() throws InterruptedException 
   {
	   Test=extentReport.createTest("verifyIfUserIsAbleToSearchProduct");
		NaaptolHomePage naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterSearch("mobiles");
		naaptolHomePage.clickOnSearchButton();
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=mobile"));
		//Assert.assertEquals(naaptolHomePage.getMobileHeading(),"mobile" );
		
		AddProductfromDescriptionPage addToCartDescription=new AddProductfromDescriptionPage(driver);

		addToCartDescription.ClikOnProduct(driver, 0);
		addToCartDescription.clikOnBuyButton(driver);
		String currentTitle =driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("https://www.naaptol.com/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html"));



}
}