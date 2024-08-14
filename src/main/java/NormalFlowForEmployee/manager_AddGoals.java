package NormalFlowForEmployee;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class manager_AddGoals 
{
    
        private WebDriver driver;
        private Properties prop;

        // Locators for elements on the EmployeeSelfPage
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
            Thread.sleep(2000);
        }

        public void selectGoalCycle(String cycleName) throws InterruptedException 
        {
            driver.findElement(dropdownToggle).click();
            Thread.sleep(2000);
            driver.findElement(goalCycleLink(cycleName)).click();
            Thread.sleep(1000);
        }

        public void openEmployeeAssessment() throws InterruptedException 
        {
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	String empname = prop.getProperty("empname");
            driver.findElement(By.xpath("//span[contains(text(),'"+empname+" ')]")).click();
            Thread.sleep(2000);
            
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/a[2]")));
//            element.click();
//            driver.findElement(goalAction).click();

            
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/a[2]")));
            if (element.isDisplayed() && element.isEnabled()) {
            	Thread.sleep(3000);
                element.click(); // or perform other actions
            }
            else
            	element.click();

            
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/a[2]")));
//            element.click(); // or other actions

            
            
            Thread.sleep(2000);
        }

        public void enterGoalDetails() throws InterruptedException 
        {
        	String goalType = prop.getProperty("GoalType");
        	String goalName = prop.getProperty("Title");
        	String goalCategory = prop.getProperty("goalCategory");
        	String description = prop.getProperty("Description");
        	String weight = prop.getProperty("Weight");
        	  
//            	driver.findElement(goalTitle).click();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     	
            driver.findElement(goalTitle).sendKeys(goalName);
            Thread.sleep(100);
            driver.findElement(goalCategoryField).click();
            Thread.sleep(500);
            List<WebElement> Catcount = driver.findElements(By.xpath("//li[@aria-selected=\"false\"]"));
     
            int numberOfQuestions = Catcount.size();
  	        System.out.println("Number of questions: " + numberOfQuestions);
               
            System.out.println(Catcount);
                
//             String ActualTest = driver.findElement(goalTitle).getText();
	           for(int i=1;i<=numberOfQuestions;i++) 
	           {
	            	  String ActualTest = driver.findElement(By.xpath("//li[@aria-selected=\"false\"]["+i+"]")).getText();
//	            	  Thread.sleep(10);       	 
//	                  System.out.println(ActualTest);
	                if (ActualTest.equals(goalCategory) ) 
	                {
	                	System.out.println("Act"+ActualTest);
	                	driver.findElement(By.xpath("//li[@aria-selected=\"false\" and contains(text(),'')]["+i+"] ")).click();
	//                  driver.findElement(By.xpath("//li[@class=\"select2-results__option select2-results__option--selectable\" and contains(text(),'"+goalCategory+"')]")).click();
	                	Thread.sleep(500);
	                	break;
	                }
	            }
//              driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(goalCategory);
//              Thread.sleep(500);
//              driver.findElement(By.xpath("//li[contains(text(),'OKRs') and @role=\"option\"] [3]")).click();
//              Thread.sleep(500);
                driver.findElement(By.xpath("//a[@data-target=\"#second\"]")).click();
                Thread.sleep(500);
                driver.findElement(descriptionField).sendKeys(description);
                Thread.sleep(500);
//              JavascriptExecutor Srollup1 = (JavascriptExecutor) driver;
//              Srollup1.executeScript("window.scrollBy(0,1000)");
                driver.findElement(toggleMetric).click();
                Thread.sleep(500);
//              driver.findElement(kpiSuccess).click();
//              driver.findElement(currentMetric).click();              
//              driver.findElement(toggleMetric).click();                  
//              WebElement ele = driver.findElement(weightField);
//              Srollup1.executeScript("arguments[0].srollIntoView();", ele);
                
            	WebElement rangeInput = driver.findElement(toggleMetric); 
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                
                driver.findElement(weightField).sendKeys(weight);
                Thread.sleep(5000);
                driver.findElement(CreateBTN).click();
                Thread.sleep(5000);
                
            }
}
    
