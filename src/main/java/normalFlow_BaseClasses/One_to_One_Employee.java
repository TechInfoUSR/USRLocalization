package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class One_to_One_Employee {
	  private WebDriver driver;
      private Properties prop;
     
    		private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    		private By goalCycleLink(String cycleName) 
    		{
            return By.xpath("//a[contains(text(),'" + cycleName + "')]");
            }
    	  public One_to_One_Employee(WebDriver driver, Properties prop) 
          {
              this.driver = driver;
              this.prop = prop;
          }

    	  
      public void selectGoalCycle(String cycleName) throws InterruptedException 
      {

	      driver.findElement(dropdownToggle).click();
	      driver.findElement(By.xpath("//a[contains(text(),'"+cycleName+"')]")).click();
	//      driver.findElement(goalCycleLink(cycleName)).click();
	      driver.findElement(By.xpath("//span[@class=\"ml-4\"]")).click();
	      Thread.sleep(1000);
		  By SUBBTN = By.xpath("(//a[contains(text(),' Submit Employee Acknowledgement')])[1]");

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  WebElement ReviewCycleIcon1 = wait.until(ExpectedConditions.elementToBeClickable(SUBBTN));
		  ReviewCycleIcon1.click();
//	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
//	      Thread.sleep(500);
      }
      public String isSelfsub() throws InterruptedException {
//    	  Thread.sleep(600);
 		 return driver.findElement(By.xpath("//div[contains(text(),'Submitted successfully')]")).getText();
 	  }
}
