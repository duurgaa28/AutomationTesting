package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage {
WebDriver driver;
@FindBy (id="gridCheck")
WebElement singleCheckBox;
@FindBy (xpath="//input[@id='is_checked']/following::div[@class='form-check']/input")
List<WebElement> multiCheckBox;

public CheckBoxPage(WebDriver driver) {
	this.driver=driver;
}
public void singleCheckBox () {
	singleCheckBox.click();
}
public void multiCheckBox() {
	for(WebElement multiCB:multiCheckBox) {
		multiCB.click();
	}
}
}
