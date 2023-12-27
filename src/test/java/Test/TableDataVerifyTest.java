package Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import page.HomePage;
import page.TablePage;
import util.ExcelReadUtil;

public class TableDataVerifyTest extends DriveIntiation {
WebDriver driver;
HomePage homePage;
TablePage tablePage;
@BeforeTest
@Parameters({"browser"})
public void setUp(@Optional("chrome") String browser)throws Exception {
		driver=super.driveInitialize(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

@Test(dataProvider = "employeeDetails")
public void tableVerify(String name,String position,String office,String age,String startDate,String salary) {
	driver.get(INTIAL_URL);
	 homePage=PageFactory.initElements(driver, HomePage.class);
	 homePage.tableClick();
	 tablePage=PageFactory.initElements(driver, TablePage.class);
	 tablePage.tableCheck("Ashton Cox");
	 
	 Assert.assertEquals(name, "Ashton Cox");
     Assert.assertEquals(position, "Junior Technical Author");
     Assert.assertEquals(office, "San Francisco");
     Assert.assertEquals(age, 66);
     Assert.assertEquals(startDate, "2009/01/12");
     Assert.assertEquals(salary, "$86,000");
	 
}
@DataProvider(name = "employeeDetails")
public Object[][] getEmployeeDetails() throws IOException {
	List<String[]> infoList= new ArrayList<>();
	ExcelReadUtil excelRead=new ExcelReadUtil();
	for (int i=1;i<3;i++) {
		String name=excelRead.readExcelData(i, 0);
		String position=excelRead.readExcelData(i, 1);
		String office=excelRead.readExcelData(i, 2);
		String age=excelRead.readExcelData(i, 3);
		String startDate=excelRead.readExcelData(i, 4);
		String salary=excelRead.readExcelData(i, 5);
		infoList.add(new String[] {name,position,office,age,startDate,salary});
	}
	return infoList.toArray(new String [infoList.size()][]);
}
@AfterTest
public void closeTest() {
	driver.quit();
}
}
