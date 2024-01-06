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
import pom.ProductResultPage;
import utility.Reports;

public class ProductDescriptionTest extends BaseTest {
	
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
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		productResultPage.clickOnProduct(0);
		
		AddProductfromDescriptionPage addToCartDescriptionPage=new AddProductfromDescriptionPage(driver);
		addToCartDescriptionPage.switchToPage(driver, "https://www.naaptol.com/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html");
		addToCartDescriptionPage.clikOnBuyButton();
		
		
		
}
}