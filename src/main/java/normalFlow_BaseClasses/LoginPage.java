package normalFlow_BaseClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
   public LoginPage(WebDriver driver) 
   {
       this.driver = driver;
   }
   
   private By usernameField = By.xpath("//input[@name=\"username\"]");
   private By passwordField = By.xpath("//input[@name=\"password\"]");
   private By loginButton = By.xpath("//button[@type=\"submit\"]");
	
	public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
	
	 public  void ClosePopUp(){
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 	    By closeBtnLocator = By.xpath("//button[@class='close']");

 		try {
 	        WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtnLocator));
 	        if (closeBtn.isDisplayed()) {
 	            closeBtn.click();
 	            System.out.println("Popup closed successfully.");
 	        }
 	    } catch (TimeoutException e) {
 	        System.out.println("Popup did not appear. Continuing without closing.");
 	    } catch (Exception e) {
 	        System.out.println("Unexpected exception in ClosePopUp: " + e.getMessage());
 	    }
 	}
	
}
