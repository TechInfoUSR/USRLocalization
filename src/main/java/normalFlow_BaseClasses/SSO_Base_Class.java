package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.devtools.v131.network.model.Cookie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class SSO_Base_Class {
	 WebDriver driver;
	    Properties prop;

	
	public SSO_Base_Class(WebDriver driver, Properties prop){
		this.driver =driver;
		this.prop=prop;
	}
	

public void baseSSO() throws InterruptedException, ParseException 
{
//	driver.get(prop.getProperty("url"));
     Thread.sleep(3000);	  
     
     
     ChromeOptions options = new ChromeOptions();
     options.addArguments("C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data");
     options.addArguments("Profile 4"); // or "Profile 1" etc.

     WebDriver driver = new ChromeDriver(options);

     // Open your app — should already be logged in
 	driver.get(prop.getProperty("url"));
     
     
     
     
     
}  
     
   void  methed1(){
//     // Click "Sign in with Google" button
//     WebElement fr = driver.findElement(By.xpath("//iframe[@class=\"L5Fo6c-PQbLGe\"]"));
//     driver.switchTo().frame(fr);
//     
//     WebElement ele = driver.findElement(By.xpath("//span[@class=\"nsm7Bb-HzV7m-LgbsSe-BPrWId\"]"));
//     
//     try {
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
//
//         element.click();
//         System.out.println("Element clicked successfully");
//     } catch (TimeoutException e) {
//         System.out.println("Element not found or not clickable within time");
//     } catch (Exception e) {
//         System.out.println("Unexpected error: " + e.getMessage());
//     }
//     
//     Thread.sleep(2000);	  
//     // Switch to Google login window
//     String mainWindow = driver.getWindowHandle();
//     for (String handle : driver.getWindowHandles()) {
//         if (!handle.equals(mainWindow)) {
//             driver.switchTo().window(handle);
//         }
//     }
//     Thread.sleep(2000);	  
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//     // Enter Email
//     WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
//     emailField.sendKeys("skipmanagergobetter@gmail.com");
//     driver.findElement(By.id("identifierNext")).click();
//     Thread.sleep(2000);	  
//     // Enter Password
//     WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//     passwordField.sendKeys("goBetter@123");
//     driver.findElement(By.id("passwordNext")).click();
//     Thread.sleep(2000);	  
//     // Wait until redirected back to your app
//     driver.switchTo().window(mainWindow);
//     wait.until(ExpectedConditions.urlContains("your-app-domain.com"));
//     Thread.sleep(2000);	  
//     System.out.println("Login successful!");

     
     
     
    }
     void method2 () {
//     String expiryStr = "Fri Aug 21 2026 14:36:25 GMT+0530 (India Standard Time)";
//
//     // Format to match Java's date parser (ignore the timezone description in brackets)
//     SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
//
//     // Remove the " (India Standard Time)" part
//     expiryStr = expiryStr.replace(" (India Standard Time)", "");
//
//     // Parse string into Date
//     Date expiryDate = sdf.parse(expiryStr);
//     
//     
//	// Create Cookie (without Builder)
//     Cookie sessionCookie = new Cookie.Builder("JSESSIONID", "C6E96264F2EC4BFAA9A7116540BBED65")
//             .domain("test.okrstars.com")
//             .path("/solutions")
//             .expiresOn(expiryDate)
//             .isSecure(true)
//             .build();
//
//     System.out.println("Cookie expiry set to: " + expiryDate);
//
//	// Add cookie to driver
//	driver.manage().addCookie(sessionCookie);
//
//	// Refresh or go to page
////	driver.navigate().to("https://test.okrstars.com/solutions/perform/mgr/teamPMS");
//

     
}
 }

