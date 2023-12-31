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
import page.CheckBoxPage;
import page.HomePage;
import page.SideInputPage;

@Listeners(util.ReportUtil.class)
public class CheckBoxTest extends DriveIntiation {
CheckBoxPage checkBox;
	WebDriver driver;
	SideInputPage sideInputPage;
	HomePage homePage;

	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) throws Exception {
		driver=super.driveInitialize(browser);
	}
@Test
public void checkBoxTest() {
	driver.get(INTIAL_URL);
	homePage=PageFactory.initElements(driver, HomePage.class);
	homePage.inputFormclick();
	sideInputPage=PageFactory.initElements(driver, SideInputPage.class);
	sideInputPage.sideCheckBox();
checkBox=PageFactory.initElements(driver, CheckBoxPage.class);
checkBox.singleCheckBox();
checkBox.multiCheckBox();
}
@AfterTest
public void closeTest() {
	driver.close();
}
}
