package bs_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import bs_baseclass.BaseClass;
import bs_pages.WishList;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import bs_pages.Login_Page;

public class WishListTest extends BaseClass {
	Login_Page loginpage;
	WishList wishlist;

	public WishListTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new Login_Page();
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		wishlist = new WishList();
	}

	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user try to add the book in wishlist")
	@Feature("Feature Authors")
	@Story("The user select one partular author and add one book to the wishlist")
	public void feature_authTest() {
		log.info("Feature Author Method Runing...");
		wishlist.feature_auth();
	}

	@Test(priority = 2)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user try to add the book in wishlist")
	@Feature("Search :1")
	@Story("The user search the book by using book name and add to the wishlist")
	public void search_BookNameTest() {
		log.info("Search by book name Method Runing...");
		wishlist.search_BookName(prop.getProperty("addwishlistByBookname"));
	}

	@Test(priority = 3)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user try to add the book in wishlist")
	@Feature("Search :2")
	@Story("The user search the book by using Author name and add to the wishlist")
	public void addWishlist_AuthorNameTest() {
		log.info("Search by Author name Method Runing...");
		wishlist.addWishlist_AuthorName(prop.getProperty("addwishlistByAuthor"));
	}

	@Test(priority = 4)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user try to add the book in wishlist")
	@Feature("Search :3")
	@Story("The user search the book by using Publisher name and add to the wishlist")
	public void addWishlist_PublisherTest() {
		log.info("Search by Publisher Method Runing...");
		wishlist.addWishlist_Publisher(prop.getProperty("addwishlistByPublisher"));
	}

	@Test(priority = 5)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user check the wishlist")
	@Feature("My Wishlist")
	@Story("The user check the wishlist")
	public void wishlist_Test() {
		log.info("Wishlist Method Runing...");
		wishlist.wish_list();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
