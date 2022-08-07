package bs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;

public class WishList extends BaseClass {

	@FindBy(xpath = "//li[@id='ctl00_liRequestBook']//a[normalize-space()='Featured Authors']")
	WebElement fea_Auth;

	@FindBy(xpath = "//a[normalize-space()='Arundhati Roy']")
	WebElement auth_name;

	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]")
	WebElement add_wish;

	@FindBy(xpath = "//a[text()='My Wishlist']")
	WebElement wish_List;

	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
	WebElement search_bar;
	
	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	WebElement search_icon;

	public WishList() {
		PageFactory.initElements(driver, this);
	}

	public void feature_auth() {			
		fea_Auth.click();
		auth_name.click();
		add_wish.click();
	}

	public void search_BookName(String book) {		
		search_bar.sendKeys(book);
		search_icon.click();
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[10]/div[1]/div[2]/div[2]/div[1]/div[4]/div[5]/input[1]"))
				.click();
	}

	public void addWishlist_AuthorName(String author) {				
		search_bar.sendKeys(author);
		search_icon.click();
		driver.findElement(By.xpath(
				"//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[2]/div[4]/div[5]/input[1]"))
				.click();
	}

	public void addWishlist_Publisher(String publisher) {				
		search_bar.sendKeys(publisher);
		search_icon.click();
		driver.findElement(By.xpath(
				"//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[@class='search-results fltrs']/div[@class='right-column']/div[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]"))
				.click();
	}

	public void wish_list() {			
		wish_List.click();
	}
}
