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
import page.DragAndDropPage;
import page.HomePage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

//@Listeners(util.ReportUtil.class)
public class DragAndDropTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	DragAndDropPage dragAndDrop;
	ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		// extentTest=ReportUtil.getExtentReports().createTest("drag and drop test");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void dragAndDropTest() throws Exception {

		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.othersClick();
		dragAndDrop = PageFactory.initElements(driver, DragAndDropPage.class);
		dragAndDrop.dragAndDropThree();
		ScreenShotClass.takeScreenshot("Drag and Drop.png", driver);
		// extentTest.log(Status.PASS,"Successful");
	}

	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
