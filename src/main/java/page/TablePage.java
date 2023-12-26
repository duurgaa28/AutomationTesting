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

	public TablePage(WebDriver driver) {
		this.driver = driver;
	}

	public void tableCheck(String expectedName) {
		// int count = tables.size();
		int currentRow = 1;
		for (WebElement eachRow : tables) {
			if (eachRow.getText().equals(expectedName)) {
				WebElement position = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[2]"));
				position.getText();
				WebElement office = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[3]"));
				office.getText();
				WebElement age = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[4]"));
				age.getText();
				WebElement startDate = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[5]"));
				startDate.getText();
				WebElement salary = driver.findElement(By
						.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr[" + currentRow + "]/child::td[6]"));
				salary.getText();
				
				break;
			}

		}

	}
	
}
	
