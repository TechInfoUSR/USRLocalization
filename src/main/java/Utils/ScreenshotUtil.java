package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;

public class ScreenshotUtil {



    public static void captureScreenshot(String testName, WebDriver driver) {
    	
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
        	if(!srcFile.equals(null))
            FileUtils.copyFile(srcFile, new File("screenshots/" + testName + ".png"));
        	else
            FileUtils.copyFile(srcFile, new File("screenshots/AllTestCasesPassed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
