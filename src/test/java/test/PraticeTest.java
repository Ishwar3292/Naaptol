package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class PraticeTest extends BaseTest {

	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;

	@BeforeMethod
	public void openChrome() {

		driver = LaunchBrowser.chrome();
	}

	@Test
	public void searchProduct() throws InterruptedException {
		NaaptolHomePage naaptolhomePage = new NaaptolHomePage(driver);
		naaptolhomePage.enterSearch("Laptop");
		naaptolhomePage.clickOnSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);

		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickHereToBuy();

		cartPage = new CartPage(driver);
		// cartPage.clickOnRemove(driver, 0);
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
