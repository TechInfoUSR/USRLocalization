package DirectmanagerFlowMain;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class manager_AddGoals 
{
    
        private WebDriver driver;
        private Properties prop;
        

        private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");
        private By employeeName = By.xpath("(//h5[@class='ma-0'])[2]");
        private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
        private By goalCycleLink(String cycleName) 
        {
            return By.xpath("//a[contains(text(),'" + cycleName + "')]");
        }
        
        private By goalAction = By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/a[2]");
        private By goalTitle = By.id("obj_title");
        private By goalCategoryField = By.xpath("(//span[contains(text(),'Select Goal Category')])[1]");
        private By descriptionField = By.xpath("//textarea[@placeholder=\"type to add description\"]");
        private By toggleMetric = By.xpath("//a[@data-target=\"#Outcomes\"]");
        private By kpiSuccess = By.id("kpi_success");
        private By currentMetric = By.id("current_metric");
        private By weightField = By.id("Weight");
        private By CreateBTN = By.xpath("(//button[@class=\"btn btn-default btn-cs mt-1 ng-binding\"])[1]");
        public manager_AddGoals(WebDriver driver, Properties prop) 
        {
            this.driver = driver;
            this.prop = prop;
        }

        public void navigateToEmployeeSelf() throws InterruptedException 
        {
            driver.findElement(avatarIcon).click();
            driver.findElement(employeeName).click();
        }

        public void selectGoalCycle(String cycleName) throws InterruptedException 
        {
            driver.findElement(dropdownToggle).click();
            driver.findElement(goalCycleLink(cycleName)).click();
            
        }

        public void openEmployeeAssessment() throws InterruptedException 
        {
        
        	String empname = prop.getProperty("empname");
            driver.findElement(By.xpath("//span[contains(text(),'"+empname+" ')]")).click();
            
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            By element1 =  By.xpath("(//img[@src='pmsGE/images/icons/add.svg'])[1]");

            WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(element1));



            while (true) {
                try {
                    if (element.isDisplayed() && element.isEnabled()) {
                        element.click();
                        System.out.println("Clicked on the element.");
                    }
                    // Wait and check if the new page or modal appears
                    boolean isPopupVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("obj_title"))).isDisplayed();
                    if (isPopupVisible) {
                        System.out.println("Popup or new page opened.");
                        break; // Exit loop once the new page is detected
                    }
                } catch (Exception e) {
                    System.out.println("Element not interactable, retrying...");
                }
                Thread.sleep(1000); // Small delay before retrying
            }
            Thread.sleep(2000);
        }

        public void enterGoalDetails() throws InterruptedException 
        {
        	String goalType = prop.getProperty("GoalType");
        	String goalName = prop.getProperty("Title");
        	String goalCategory = prop.getProperty("goalCategory");
        	String description = prop.getProperty("Description");
        	String weight = prop.getProperty("Weight");
        	  
            driver.findElement(goalTitle).sendKeys(goalName);
            driver.findElement(goalCategoryField).click();
            List<WebElement> Catcount = driver.findElements(By.xpath("//li[@aria-selected=\"false\"]"));
     
            int numberOfQuestions = Catcount.size();
  	        System.out.println("Number of questions: " + numberOfQuestions);
               
            System.out.println(Catcount);
                
	           for(int i=1;i<=numberOfQuestions;i++) 
	           {
	            	  String ActualTest = driver.findElement(By.xpath("//li[@aria-selected=\"false\"]["+i+"]")).getText();
	            	  
	                if (ActualTest.equals(goalCategory) ) 
	                {
	                	System.out.println("Act"+ActualTest);
	                	driver.findElement(By.xpath("//li[@aria-selected=\"false\" and contains(text(),'')]["+i+"] ")).click();
	                	break;
	                }
	            }
                driver.findElement(By.xpath("//a[@data-target=\"#second\"]")).click();
                driver.findElement(descriptionField).sendKeys(description);
                driver.findElement(toggleMetric).click();
                
            	WebElement rangeInput = driver.findElement(toggleMetric); 
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                WebElement childwin = driver.findElement(By.xpath("//*[@id=\"Weight\"]"));
                                                                   //*[@id="tab_default_11"]/form/div[5]/div/div[1]/div[2]/h5
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childwin);
 
                driver.findElement(weightField).sendKeys(weight);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CreateBTN));
            	element.click();

     	    By messageLocator = By.xpath("//div[contains(text(),'Saved goal successfully')]");
     	    
     	    try {
     	        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
     	        element1.isDisplayed(); 
     	    } catch (TimeoutException e) {
     	         System.err.println("Not working");
     	    }

            	
            	
            }
        
        public boolean isGoalAdded() throws InterruptedException 
        {
//        	Thread.sleep(30000);
        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        	    By messageLocator = By.xpath("//div[contains(text(),'Saved goal successfully')]");
        	    
        	    try {
        	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
        	        return element.isDisplayed(); 
        	    } catch (TimeoutException e) {
        	        return false;
        	    }
        }


    public void selectGoalCycle() throws InterruptedException
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        }

        WebElement element1 = driver.findElement(By.xpath("(//a[@class=\"btn checkin-btn block-btn subAssessmentButton ng-scope\"])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
        element1.click();


              Thread.sleep(2000);     
        driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_mgr\"]")).sendKeys("MgrCMT");
              Thread.sleep(200);
        driver.findElement(By.xpath("//button[@ng-click=\"submitPerformanceForAuthorizeApprove()\"]")).click();


        By OkBtn = (By.xpath("//button[contains(text(),'OK')]"));
        WebElement OKbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(OkBtn));
        OKbtn.click();

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
        driver.findElement(By.xpath(cssSelector)).click();
//      		  Thread.sleep(500);
        driver.findElement(By.xpath(ReviewBTN)).click();
//      		  Thread.sleep(1000);
        String goal_comments1 = "goal_comments1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By is = (By.id(goal_comments1));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(is));
        element.sendKeys("MGR CMT");;

//      		  driver.findElement(By.id(goal_comments1)).sendKeys(Empcmt);

        driver.findElement(By.xpath("(//button[@class=\"btn btn-default btn-cs mt-1 ng-binding\"])[1]")).click();

        driver.findElement(By.xpath("//button[@ng-init=\"fetchTranslations('mgrGoalComments.l6');\" and contains(text(),'Close')]")).click();
//      		  Thread.sleep(1000);
    }

    public String isSelfsub() throws InterruptedException {
//    		  Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
        WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Self Review Completed')]")));
        okButton.getText();
        return okButton.getText();
    }


        
}
    
