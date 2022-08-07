package bs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;

public class Change_Password extends BaseClass{

	@FindBy(linkText="Change Password")
	WebElement change_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtCurPwd']")
	WebElement curr_pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtNewPassword']")
	WebElement new_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtConfirmPwd']")
	WebElement curr_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_imgSubmit']")
	WebElement chan_Pass_btn;
	
	public Change_Password() {
		PageFactory.initElements(driver,this);
	}
	
	public void change_password(String currentPassword,String newPassword,String confirmPassword) {			
		change_Pass.click();
		curr_pass.sendKeys(currentPassword);
		new_Pass.sendKeys(newPassword);
		curr_Pass.sendKeys(confirmPassword);
		chan_Pass_btn.click();
	}
	
}