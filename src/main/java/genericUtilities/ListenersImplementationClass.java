package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation to ITestListener interface of testNG
 * @author loges
 *
 */
public class ListenersImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== test script execution started ====");
		
		//create a test script - recognize each @Test
		test = report.createTest(testScriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== passed ====");
		
		//log the success
		test.log(Status.PASS, testScriptName+"=== PASS ===");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== failed ====");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		//log the failure
		test.log(Status.FAIL, testScriptName+"=== FAIL ====");
		test.log(Status.INFO, result.getThrowable());
		
		//screenshot
		String screenshot = testScriptName + new JavaUtility().getSystemDate();
		
		WebDriverUtility w =new WebDriverUtility();
		try {
			String path = w.captureScreenshot(BaseClass.sdriver, screenshot);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== skipped ====");
	
		//log for skip
		test.log(Status.SKIP, testScriptName+"=== SKIP ===");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("==== suite execution  started ====");
		
		//Basic Report configuration //Report-17-10-2023-20-04-20.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.STANDARD);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger Execution Report");
		
		 report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Loges");
		
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("==== suite execution finished ====");
		
		//Report genertion
		report.flush();
		
		
	}
	
	
	
	

}
