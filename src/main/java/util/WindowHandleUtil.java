package util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandleUtil {
	static WebDriver driver;

public static void windowHandle(WebDriver driver) {
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
}
