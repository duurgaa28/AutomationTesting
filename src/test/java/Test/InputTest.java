package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.HomePage;
import page.InputPage;

@Listeners(util.ReportUtil.class)
public class InputTest extends DriveIntiation   {
HomePage homePage;
	InputPage inputPage;
	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) throws Exception {
		driver=super.driveInitialize(browser);
	}
	@Test
	public void inputTest () {
		driver.get(INTIAL_URL);
		homePage=PageFactory.initElements(driver, HomePage.class);
		homePage.inputFormclick();
		// inputPage=new InputPage(driver);
		inputPage = PageFactory.initElements(driver, InputPage.class);
		inputPage.sideSelectInput();
		inputPage.selectColourDrop("Red");
		inputPage.multiSelectColourDrop("Green");
	}
	@AfterTest
	public void closeTest() {
		driver.close();
	}
}
