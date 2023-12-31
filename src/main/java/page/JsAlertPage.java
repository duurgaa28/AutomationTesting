package page;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.PropertyRead;
import util.ScreenShotClass;

public class JsAlertPage {
WebDriver driver;

@FindBy (xpath="//button[@class='btn btn-success']")
WebElement jsAlertBox;
@FindBy(xpath="//button[@class='btn btn-warning']")
WebElement jsConfirmBox;
@FindBy(xpath="//button[@class='btn btn-danger']")
WebElement jsPromptBox;
@FindBy (xpath="//p[@id='prompt-demo']")
WebElement youEntered;

public JsAlertPage(WebDriver driver) {
	this.driver=driver;
}
public void jsAlertClick() {
	jsAlertBox.click();
}
public void jsConfirmClick() {
	jsConfirmBox.click();
}
public void jsPromptClick() {
	jsPromptBox.click();
	
}
public void alertSet(String propertyName) throws Exception {
		Alert jsalert = driver.switchTo().alert();
		Assert.assertEquals(jsalert.getText().trim(),"Please enter your name");
		String name=PropertyRead.getProperty(propertyName,"Not found");
		jsalert.sendKeys(name);
		jsalert.accept();
}
public String getTheEntered() {
	return youEntered.getText();
}
}
