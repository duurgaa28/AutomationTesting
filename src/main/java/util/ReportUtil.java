package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil implements ITestListener {
    private static ExtentReports extentReports;
    private ExtentTest extentTest;

    static {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReportone.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Test Automation Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();  
        extentReports.attachReporter(htmlReporter);
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
        extentTest = extentReports.createTest(result.getTestName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test failed");
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }
}