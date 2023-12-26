package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.HomePage;
import page.SideAlertsAndModalsPage;
import page.WindowPopUpPage;
import util.ScreenShotClass;

public class WindowPopUpTest extends DriveIntiation {
WebDriver driver;
HomePage homePage;
SideAlertsAndModalsPage alertsAndModalsPage;
WindowPopUpPage windowPopUpPage;

@BeforeTest 
@Parameters({"browser"})
public void setUp(String browser) throws Exception {
	driver=super.driveInitialize(browser);
}
@Test
public void windowPopUp () throws Exception  {
	driver.get(INTIAL_URL);
	homePage=PageFactory.initElements(driver, HomePage.class);
	homePage.alertsAndModalsClick();
	alertsAndModalsPage=PageFactory.initElements(driver, SideAlertsAndModalsPage.class);
	alertsAndModalsPage.popupClick();
	windowPopUpPage=PageFactory.initElements(driver, WindowPopUpPage.class);
	windowPopUpPage.facebookBtnClick();
	windowPopUpPage.getTitles();
	 Assert.assertEquals(windowPopUpPage.getTitles(),"Connect with Obsqura Zone on Facebook");
	 ScreenShotClass.takeScreenshot("windowpopup.png", driver);
}
@AfterTest
public void closeTest() {
	driver.quit();
}
}
