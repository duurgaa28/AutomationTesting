package util;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {//implements ITestListener{
	 static  ExtentReports extentReports;
	
	public static ExtentReports generateReports(){
			String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReportone.html";
		    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
		    htmlReporter.config().setDocumentTitle("Automation Reports");
		    htmlReporter.config().setReportName("Test Automation Results");
		    htmlReporter.config().setTheme(Theme.STANDARD);
		    extentReports = new ExtentReports();
		    extentReports.attachReporter(htmlReporter);
			return extentReports;
		
		}
	//public void onStart(ITestContext context) {
		//System.out.println("Extent Report- Test suite started"+context.getName());
	//}extentReports.flush();
	//public void onFinish(ITestContext context) {
		//System.out.println("Extent Report- Test suite finished"+context.getName());
	//extentReports.flush();
	}
	



