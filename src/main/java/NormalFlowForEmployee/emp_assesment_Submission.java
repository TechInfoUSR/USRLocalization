package NormalFlowForEmployee;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emp_assesment_Submission {
	  private WebDriver driver;
      private Properties prop;
     
    		private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    		private By goalCycleLink(String cycleName) 
    		{
            return By.xpath("//a[contains(text(),'" + cycleName + "')]");
            }
    	  public emp_assesment_Submission(WebDriver driver, Properties prop) 
          {
              this.driver = driver;
              this.prop = prop;
          }
    	  
		public void selectGoalCycle(String cycleName) throws InterruptedException 
          {
    		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
              driver.findElement(dropdownToggle).click();
              driver.findElement(By.xpath("//a[contains(text(),'"+cycleName+"')]")).click();
//              driver.findElement(goalCycleLink(cycleName)).click();
             
              Thread.sleep(1000);
//              driver.findElement(By.xpath("//span[@class=\"ml-4\"]")).click();
                         
              Thread.sleep(1000);
          //  FOR Clicking on Drop down  
//              WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
              WebElement element = driver.findElement(By.xpath("//*[@id=\"myUL\"]/li/div")); 
              // Use JavaScriptExecutor to click on the element
              JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click();", element);
              Thread.sleep(2000);
            
     
              WebElement listContainer  = driver.findElement(By.xpath("//ul[@class=\"nested active\"]"));
              Thread.sleep(1000);
              List<WebElement> noofGoals =listContainer.findElements(By.xpath("//div[@ng-repeat=\"g in goalsList[0].goals track by $index\"]"));
              int NoofGoal = noofGoals.size();
              System.out.println(NoofGoal);
              for (int i=1 ;i<=NoofGoal;i++) 
              {
            	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            	  Thread.sleep(1000);
            	  Random random = new Random();

              	int randomNumber = random.nextInt(100) + 1;

              	System.out.println("Random number between 1 and 100: " + randomNumber);
              
              	updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
           		Thread.sleep(1000);
           		String Employee_cmt = "EmpCmt";
           		
           		String Employee_comment =Employee_cmt + i;
           		Thread.sleep(1000);
                EmployeeComment(driver,"(//img[@src=\"pmsGE/images/ellipsis-1.png\"])[("+i+")]",Employee_comment, "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"])[2]");
                Thread.sleep(1000);
              }
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           driver.findElement(By.xpath("//a[@ng-click=\"submitSelfPerformance(1)\"]")).click();
           Thread.sleep(700); 
           driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
           Thread.sleep(700); 
           
          }
    	  private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) 
    	  {  
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
    	  private static void EmployeeComment(WebDriver driver, String cssSelector, String Empcmt, String ReviewBTN) throws InterruptedException 
    	  { 
    		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    		  driver.findElement(By.xpath(cssSelector)).click();
    		  Thread.sleep(1000);
    		  driver.findElement(By.xpath(ReviewBTN)).click();
    		  Thread.sleep(1000);
    		  String goal_comments1 = "goal_comments1";    	
    		  driver.findElement(By.id(goal_comments1)).sendKeys(Empcmt);
    		  Thread.sleep(500);
    		  driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[3]")).click();
    		  Thread.sleep(500);
    		  driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
    		  Thread.sleep(1000);
    	  }
    }
