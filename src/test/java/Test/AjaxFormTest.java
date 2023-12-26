package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.AjaxFormPage;
import page.HomePage;
import page.SideInputPage;
import util.PropertyRead;
import util.ScreenShotClass;

public class AjaxFormTest  extends DriveIntiation{
 WebDriver driver;
 HomePage homePage;
 SideInputPage sideInputPage;
 AjaxFormPage ajaxFormPage;
 
 @BeforeTest
 @Parameters({"browser"})
 public void setUp(String browser)throws Exception {
		driver=super.driveInitialize(browser);
	}
 
 @Test
 public void ajaxFormTest() throws Exception {
	 driver.get(INTIAL_URL);
	 homePage=PageFactory.initElements(driver, HomePage.class);
	 homePage.inputFormclick();
	 sideInputPage=PageFactory.initElements(driver, SideInputPage.class);
	 sideInputPage.sideAjaxForm();
	 ajaxFormPage=PageFactory.initElements(driver, AjaxFormPage.class);
	 String subjectTexts=PropertyRead.getProperty("EnterSubject", "Not found");
	 ajaxFormPage.subjectInput(subjectTexts);
	 String descriptionTexts=PropertyRead.getProperty("EnterDescription", "Not found");
	 ajaxFormPage.descriptionInput(descriptionTexts);
	 ajaxFormPage.submitClick();
	 Assert.assertEquals(ajaxFormPage.theMessage(), "Form has been submitted successfully!");
	 ScreenShotClass.takeScreenshot("AjaxForm.png", driver);
 }
 @AfterTest
 public void closeTest() {
 	driver.quit();
 }
}
