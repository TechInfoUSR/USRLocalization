package NormalFlowForEmployee;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class manager_AddGoals 
{
    
        private WebDriver driver;
        private Properties prop;
        ExplicitWait ExplicitWait;
        

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
            WebElement element = ExplicitWait.waitForElementVisiblity(element1);

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
            	WebElement element = ExplicitWait.waitUntillClickable(CreateBTN);
            	element.click();
           	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
     	    By messageLocator = By.xpath("//div[contains(text(),'Saved goal successfully')]");
     	    
     	    try {
     	        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
     	        element1.isDisplayed(); 
     	    } catch (TimeoutException e) {
     	         System.err.println("Not working");
     	    }
            	
            	Thread.sleep(30000);
            	
            	
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
        
}
    
