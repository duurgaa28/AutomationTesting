package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.HomePage;
import page.RadioButtonPage;
import page.SideInputPage;
import util.ScreenShotClass;


@Listeners(util.ReportUtil.class)
public class RadioButtonTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	SideInputPage sideInputPage;
	RadioButtonPage radiobtn;


	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = super.driveInitialize(browser);
	}
@Test
	public void radioBtnTest() throws Exception {
		driver.get(INTIAL_URL);
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		sideInputPage = PageFactory.initElements(driver, SideInputPage.class);
		sideInputPage.sideRadioButton();
		radiobtn = PageFactory.initElements(driver, RadioButtonPage.class);
		radiobtn.femaleRadioClick();
		radiobtn.selectedValueClick();
		ScreenShotClass.takeScreenshot("RadioButton.png", driver);
	}
	@AfterTest
	public void closeTest() {
		driver.quit();
	}
}
