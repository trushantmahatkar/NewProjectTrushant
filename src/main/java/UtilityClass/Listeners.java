package UtilityClass;


	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	public class Listeners implements ITestListener {
		ExtentReports extent =ExtentReportGenerator.getreport();
		ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
		
		public void onTestStart(ITestResult result) {
			Library.Test =extent.createTest( result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
			extentTest.set(Library.Test );	
		}
		public void onTestSuccess(ITestResult result) {
			Library.Test.log(Status.PASS, "Test case pass");
		}
		public void onTestFailure(ITestResult result) {
			Library.Test.log(Status.FAIL, "Test case fail");
		}
		public void onTestSkipped(ITestResult result) {
			Library.Test.log(Status.SKIP, "Test case skip");
		}
		public void onFinish(ITestContext context) {
			extent.flush();
		}
		
	}

