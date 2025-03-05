package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil1 {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Set the date format for the screenshot file name
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // Set the destination file path
        String destination = System.getProperty("user.dir") + "/Screenshort/" + screenshotName + dateName + ".png";
        // Capture the screenshot
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot taken: " + destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
        return destination; // Return the path of the screenshot
    }
}
