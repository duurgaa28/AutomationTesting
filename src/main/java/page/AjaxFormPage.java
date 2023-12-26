package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxFormPage {
WebDriver driver;
@FindBy(xpath="//input[@id='subject']")
WebElement subject;
@FindBy(xpath="//textarea[@id='description']")
WebElement description;
@FindBy(xpath="//input[@class='btn btn-primary']")
WebElement submitBtn;
@FindBy(xpath="//div[@id='message-one']")
WebElement message;

public AjaxFormPage (WebDriver driver) {
this.driver=driver;	
}
public void subjectInput(String subText) {
	subject.sendKeys(subText);
}
public void descriptionInput(String desscrptionText) {
	description.sendKeys(desscrptionText);
}
public void submitClick() {
	submitBtn.click();
}
public String theMessage() {
	WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(15));
	 webDriverWait.until(ExpectedConditions.textToBePresentInElement(message,"Form has been submitted successfully!"));
	 return message.getText();
}
}
