package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
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
import util.ScreenShotClass;
//@Listeners(util.ReportUtil.class)
public class SimpleFormTest extends DriveIntiation {
	WebDriver driver;
	HomePage homePage;
	DriveIntiation driveintiation;
	SideInputPage simpleForm;
	SimpleFormPage singleInput;


@BeforeTest
@Parameters({"browser"})
public void setUp(String browser) throws Exception {
	driver=super.driveInitialize(browser);
}
@Test 
public void simpleFormTest() throws Exception {
	driver.get(INTIAL_URL);
	homePage=PageFactory.initElements(driver, HomePage.class);
	homePage.inputFormclick();
	simpleForm=PageFactory.initElements(driver, SideInputPage.class);
	simpleForm.sideSimpleForm();
	singleInput=PageFactory.initElements(driver, SimpleFormPage.class);
	singleInput.enterMessage("Show Message!");
	singleInput.showButtonClick();
 Assert.assertEquals(singleInput.getMessage(),"Your Message : Show Message!");
 ScreenShotClass.takeScreenshot("SimpleInput1.png", driver);
ExtentReports extentReports = ReportUtil.generateReports();
ExtentTest extenTest =extentReports .createTest("simpleFormTest");
extenTest.log(Status.INFO,"entering test");
extenTest.log(Status.PASS,"test passed");
extentReports.flush();

}
@AfterTest
public void closeTest() {
	driver.quit();
}
}
