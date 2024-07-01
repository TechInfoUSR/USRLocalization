package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
              
              
              
              
          //  FOR Clicking on Drop down  
              WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
              // Use JavaScriptExecutor to click on the element
              JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click();", element);
              Thread.sleep(3000);
            
              
              
          //  FOR Drgging the progress bar 
//           WebElement rangeInput = driver.findElement(By.cssSelector("input[type='range']")); 
//           int progress = 70; // Example: setting progress to 50%
//
//           // Cast WebDriver to JavascriptExecutor
//           JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
//           // Update the value of the range input and trigger the change event
//           String script = "arguments[0].value = arguments[1];" +
//                           "arguments[0].dispatchEvent(new Event('change'));";
//           jsExecutor.executeScript(script, rangeInput, progress);
//
//           // Optionally, update the progress text (if needed)
//           WebElement progressText = driver.findElement(By.cssSelector(".risk"));
//           jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));
//           Thread.sleep(3000);
           
           updateProgressBar(driver, "(//input[@type=\"range\"])[1]", 50);
           Thread.sleep(1000);
           updateProgressBar(driver, "(//input[@type=\"range\"])[2]", 75);
           Thread.sleep(2000); 
           updateProgressBar(driver, "(//input[@type=\"range\"])[3]", 25);
           Thread.sleep(2000); 
           updateProgressBar(driver, "(//input[@type=\"range\"])[4]", 15);
           Thread.sleep(2000); 
           
           
//           Increase the Number in 2nd String and Last String for Every Time while calling the Method
           EmployeeComment(driver,"(//img[@class=\"dropdown-toggle\"])[5]","Employee comment", "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"]) [1]");
           Thread.sleep(2000);
           
           EmployeeComment(driver,"(//img[@class=\"dropdown-toggle\"])[6]","Employee comment", "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"]) [2]");
           Thread.sleep(2000);
           
           
           driver.findElement(By.xpath("//a[@ng-click=\"submitSelfPerformance(1)\"]")).click();
           Thread.sleep(2000); 
//           driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
           Thread.sleep(2000); 
           
          }
    	  private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) {  
	    	  WebElement rangeInput = driver.findElement(By.xpath(cssSelector)); 
            // Cast WebDriver to JavascriptExecutor
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            // Update the value of the range input and trigger the change event
            String script = "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('change'));";
            jsExecutor.executeScript(script, rangeInput, progress);
            // Optionally, update the progress text (if needed)
            WebElement progressText = driver.findElement(By.cssSelector(".risk"));
            jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));


	    }
    	  private static void EmployeeComment(WebDriver driver, String cssSelector, String Empcmt, String ReviewBTN) throws InterruptedException { 
    		  driver.findElement(By.xpath(cssSelector)).click();
    		  Thread.sleep(2000);
    		  driver.findElement(By.xpath(ReviewBTN)).click();
    		  Thread.sleep(2000);
    		  String goal_comments1 = "goal_comments1";    	
    		  driver.findElement(By.id(goal_comments1)).sendKeys(Empcmt);
    		  Thread.sleep(2000);
    		  driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[3]")).click();
    		  Thread.sleep(5000);
    		  driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
    		  Thread.sleep(2000);
    	  }
    }


