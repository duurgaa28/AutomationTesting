package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;

@FindBy (xpath="//a[@href='simple-form-demo.php']")
WebElement inputForm;
@FindBy(xpath="//a[@href='date-picker.php']")
WebElement datePickers;
@FindBy (xpath="//a[@href='table-pagination.php']")
WebElement table;
@FindBy(id="progress-bars")
WebElement progressBars;
@FindBy (id="alert-modal")
WebElement alertsAndModal;
@FindBy(id="list0box")
WebElement listBox;
@FindBy(id="others")
WebElement others;
public HomePage(WebDriver driver) {
	this.driver=driver;
}
public void inputFormclick () { 
	inputForm.click();
}
public void datePickersClick() {
	datePickers.click();
}
public void alertsAndModalsClick() {
	alertsAndModal.click();
}
public void tableClick() {
	table.click();
}
public void progressBarsClick() {
	progressBars.click();
}
public void othersClick() {
	others.click();
}
}
