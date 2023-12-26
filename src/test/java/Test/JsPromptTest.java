package Test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.HomePage;
import page.InputPage;
import page.JsAlertPage;
import page.SideAlertsAndModalsPage;
import util.PropertyRead;
import util.ScreenShotClass;

public class JsPromptTest extends DriveIntiation {
WebDriver driver;
HomePage homePage;
InputPage inputPage;
SideAlertsAndModalsPage alertsAndModalsPage;
JsAlertPage jsAlertPage;

@BeforeTest
@Parameters({"browser"})
public void setUp(String browser)throws Exception {
	driver=super.driveInitialize(browser);
	
}

@Test
public void jsPrompt() throws Exception {
	driver.get(INTIAL_URL);
	homePage=PageFactory.initElements(driver, HomePage.class);
	homePage.alertsAndModalsClick();
	alertsAndModalsPage=PageFactory.initElements(driver, SideAlertsAndModalsPage.class);
	alertsAndModalsPage.jsAlert();
	jsAlertPage=PageFactory.initElements(driver, JsAlertPage.class);
	jsAlertPage.jsPromptClick();
	try {
	Alert jsalert = driver.switchTo().alert();
	Assert.assertEquals(jsalert.getText().trim(),"Please enter your name");
	String name=PropertyRead.getProperty("Enter Your Name","Not found");
	jsalert.sendKeys(name);
	//Assert.assertEquals(jsAlertPage.getTheEntered().trim(),"You have entered"+name);
	ScreenShotClass.takeScreenshot("JsPrompt.png", driver);
	}
	catch(NoAlertPresentException e) {
	}
	}
@AfterTest
public void closeTest() {
	driver.quit();
}
}
