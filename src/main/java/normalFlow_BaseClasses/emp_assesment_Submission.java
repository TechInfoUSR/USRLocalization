package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emp_assesment_Submission {
	  private WebDriver driver;
      private Properties prop;
    addGoalPlan addGoalPlan;
     
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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By is = (dropdownToggle);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(is));
            element.click();

             
              By cycleName1 = (By.xpath("//a[contains(text(),'"+cycleName+"')]"));
              WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cycleName1));
              element1.click();
//              Thread.sleep(5000);
//              driver.findElement(goalCycleLink(cycleName)).click();
              driver.findElement(By.xpath("//span[@class=\"ml-4\"]")).click();
                         
              
          //  FOR Clicking on Drop down  
              WebElement elements = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
              // Use JavaScriptExecutor to click on the element
              JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click();", elements);
//              Thread.sleep(1000);
            
     
              WebElement listContainer  = driver.findElement(By.id("categ1"));

              List<WebElement> noofGoals =listContainer.findElements(By.xpath("//ul[@class=\"flex flex-btn py-1 onhover-section ng-scope\"]"));
              int NoofGoal = noofGoals.size();
              System.out.println(NoofGoal);
              for (int i=1 ;i<=NoofGoal;i++) 
              {
            	Random random = new Random();
              	int randomNumber = random.nextInt(100) + 1;
              	System.out.println("Random number between 1 and 100: " + randomNumber);
              
              	updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
//           		Thread.sleep(5000);
           		String Employee_cmt = "EmpCmt";
           		String Employee_comment =Employee_cmt + i;
                EmployeeComment(driver,"(//div[@class=\"dropdown\"])[2]",Employee_comment, "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"]) [("+i+")]");
//                Thread.sleep(1000);
              }
           driver.findElement(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/div/a")).click();
           Thread.sleep(1000); 
           WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
           WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-bb-handler=\"confirm\"]")));
           okButton.click();
//           Thread.sleep(1000);
           
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

            
               String num = driver.findElement(By.xpath("//*[@id=\"categ1\"]/ul/li[3]/div[2]/div/div[2]")).getText();
              String s= "+progress+"+"%";
              if (num== s)
		{
			System.err.println("Pass");
		}
              else
              {
                  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
                  WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categ1\"]/ul/li[3]/div[2]/div/div[2]")));
                  okButton.isDisplayed();
              }
	      }
    	  private static void EmployeeComment(WebDriver driver, String cssSelector, String Empcmt, String ReviewBTN) throws InterruptedException 
    	  { 
    		  driver.findElement(By.xpath(cssSelector)).click();
//    		  Thread.sleep(500);
    		  driver.findElement(By.xpath(ReviewBTN)).click();
//    		  Thread.sleep(500);
    		  String goal_comments1 = "goal_comments1";
    		  
    		  By CMT = By.id(goal_comments1);
       	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CMT));      
       	      element.sendKeys(Empcmt);
    		 
    	
    		  By CMTBTn = By.xpath("//*[@id=\"nggDiv\"]/div[16]/div/div[2]/form[1]/div[4]/div[1]/button[2]");       	    
              WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(CMTBTn));      
       	      element1.click();
    		 
    		  By CMTBTn2 = By.xpath("//*[@id=\"nggDiv\"]/div[16]/div/div[2]/form[1]/div[4]/div[1]/button[1]");       	    
              WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(CMTBTn2));      
       	      element2.click();
    		
    		  
//    		  Thread.sleep(1000);
    	  }
    	  public String isSelfsub() throws InterruptedException {   	
//    		  Thread.sleep(2000);
    		  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
              WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Self Review Completed')]")));
              okButton.getText();
    		 return okButton.getText();
    	  }
    }
