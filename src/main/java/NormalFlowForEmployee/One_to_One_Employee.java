package NormalFlowForEmployee;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
//	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//a[@ng-click=\"submitEmployeeAckowledgement()\"][1]")).click();
//	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
//	      Thread.sleep(500);
      }
      public String isSelfsub() throws InterruptedException {
//    	  Thread.sleep(600);
 		 return driver.findElement(By.xpath("//div[contains(text(),'Submitted successfully')]")).getText();
 	  }
}
