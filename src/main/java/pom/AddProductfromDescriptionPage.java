package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductfromDescriptionPage {
	
	@FindBy (xpath = "//div[@class='grid_Square ']")private WebElement productslist;
	@FindBy (xpath = "//span[text()='Click here to Buy']")private WebElement buybutton;

	
	public AddProductfromDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClikOnProduct(WebDriver driver, int product)
	{
		Set<String> a= driver.getWindowHandles();
		Iterator <String> a1=a.iterator();
		driver.switchTo().window(a1.next());
		//driver.switchTo().window(a1.next());
		System.out.println(driver.getTitle());
		productslist.click();
		
	}
	public void clikOnBuyButton(WebDriver driver)	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOf(buybutton));
		buybutton.click();
	
	}

}
