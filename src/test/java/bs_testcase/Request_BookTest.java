package bs_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bs_baseclass.BaseClass;
import bs_pages.Login_Page;
import bs_pages.Request_Book;
import bs_utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Request_BookTest extends BaseClass {
	Login_Page loginpage;
	Request_Book requestbook;
	Utility utility;
	public String SheetName = "Sheet4";

	public Request_BookTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new Login_Page();
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		requestbook = new Request_Book();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	@Severity(SeverityLevel.NORMAL)
	@Description("The user Request the book")
	@Feature("Request a book")
	@Story("The user Request the particular book in Request a book Feature")
	public void request_a_bookTest(String isbnid, String bookname) throws InterruptedException {
		log.info("user request the book Method Runing...");
		requestbook.request_a_book(isbnid, bookname);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
