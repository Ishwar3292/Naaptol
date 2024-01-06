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

public class AddProductfromDescriptionPage extends BasePage{
	

	@FindBy (xpath = "//span[text()='Click here to Buy']")private WebElement buybutton;

	
	public AddProductfromDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clikOnBuyButton()	{
		
		buybutton.click();
	
	}

}
