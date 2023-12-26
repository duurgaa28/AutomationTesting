package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideAlertsAndModalsPage {
WebDriver driver;

@FindBy (xpath="//a[text()='Bootstrap Alert']")
WebElement bootstrapAlert;
@FindBy(xpath="//a[text()='Bootstrap Modal']")
WebElement bootstrapModal;
@FindBy(xpath="//a[text()='Window Popup']")
WebElement windowPopup;
@FindBy(xpath="//a[text()='Progress Bar Modal']")
WebElement progressBarModal;
@FindBy(xpath="//a[text()='Javascript Alert']")
WebElement javascriptAlert;
@FindBy(xpath="//a[text()='File Download']")
WebElement fileDownload;

public SideAlertsAndModalsPage(WebDriver driver) {
	this.driver=driver;
}
public void popupClick() {
	windowPopup.click();
}
public void jsAlert() {
	javascriptAlert.click();
}
}
