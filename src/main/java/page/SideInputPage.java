package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideInputPage {
	WebDriver driver;
	@FindBy (xpath="//a[text()='Simple Form Demo']")
	WebElement simpleForm;
	@FindBy(xpath="//a[text()='Checkbox Demo']")
	WebElement checkBox;
	@FindBy(xpath="//a[@href='ajax-form-submit.php']")
	WebElement ajaxForm;
	@FindBy(xpath="//a[@href='form-submit.php']")
	WebElement formSubmit;
	@FindBy(xpath="//a[@href='radio-button-demo.php']")
	WebElement radioButtons;
	public SideInputPage (WebDriver driver) {
		this.driver=driver;
	}
	public void sideSimpleForm() {
		simpleForm.click();
	}
	public void sideAjaxForm() {
		ajaxForm.click();
	}
	public void sideCheckBox() {
		checkBox.click();
	}
	public void sideFormSubmit() {
		formSubmit.click();
	}
	public void sideRadioButton() {
		radioButtons.click();
	}
}
