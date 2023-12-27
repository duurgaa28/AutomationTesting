package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage {
WebDriver driver;
@FindBy (xpath="//input[@id='inlineRadio1']")
WebElement radioMale;
@FindBy(xpath="//input[@id='inlineRadio2']")
WebElement radioFemale;
@FindBy(xpath="//button[@id='button-one']")
WebElement showSelectedValue;
public RadioButtonPage(WebDriver driver) {
	this.driver=driver;
}
public void maleRadioClick() {
	radioMale.click();
}
public void femaleRadioClick() {
	radioFemale.click();
}
public void selectedValueClick() {
	showSelectedValue.click();
}
}
