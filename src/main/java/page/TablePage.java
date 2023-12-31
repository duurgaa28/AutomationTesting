package page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import util.ExcelReadUtil;

public class TablePage {
	WebDriver driver;
	@FindBy(xpath = "//table[@id='dtBasicExample']/tbody/descendant::tr/child::td[1]")
	List<WebElement> tables;
	WebElement position;
	WebElement office;
	WebElement age;
	WebElement startDate;
	WebElement salary;

	public TablePage(WebDriver driver) {
		this.driver = driver;
	}

	public void tableCheck(String expectedName) {
		// int count = tables.size();
		int currentRow = 1;
		for (WebElement eachRow : tables) {
			if (eachRow.getText().trim().equals(expectedName)) {
				WebElement position = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[2]"));
				
				WebElement office = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[3]"));
			;
				WebElement age = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[4]"));
			
				WebElement startDate = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[5]"));
				
				WebElement salary = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[6]"));
			
				
				break;
			}

		}
		
		}
	 public String getPosition() {
			return position.getText().trim();

	}
	 public String getOffice() {
		 return office.getText().trim();
	 }
	 public String getAge() {
		 return age.getText().trim();
	 }
	 public String getStartDate() {
		 return startDate.getText().trim();
	 }
public String getSalary() {
	return salary.getText().trim();
}
}
