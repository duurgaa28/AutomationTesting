package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.HomePage;
import page.TablePage;

public class TableTest extends DriveIntiation {
WebDriver driver;
HomePage homePage;
TablePage tablePage;
@BeforeTest
@Parameters({"browser"})
public void setUp(@Optional("chrome") String browser)throws Exception {
		driver=super.driveInitialize(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

@Test
public void tableVerify() {
	driver.get(INTIAL_URL);
	 homePage=PageFactory.initElements(driver, HomePage.class);
	 homePage.tableClick();
	 tablePage=PageFactory.initElements(driver, TablePage.class);
	 tablePage.tableCheck("Ashton Cox");
	 
}
@AfterTest
public void closeTest() {
	driver.quit();
}
}
