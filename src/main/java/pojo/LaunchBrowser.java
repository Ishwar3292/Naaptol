package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class LaunchBrowser {
	
	public static WebDriver browser(String name) {
		WebDriver driver = null;
		
		if(name.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
//		else if(name.equalsIgnoreCase("Opera")) {
//			
//			WebDriverManager.operadriver().setup();
//			driver=new OperaDriver();
	//	}
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));		
		return driver;
		
	}
}
