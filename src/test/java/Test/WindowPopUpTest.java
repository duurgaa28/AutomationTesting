package Test;

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
import page.SideAlertsAndModalsPage;
import page.WindowPopUpPage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

//@Listeners(util.ReportUtil.class)
public class WindowPopUpTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	SideAlertsAndModalsPage alertsAndModalsPage;
	WindowPopUpPage windowPopUpPage;
	ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		// extentTest = ReportUtil.getExtentReports().createTest("Table data verify
		// test");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void windowPopUp() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.alertsAndModalsClick();
		alertsAndModalsPage = PageFactory.initElements(driver, SideAlertsAndModalsPage.class);
		alertsAndModalsPage.popupClick();
		windowPopUpPage = PageFactory.initElements(driver, WindowPopUpPage.class);
		windowPopUpPage.facebookBtnClick();
		windowPopUpPage.getTitles();
		try {
			Assert.assertEquals(windowPopUpPage.getTitles(), "Connect with Obsqura Zone on Facebook");
			ScreenShotClass.takeScreenshot("windowpopup.png", driver);
			// extentTest.log(Status.PASS, "Successful");
		} catch (AssertionError assertionError) {
			// extentTest.log(Status.FAIL, "Test failed");
			throw new TestException("Assertion Error");
		}
	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
