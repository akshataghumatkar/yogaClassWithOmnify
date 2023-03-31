package testClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.Base;
import baseClass.Utility;
import pomClass.Tc_01_Pom;

public class TestLogin {
	
	WebDriver driver;
	Base b;
	int tcID;
	
	@BeforeClass
	public void launchBrowser() {
		b = new Base();
		driver = b.initialiseBrowser();
		
	}
	
	@BeforeMethod
	public void refreshBrowser() {
		driver.navigate().refresh();
	}
	
	@Test
	public void tc01_login_validCredentials() throws InterruptedException, EncryptedDocumentException, IOException {
		tcID=01;
		Tc_01_Pom log = new Tc_01_Pom(driver);
		log.clickOnJoinClassButn();
		log.enterEmailId(Utility.getData(2, 1));
		log.enterPass(Utility.getData(2, 2));
		log.clickOnLoginButn();
		String actTxt=log.getWelcomTxt();
		Reporter.log(actTxt, true);
		Thread.sleep(1000);
		String expTxt="Welcome back, Akshata Ghumatkar! You can attend 2 FREE trial classes at your preferred time. Choose a class below and click on \"Join\" when you're ready.";
		Assert.assertEquals(actTxt, expTxt);
		
		log.selectLocation();
		log.selectLocation_Online();
		Thread.sleep(1000);
		log.selectTrainer();
		log.selectTypeOfService();
		Thread.sleep(1000);
		log.selectDayFromWeek();
		log.selectStartDate_Time();
		Thread.sleep(1000);
		log.selectEndDate_Time();
		
		
	}
	
	
		
		
	
	
	
	
	
	
	@AfterMethod 
	public void afterTestcase(ITestResult res) throws IOException {
		if(ITestResult.FAILURE==res.getStatus()) {
			Utility.captureScreenshot(driver, tcID);
		}
		
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("---close browser---", true);
		//driver.close();
	}
	

}
