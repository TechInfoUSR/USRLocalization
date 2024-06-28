package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class emp_assesment_Submission {
	  private WebDriver driver;
      private Properties prop;
    
    	private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    	  private By goalCycleLink(String cycleName) {
              return By.xpath("//a[contains(text(),'" + cycleName + "')]");
          }
    	  public emp_assesment_Submission(WebDriver driver, Properties prop) 
          {
              this.driver = driver;
              this.prop = prop;
          }
    	  public void selectGoalCycle(String cycleName) throws InterruptedException 
          {
              driver.findElement(dropdownToggle).click();
              driver.findElement(goalCycleLink(cycleName)).click();
              Thread.sleep(3000);
             
              driver.findElement(By.xpath("//span[@class=\"ml-4\"]")).click();
              Thread.sleep(2000);
              
          }
    	     
    }


