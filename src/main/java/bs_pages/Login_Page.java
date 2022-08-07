package bs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;

public class Login_Page extends BaseClass {
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement lemail;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement lpass;
	
	@FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement login;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username,String password) {	
		ExtentTest test = extent.createTest("login");
		lemail.sendKeys(username);
		lpass.sendKeys(password);
		login.click();
	}
	
	public void multipleUserLogin(String username,String password) {	
		ExtentTest test = extent.createTest("multipleUserLogin");
		lemail.sendKeys(username);
		lpass.sendKeys(password);
		login.click();
	}
}