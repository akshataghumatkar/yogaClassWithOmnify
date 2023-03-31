package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class Tc_01_Pom {
	
	@FindBy(xpath="(//a[@class='kuTaGy wixui-button zKbzSQ'])[4]") private WebElement join;
	@FindBy(xpath="//input [@id='login_email']") private WebElement email ;
	@FindBy(xpath="//input[@id='login_password']") private WebElement pass ;
	@FindBy(xpath="//button[text()='Login']") private WebElement logInButn ;
	@FindBy(xpath="(//div[@class='alert-msg'])[3]") private WebElement welcomeTxt;
	@FindBy(xpath="(//   div[@class='alert-msg'])[3]                        ") private WebElement loc;
	@FindBy(xpath="(//    div[@class='alert-msg'])[3]                       ") private WebElement loc_Online;
	@FindBy(xpath="(//   div[@class='alert-msg'])[3]                        ") private WebElement loc_Offline;
	@FindBy(xpath="(//   div[@class='alert-msg'])[3]                        ") private WebElement trainer;
	@FindBy(xpath="(//a[@class='primary-btn-inverse btn-small'])[1]") private WebElement freeService;
	@FindBy(xpath="(//a[@class='primary-btn-inverse btn-small'])[4]") private WebElement paidService;
	@FindBy(xpath="(//select[@='   class='alert-msg'])[3]      ']") private WebElement day;
	@FindBy(xpath="(//select[@='    class='alert-msg'])[3]      ']") private WebElement startDay;
	@FindBy(xpath="(//select[@='    class='alert-msg'])[3]      ']") private WebElement startTime;
	@FindBy(xpath="(//select[@='   class='alert-msg'])[3]        ']") private WebElement endDay;
	@FindBy(xpath="(//select[@='   class='alert-msg'])[3]        ']") private WebElement endTime;
	@FindBy(xpath="(//a[@data-turbolinks='false'])[2]") private WebElement logOut;
	
	
	
	
	
	WebDriver driver;
	
	
	public Tc_01_Pom(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	
	public void clickOnJoinClassButn() {
		String actStr = join.getText();
		Reporter.log(actStr,true);
		String expStr="join class";
		Assert.assertEquals(actStr, expStr);
		
		join.click();
	}
	
	public void enterEmailId(String Id) {
		email.sendKeys(Id);
	}
	
	public void enterPass(String password) {
		pass.sendKeys(password);
	}
	public void clickOnLoginButn() {
		logInButn.click();
		
	}
	public String getWelcomTxt() {
		String tx=welcomeTxt.getText();
		return tx;
	}
	public void selectLocation() {
		loc.click();
			
	}
	public boolean showLocation_Offline() {
		boolean dis = loc.isDisplayed();
		return dis;
				
	}
	public void selectLocation_Offline() {
		loc.click();
			
	}
	public void selectLocation_Online() {
		loc_Online.click();		
	}
	
	public void selectTrainer() {
		trainer.click();

	}
	public void selectTypeOfService() {
		freeService.click();	

	}
	public void selectDayFromWeek() {
		Select s= new Select(day);
		s.selectByVisibleText("Mon");

	}
	public void selectStartDate_Time() {
		Select s= new Select(startDay);
		s.deselectByIndex(2);
	
		Select s1= new Select(startTime);
		s1.selectByValue("7:00");

	}
	public void selectEndDate_Time() {
		Select s= new Select(endDay);
		s.selectByVisibleText("3 April");
		Select s1= new Select(endTime);
		s1.selectByValue("7:00");

	}
	
	public void clickOnLogOut() {
		logOut.click();
	}
	
	

}
