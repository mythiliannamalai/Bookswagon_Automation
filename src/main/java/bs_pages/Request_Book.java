package bs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;

public class Request_Book extends BaseClass{

	@FindBy(xpath = "//a[text()='Request a Book']")
	WebElement req_book;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement isbnId;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement book_title;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement submit;
	
	public Request_Book() {
		PageFactory.initElements(driver, this);
	}
	
	public void request_a_book(String isbnid,String bookName) throws InterruptedException {		
		req_book.click();
		isbnId.sendKeys(isbnid);
		book_title.sendKeys(bookName);
		Thread.sleep(2000);
		submit.click();
	}
	
	
}
