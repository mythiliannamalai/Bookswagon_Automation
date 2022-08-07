package bs_baseclass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public Logger log = Logger.getLogger(BaseClass.class);
	public static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");	 
	ExtentTest test;
	public BaseClass() {
		
		try {
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream(
					"C:\\Users\\user\\eclipse-workspace\\BookSwagon_Automation\\src\\main\\java\\bs_config\\properties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void initialization() {		
		log.info("Brower Name :" + prop.getProperty("brower"));
		String browserName = prop.getProperty("brower");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		log.info("Application URL :" + prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}	
	
}
