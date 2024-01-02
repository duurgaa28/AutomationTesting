package page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.WaitUtil;
import util.WindowHandleUtil;

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
	WindowHandleUtil.windowHandle(driver);
}
	public  String getTitles() {
		WaitUtil waitUtil = new WaitUtil(driver);
		waitUtil.explicitWait(25, title);
		return title.getText();
	}

public void followBtnClick() {
	followAllButton.click();
}
}
