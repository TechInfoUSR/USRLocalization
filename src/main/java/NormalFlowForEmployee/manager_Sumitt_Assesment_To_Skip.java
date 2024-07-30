package NormalFlowForEmployee;

import java.time.Duration; // For Selenium 4
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class manager_Sumitt_Assesment_To_Skip {

	   private WebDriver driver;
       private Properties prop;
       public manager_Sumitt_Assesment_To_Skip(WebDriver driver, Properties prop) 
       {
           this.driver = driver;
           this.prop = prop;
       }
       
       
       public void selectGoalCycle() throws InterruptedException 
       {
    	   String cycleName = prop.getProperty("GoalPalnName");
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement dropdownToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='dropdown-toggle']")));
    	    dropdownToggle.click();

    	    // Click on cycle name
    	    WebElement cycleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + cycleName + "')]")));
    	    cycleElement.click();

    	    String empname = prop.getProperty("empname");
    	    if (empname != null && !empname.isEmpty()) {
    	        WebElement empElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + empname + " ')]")));
    	        empElement.click();
    	    } else {
    	        throw new IllegalArgumentException("Employee name property is not set or empty.");
    	    }
    	    
            WebElement element = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            
           
            
            WebElement listContainer  = driver.findElement(By.id("categ105"));

            List<WebElement> noofGoals =listContainer.findElements(By.xpath("//ul[@class=\"flex flex-btn py-1 onhover-section ng-scope\"]"));
            int NoofGoal = noofGoals.size();
            System.out.println(NoofGoal);
            for (int i=1 ;i<=NoofGoal;i++) 
            {
          	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            
          	    Random random = new Random();
            	int randomNumber = random.nextInt(100) + 1;

            	System.out.println("Random number between 1 and 100: " + randomNumber);
            
            	updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
         		Thread.sleep(1000);
         		String Employee_cmt = "EmpCmt";
         		String Employee_comment =Employee_cmt + i;
//              EmployeeComment(driver,"(//img[@src=\"pmsGE/images/ellipsis-1.png\"])[("+i+")]",Employee_comment, "(//a[@class=\"view-link mt-h cs-modal-btn ng-binding ng-scope\"]) [("+i+")]");
              Thread.sleep(1000);
              
              WebElement element1 = driver.findElement(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[5]/div/a"));
              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

              
              driver.findElement(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[5]/div/a")).click();
              Thread.sleep(500); 
              driver.findElement(By.id("goal_checkin_commentsa")).sendKeys("MgrCMT");
              Thread.sleep(100);
              driver.findElement(By.xpath("//button[@ng-click=\"submitPerformanceForAuthorizeApprove()\"]")).click();
              driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
              Thread.sleep(1000); 
              
              
            } 
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
      		  Thread.sleep(500);
      		  driver.findElement(By.xpath(ReviewBTN)).click();
      		  Thread.sleep(500);
      		  String goal_comments1 = "goal_comments1";    	
      		  driver.findElement(By.id(goal_comments1)).sendKeys(Empcmt);

      		  driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[3]")).click();
   
      		  driver.findElement(By.xpath("(//button[contains(text(),'Close')])[1]")).click();
      		  Thread.sleep(1000);
      	  }
 
}