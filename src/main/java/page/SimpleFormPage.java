package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormPage {
WebDriver driver;
@FindBy (xpath="//input[@id='single-input-field']")
WebElement singleInputField;
@FindBy (xpath="//input[@id='single-input-field']/following::button")
WebElement showMessageButton;
@FindBy(xpath="//div[@id='message-one']")
WebElement yourMessage;
public SimpleFormPage (WebDriver driver) {
	this.driver=driver;
}
public void enterMessage (String message) {
	singleInputField.sendKeys(message);
}
public void showButtonClick() {
	showMessageButton.click();
}
public String getMessage() {
	return yourMessage.getText();
}


}
