package bs_testcase;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import bs_baseclass.BaseClass;
import bs_pages.Add_Address_Page;
import bs_pages.Login_Page;
import bs_utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Add_Address_Test extends BaseClass {

	Login_Page loginpage;
	Add_Address_Page add_address;
	Utility utility;
	public String SheetName = "Sheet2";

	public Add_Address_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new Login_Page();
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		add_address = new Add_Address_Page();

	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Add the new address")
	@Feature("My Address")
	@Story("The user add the new address in My Address Feature")
	public void add_Address_Test(String RecipientName, String StreetAddress, String Country, String State, String City)
			throws AWTException {
		log.info("Add new address Method Runing...");
		add_address.add_Address(RecipientName, StreetAddress, Country, State, City);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
