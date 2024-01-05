package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
import page.JQueryPage;
import util.ReportUtil;
import util.RetryAnalyzer;


@Listeners(util.ReportUtil.class)

public class JQueryTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	JQueryPage jQueryPage;
	ExtentReports extentReports;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void jQueryTest() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.progressBarsClick();
		jQueryPage = PageFactory.initElements(driver, JQueryPage.class);
		jQueryPage.downloadBtnClick();
		jQueryPage.closeBtnClick();
	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
