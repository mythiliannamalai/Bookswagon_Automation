package bs_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import bs_baseclass.BaseClass;
import bs_pages.Change_Password;
import bs_pages.Login_Page;

import bs_utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Change_PasswordTest extends BaseClass {

	Login_Page loginpage;
	Utility utility;
	Change_Password changePassword;
	public String SheetName = "Sheet5";

	public Change_PasswordTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new Login_Page();
		loginpage.login(prop.getProperty("username"), prop.getProperty("pass"));
		changePassword = new Change_Password();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	@Severity(SeverityLevel.NORMAL)
	@Description("The user try to change the password")
	@Feature("Change password")
	@Story("The user try to change the password")
	public void request_a_bookTest(String currentPassword, String newPassword, String confirmPassword)
			throws InterruptedException {
		log.info("user change the password Method Runing...");
		changePassword.change_password(currentPassword, newPassword, confirmPassword);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
