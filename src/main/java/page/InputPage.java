package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InputPage {
WebDriver driver;
//By sideSelectInput=	By.xpath("//a[text()='Select Input']");
@FindBy(xpath="//a[text()='Select Input']")
WebElement sideSelectInput;
//By selectColour= By.xpath("//select[@id='single-input-field']");
@FindBy(xpath="//select[@id='single-input-field']")
WebElement selectColour;
@FindBy(id="multi-select-field")
WebElement multiSelectColour;

public InputPage(WebDriver driver) {
	this.driver=driver;	
}
public void sideSelectInput() {
	sideSelectInput.click();
}
public void selectColourDrop (String colour) {
	Select sC = new Select (selectColour);
	sC.selectByVisibleText(colour);
}
public void multiSelectColourDrop(String value) {
	Select mS= new Select(multiSelectColour);
	mS.selectByValue(value);
}
}
