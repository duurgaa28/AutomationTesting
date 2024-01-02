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
import page.InputPage;
import page.SideInputPage;
import page.SimpleFormPage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

@Listeners(util.ReportUtil.class)
public class SimpleFormTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	DriveIntiation driveintiation;
	SideInputPage simpleForm;
	SimpleFormPage singleInput;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		extentTest =ReportUtil.getExtentReports().createTest("simpleFormTest");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void simpleFormTest() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		simpleForm = PageFactory.initElements(driver, SideInputPage.class);
		simpleForm.sideSimpleForm();
		singleInput = PageFactory.initElements(driver, SimpleFormPage.class);
		singleInput.enterMessage("Show Message!");
		singleInput.showButtonClick();
		Assert.assertEquals(singleInput.getMessage(), "Your Message : Show Message!");
		try {
			 extentTest.log(Status.PASS,"Successful");
		} catch (AssertionError assertionError) {
			 extentTest.log(Status.FAIL, "Test failed");
			extentTest.log(Status.FAIL, "Expected : Your Message : Show Message!, Actual: "+singleInput.getMessage() );
			throw new TestException("Assertion Error");
		}
		ScreenShotClass.takeScreenshot("SimpleInput1.png", driver);

	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
