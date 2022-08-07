package bs_pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;

public class Add_Address_Page extends BaseClass {

	@FindBy(linkText = "My Addresses")
	WebElement my_address;

	@FindBy(xpath = "//input[@value='Add a New Address']")
	WebElement add_New_address;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtRecipientName']")
	WebElement res_name;

	@FindBy(xpath = "//textarea[@id='ctl00_phBody_ShippingAddress_txtAddress']")
	WebElement st_address;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCountry']")
	WebElement country;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlState']")
	WebElement state;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCities']")
	WebElement city;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtPincode']")
	WebElement pin_code;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtMobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_imgSubmit']")
	WebElement save;

	public Add_Address_Page() {
		PageFactory.initElements(driver, this);
	}

	public void add_Address(String RecipientName, String StreetAddress, String Country, String State, String City)
			throws AWTException {		
		my_address.click();
		add_New_address.click();
		res_name.sendKeys(RecipientName);
		st_address.sendKeys(StreetAddress);
		Select cun = new Select(country);
		cun.selectByVisibleText(Country);
		Robot robot = new Robot();
		robot.mouseWheel(1);
		Select sta = new Select(state);
		sta.selectByVisibleText(State);
		Select cty = new Select(city);
		cty.selectByVisibleText(City);
		pin_code.sendKeys(prop.getProperty("Pincode"));
		mobile.sendKeys(prop.getProperty("Mobile"));
		save.click();
	}
}