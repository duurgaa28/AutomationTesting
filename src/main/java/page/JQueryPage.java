package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WaitUtil;

public class JQueryPage {
WebDriver driver;
@FindBy(xpath="//button[@id='downloadButton']")
WebElement downloadButton;
@FindBy(xpath="//button[@class='ui-button ui-corner-all ui-widget']")
WebElement closeButton;

public JQueryPage(WebDriver driver) {
    this.driver = driver;
}
public void downloadBtnClick() {
	downloadButton.click();
}
public void closeBtnClick() {
	WaitUtil waitUtil = new WaitUtil(driver);
	waitUtil.explicitWait(25, closeButton);
	closeButton.click();
}
}
