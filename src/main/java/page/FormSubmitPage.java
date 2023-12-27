package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormSubmitPage {
WebDriver driver;
@FindBy(xpath="//input[@id='validationCustom01']")
WebElement firstName;
@FindBy(xpath="//input[@id='validationCustom02']")
WebElement lastName;
@FindBy(xpath="//input[@id='validationCustomUsername']")
WebElement userName;
@FindBy(xpath="//input[@id='validationCustom03']")
WebElement city;
@FindBy(xpath="//input[@id='validationCustom04']")
WebElement state;
@FindBy(xpath="//input[@id='validationCustom05']")
WebElement zip;
@FindBy(xpath="//input[@id='invalidCheck']")
WebElement agreeCheckBox;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement submitFormButton;
@FindBy(xpath="//div[@id='message-one']")
WebElement formMessage;
public FormSubmitPage(WebDriver driver) {
	this.driver=driver;
}
public void inputFirstName(String firstname) {
	firstName.sendKeys(firstname);
}
public void inputLastName(String lastname) {
	lastName.sendKeys(lastname);
}
public void inputUserName(String username) {
	userName.sendKeys(username);
}
public void inputCity(String cityname) {
	city.sendKeys(cityname);
}
public void inputState(String statename) {
	state.sendKeys(statename);
}
public void inputZip(String zipcode) {
	zip.sendKeys(zipcode);
}
public void checkBox(Boolean checkBoxB) {
	if(checkBoxB) {
	agreeCheckBox.click();}
}
public void submitFormClick() {
	submitFormButton.click();
}
public String getDisplayedMsg() {
	return formMessage.getText();
}
}
