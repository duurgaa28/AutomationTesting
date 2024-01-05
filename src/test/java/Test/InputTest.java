package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import page.HomePage;
import page.InputPage;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenShotClass;

@Listeners(util.ReportUtil.class)
public class InputTest extends DriveIntiation {
	HomePage homePage;
	InputPage inputPage;
	WebDriver driver;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
		driver.get(INTIAL_URL);;
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void inputTest() throws Exception {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		inputPage=new InputPage(driver);
		inputPage = PageFactory.initElements(driver, InputPage.class);
		inputPage.sideSelectInput();
		inputPage.selectColourDrop("Red");
		inputPage.multiSelectColourDrop("Green");
		ScreenShotClass.takeScreenshot("InputTest.png", driver);
	}

	@AfterTest
	public void closeTest() {
		driver.close();
	}
}
