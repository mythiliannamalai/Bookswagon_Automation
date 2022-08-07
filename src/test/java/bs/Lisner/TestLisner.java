package bs.Lisner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import bs_baseclass.BaseClass;
import bs_utility.Utility;
public class TestLisner extends BaseClass implements ITestListener {
	
	Utility urility;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestStart");	
		extent.attachReporter(spark);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Mythili").assignDevice("Chrome");
		test.pass("Test successfully executed");
		extent.flush();
		}

	@Override
	public void onTestFailure(ITestResult result){
		System.out.println(result.getMethod().getMethodName()+" :onTestFailure");  
		ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Mythili").assignDevice("Chrome");
		test.fail("Test method failed");
		String fTname=result.getMethod().getMethodName();
		urility = new Utility();		
			try {
				urility.failedTest(fTname);
			} catch (IOException e) {				
				e.printStackTrace();
			}	
			test.addScreenCaptureFromPath("C:\\Users\\user\\eclipse-workspace\\BookSwagon_Automation\\BS_ScreenShots\\"+result.getMethod().getMethodName()+".png");
			extent.flush();			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSkipped");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.skip("Test method failed");
		extent.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context);
	}

}
