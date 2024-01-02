package Test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.DriveIntiation;
import page.HomePage;
import page.InputPage;
import page.JsAlertPage;
import page.SideAlertsAndModalsPage;
import util.PropertyRead;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

//@Listeners(util.ReportUtil.class)
public class JavascriptPromptVerifyTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;

	InputPage inputPage;
	SideAlertsAndModalsPage alertsAndModalsPage;
	JsAlertPage jsAlertPage;
	ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		// extentTest=ReportUtil.getExtentReports().createTest("jsPromptTest");

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void jsPrompt() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.alertsAndModalsClick();
		alertsAndModalsPage = PageFactory.initElements(driver, SideAlertsAndModalsPage.class);
		alertsAndModalsPage.jsAlert();
		jsAlertPage = PageFactory.initElements(driver, JsAlertPage.class);
		jsAlertPage.jsPromptClick();
		Alert jsalert = driver.switchTo().alert();

		try {
			Assert.assertEquals(jsalert.getText().trim(), "Please enter your name");
			String name = PropertyRead.getProperty("Enter_Your_Name", "Not found");
			jsalert.sendKeys(name);
			jsalert.accept();
			ScreenShotClass.takeScreenshot("JsPrompt.png", driver);
			// extentTest.log(Status.PASS,"Successful");
		} catch (AssertionError assertionError) {
			ScreenShotClass.takeScreenshot("JsPrompt fail.png", driver);
			// extentTest.log(Status.FAIL, "Alert Test failed");
			// extentTest.log(Status.FAIL, "Unhandled alert");
			throw new TestException("Assertion Error");
		}

	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
