package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablePage {
WebDriver driver;
@FindBy(xpath="//table[@id='dtBasicExample']/tbody/descendant::tr/child::td[1]")
List<WebElement> tables;
public TablePage(WebDriver driver) {
	this.driver=driver;
}
public void tableCheck(String expectedName) {
	for (WebElement eachRow:tables) {
		if(eachRow.getText().equals(expectedName)) {
			System.out.println(eachRow.getText());
		}
		else {
			System.out.println("Not Found");
		}
		break;
	}

}
}
