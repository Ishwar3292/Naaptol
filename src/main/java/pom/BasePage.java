package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public void switchToPage(WebDriver driver, String ExpectedTitle)
	{
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> a=handle.iterator();
		
		
		while(a.hasNext())
		{
			String handle1=a.next();
			driver.switchTo().window(handle1);
			if(driver.getTitle().contains(ExpectedTitle))
			{
				break;
			}

		}
	}


}
