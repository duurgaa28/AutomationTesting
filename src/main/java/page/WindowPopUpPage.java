package page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPopUpPage {
WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-primary windowSingle']")
WebElement facebookButton;
@FindBy(xpath="//a[@id='windowMulti']")
WebElement followAllButton;
@FindBy(xpath="//form[@id='login_popup_cta_form']/div/div[@class='x1xka2u1 xqfms19']/child::span")
WebElement title;

public WindowPopUpPage (WebDriver driver) {
	this.driver=driver;
}
public void facebookBtnClick() {
	facebookButton.click();
	String parentWindow = driver.getWindowHandle();
	Set<String> WindowHandlesss = driver.getWindowHandles();
	Iterator<String> iterator = WindowHandlesss.iterator();
	while (iterator.hasNext()) {
		String childWindow = iterator.next();
		if (!parentWindow.equals(childWindow)) {
			driver.switchTo().window(childWindow);
		}
}
}
	public  String getTitles() {
		return title.getText();
	}

public void followBtnClick() {
	followAllButton.click();
}
}
