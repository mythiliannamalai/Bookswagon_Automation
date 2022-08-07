package bs_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.MediaEntityBuilder;

import bs_baseclass.BaseClass;

public class Utility extends BaseClass {

	public void failedTest(String FTname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File SFile = ts.getScreenshotAs(OutputType.FILE);
		File DFile = new File(".\\BS_ScreenShots\\" + FTname + ".png");
		FileHandler.copy(SFile, DFile);		
	}

	public static String TestDataPath = "C:\\Users\\user\\eclipse-workspace\\BookSwagon_Automation\\src\\main\\java\\bs_testdata\\testdata.xlsx";

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][] getTestData(String SheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}