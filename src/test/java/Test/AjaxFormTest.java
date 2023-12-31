package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import page.AjaxFormPage;
import page.HomePage;
import page.SideInputPage;
import util.PropertyRead;
import util.ReportUtil;
import util.ScreenShotClass;

@Listeners(util.ReportUtil.class)
public class AjaxFormTest  extends DriveIntiation{
 WebDriver driver;
 HomePage homePage;
 SideInputPage sideInputPage;
 AjaxFormPage ajaxFormPage;
 ExtentReports extentReports;
 private ExtentTest extentTest;
 
 @BeforeTest
 @Parameters({"browser"})
 public void setUp(@Optional("chrome") String browser)throws Exception {
		driver=super.driveInitialize(browser);
		driver.get(INTIAL_URL);
		 extentTest=ReportUtil.getExtentReports().createTest("Ajax Form Test");
	}
 
 @Test
 public void ajaxFormTest() throws Exception {
	 homePage=PageFactory.initElements(driver, HomePage.class);
	 homePage.inputFormclick();
	 sideInputPage=PageFactory.initElements(driver, SideInputPage.class);
	 sideInputPage.sideAjaxForm();
	 ajaxFormPage=PageFactory.initElements(driver, AjaxFormPage.class);
	 String subjectTexts=PropertyRead.getProperty("Enter_Subject", "Not found");
	 ajaxFormPage.subjectInput(subjectTexts);
	 String descriptionTexts=PropertyRead.getProperty("Enter_Description", "Not found");
	 ajaxFormPage.descriptionInput(descriptionTexts);
	 ajaxFormPage.submitClick();
	 try {
		 Assert.assertEquals(ajaxFormPage.theMessage(), "Form has been submitted successfully!");
		 extentTest.log(Status.PASS,"Successful");
	 }
	 catch(AssertionError assertionError){
		 extentTest.log(Status.FAIL, "Expected:Form has been submitted successfully!, Actual : "+ajaxFormPage.theMessage() );
		 throw new TestException ("Assertion Error");
	 }
	 ScreenShotClass.takeScreenshot("AjaxForm1.png", driver);
	 
 }
 @AfterTest
 public void closeTest() {
 	driver.quit();
 }
}
