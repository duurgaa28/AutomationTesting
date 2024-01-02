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
import page.RadioButtonPage;
import page.SideInputPage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

@Listeners(util.ReportUtil.class)
public class RadioButtonTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	SideInputPage sideInputPage;
	RadioButtonPage radiobtn;
	ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		extentTest = ReportUtil.getExtentReports().createTest("radio button Test ");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void radioBtnTest() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		sideInputPage = PageFactory.initElements(driver, SideInputPage.class);
		sideInputPage.sideRadioButton();
		radiobtn = PageFactory.initElements(driver, RadioButtonPage.class);
		radiobtn.femaleRadioClick();
		radiobtn.selectedValueClick();
		ScreenShotClass.takeScreenshot("RadioButton.png", driver);
		 extentTest.log(Status.PASS,"Successful");
	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
