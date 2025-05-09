package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;

public class ExplicitWait {

	
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;

    
	public WebElement waitForElementVisiblity(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitUntillClickable(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
