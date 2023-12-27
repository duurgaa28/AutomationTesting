package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.FormSubmitPage;
import page.HomePage;
import page.SideInputPage;
import util.PropertyRead;
import util.ScreenShotClass;

public class FormSubmitTest extends DriveIntiation {
WebDriver driver;
HomePage homepage;
SideInputPage sideInputPage;
FormSubmitPage formSubmitPage;

@BeforeTest
@Parameters({"browser"})
public void setUp(@Optional("chrome") String browser)throws Exception {
		driver=super.driveInitialize(browser);
	}
@Test
public void formSubmitTest() throws Exception {
	 driver.get(INTIAL_URL);
	 homepage=PageFactory.initElements(driver, HomePage.class);
	 homepage.inputFormclick();
	 sideInputPage=PageFactory.initElements(driver, SideInputPage.class);
	 sideInputPage.sideFormSubmit();
	 formSubmitPage = PageFactory.initElements(driver, FormSubmitPage.class);
	 String firstNameText=PropertyRead.getProperty("First_Name", "Not found");
	 formSubmitPage.inputFirstName(firstNameText);
	 String lastNameText=PropertyRead.getProperty("Last_Name", "Not found");
	 formSubmitPage.inputLastName(lastNameText);
	 String userNameText=PropertyRead.getProperty("User_Name", "Not found");
	 formSubmitPage.inputUserName(userNameText);
	 String cityNameText=PropertyRead.getProperty("City_Name", "Not found");
	 formSubmitPage.inputCity(cityNameText);
	 String stateNameText=PropertyRead.getProperty("State_Name", "Not found");
	 formSubmitPage.inputState(stateNameText);
	 String zipCodeText=PropertyRead.getProperty("Zip_Code", "Not found");
	 formSubmitPage.inputZip(zipCodeText);
	 formSubmitPage.checkBox(false);
	 formSubmitPage.submitFormClick();
	 Assert.assertEquals(formSubmitPage.getDisplayedMsg(), "Form has been submitted successfully!");
	 ScreenShotClass.takeScreenshot("FormSubmit.png", driver);
}
@AfterTest
public void closeTest() {
	driver.quit();
}
}