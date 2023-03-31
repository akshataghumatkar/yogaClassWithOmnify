package baseClass;

import java.util.concurrent.TimeUnit;
import org.testng.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	
	
	public WebDriver initialiseBrowser() {
		
		String str ="chrome";
		Reporter.log(str,true);
		if(str.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Configuration.appUrl);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return driver;
			
		}
		else {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Configuration.appUrl);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
 }

}
