package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.DriveIntiation;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.CheckBoxPage;
import page.HomePage;
import page.SideInputPage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

@Listeners(util.ReportUtil.class)
public class CheckBoxTest extends DriveIntiation {
	CheckBoxPage checkBox;
	WebDriver driver;
	SideInputPage sideInputPage;
	HomePage homePage;
	ExtentReports extentReports;
	private ExtentTest extentTest;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		extentTest = ReportUtil.getExtentReports().createTest("form submit Test");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void checkBoxTest() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		sideInputPage = PageFactory.initElements(driver, SideInputPage.class);
		sideInputPage.sideCheckBox();
		checkBox = PageFactory.initElements(driver, CheckBoxPage.class);
		checkBox.singleCheckBox();
		checkBox.multiCheckBox();
		ScreenShotClass.takeScreenshot("CheckBox.png", driver);
		extentTest.log(Status.PASS, "Successful");
	}

	@AfterTest
	public void closeTest() {
		driver.close();
	}
}
