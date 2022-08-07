package bs_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import bs_baseclass.BaseClass;
import bs_pages.Login_Page;
import bs_utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Login_PageTest extends BaseClass {
	Login_Page loginpage;
	Utility utility;
	public String SheetName = "Sheet3";

	public Login_PageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new Login_Page();
	}

	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("User login the application")
	@Feature("Login : 1")
	@Story("The user enter the valid username and password then login the application")
	public void loginTest() {
		log.info("LoginTest Method Runing...");
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData", priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Multiple user try to login the application")
	@Feature("Login : 2")
	@Story("The user enter the valid username and password then login the application")
	public void MultipleUserLoginTest(String username, String password) {
		log.info("Multiple user login Method Runing...");
		loginpage.multipleUserLogin(username, password);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
