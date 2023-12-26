package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveIntiation {
	
	public static final String INTIAL_URL="https://selenium.obsqurazone.com/index.php";
public WebDriver driveInitialize (String browserName)throws Exception{
WebDriver driver;

if (browserName.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenovo\\new_selenium\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	} 
	else if (browserName.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\lenovo\\new_selenium\\chromedriver-win64\\chromedriver.exe ");
	driver = new ChromeDriver();
	} 
	else {
		throw new Exception("Incorrect Browser");
	}
return driver;
}
}
