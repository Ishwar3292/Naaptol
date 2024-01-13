package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pojo.LaunchBrowser1;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listener.class)
public class PraticeTest extends BaseTest {

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
		driver=LaunchBrowser1.Chrome();
		
	}
//    @Parameters({"browser"})
//	@BeforeMethod
//	public void openChrome(String browser) {
//
//		driver=LaunchBrowser.browser(browser);
//	}

	@Test
	public void searchProduct() throws InterruptedException {
		Test=extentReport.createTest("searchProduct");
		NaaptolHomePage naaptolhomePage = new NaaptolHomePage(driver);
		naaptolhomePage.enterSearch("Laptop");
		naaptolhomePage.clickOnSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);

		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();

		cartPage = new CartPage(driver);
		cartPage.clickOnContinueShopping(driver);

		productResultPage.clickOnQuickView(driver, 1);

		productQuickViewPage.clickHereToBuy();
		
		cartPage.clickOnContinueShopping(driver);
		
		productResultPage.clickOnQuickView(driver, 2);
		
		productQuickViewPage.clickHereToBuy();
		
		cartPage.clickOnRemove(driver,2);
		cartPage.clickOnRemove(driver,1);
		cartPage.clickOnRemove(driver, 0);

	}

}
