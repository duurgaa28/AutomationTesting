package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {
    public static void takeScreenshot(String screenshotFile, WebDriver driver) throws Exception {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/ScreenShots/" + screenshotFile;
        FileUtils.copyFile(file, new File(destination));
    }
}	


