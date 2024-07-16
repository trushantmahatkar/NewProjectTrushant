package UtilityClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator 
{
	
		public static ExtentReports extent;
		public static ExtentReports  getreport() 
		{
			
			String path="D:\\Users\\trushantmahatkar\\eclipse-workspace\\WL_2.0\\report\\index.html";
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setDocumentTitle("Automation Report");
			reporter.config().setReportName("test report");
			reporter.config().setTheme(Theme.STANDARD);
			
			extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("System","Test");
			extent.setSystemInfo("QA","Trushant Mahatkar");
			
			return extent;
		}
}
