package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitUtil {
	WebDriver driver;
	
public WaitUtil(WebDriver driver) {
	this.driver=driver;
}
public void implicitWait(int implicitseconds) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitseconds));
}
public void explicitWait(int explicitseconds, WebElement element) {
	WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(explicitseconds));
	webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
}
public void explicitWaitVisible(int explicitseconds, WebElement message, String expectedMessage) {
	WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(15));
	 webDriverWait.until(ExpectedConditions.textToBePresentInElement(message, expectedMessage));
}
public void fluentWait() {
	FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
	fluentWait.pollingEvery(Duration.ofSeconds(2));
	fluentWait.withTimeout(Duration.ofSeconds(30));
	fluentWait.ignoring(NoSuchElementException.class);
	fluentWait.ignoring(WebDriverException.class);
	WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver arg) {
			return arg.findElement(By.xpath(""));
		}
	});
}
}
