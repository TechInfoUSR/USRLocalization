package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class manager_AddGoals 
{
    
        private WebDriver driver;
        private Properties prop;

        // Locators for elements on the EmployeeSelfPage
        private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");
        private By employeeName = By.xpath("(//h5[@class='ma-0'])[2]");
        private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
        private By goalCycleLink(String cycleName) {
            return By.xpath("//a[contains(text(),'" + cycleName + "')]");
        }
        private By employeeLink = By.xpath("//span[contains(text(),'Ranganath ')]");
        private By goalAction = By.xpath("(//img[@alt=\"Add\" and @width=\"24\"]) [1]");
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
            driver.findElement(goalCycleLink(cycleName)).click();
            Thread.sleep(1000);
        }

        public void openEmployeeAssessment() throws InterruptedException 
        {
            driver.findElement(employeeLink).click();
            Thread.sleep(2000);
            driver.findElement(goalAction).click();
            Thread.sleep(2000);
        }

        public void enterGoalDetails() throws InterruptedException {
        	String goalType = prop.getProperty("GoalType");
        	String goalName = prop.getProperty("Title");
        	String goalCategory = prop.getProperty("goalCategory");
        	String description = prop.getProperty("Description");
        	String weight = prop.getProperty("Weight");
        	  
//            	driver.findElement(goalTitle).click();
            	Thread.sleep(1000);
                driver.findElement(goalTitle).sendKeys(goalName);
                Thread.sleep(1000);
                driver.findElement(goalCategoryField).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(goalCategory);
                Thread.sleep(1000);
                driver.findElement(By.xpath("//li[contains(text(),'OKRs') and @role=\"option\"] [3]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[@data-target=\"#second\"]")).click();
                Thread.sleep(1000);
                driver.findElement(descriptionField).sendKeys(description);
                Thread.sleep(1000);
//                JavascriptExecutor Srollup1 = (JavascriptExecutor) driver;
//                Srollup1.executeScript("window.scrollBy(0,1000)");
                driver.findElement(toggleMetric).click();
                Thread.sleep(1000);
//                    driver.findElement(kpiSuccess).click();
//                    driver.findElement(currentMetric).click();              
//                    driver.findElement(toggleMetric).click();  
                
//                WebElement ele = driver.findElement(weightField);
//                Srollup1.executeScript("arguments[0].srollIntoView();", ele);
                driver.findElement(weightField).sendKeys(weight);
                Thread.sleep(1000);
                driver.findElement(CreateBTN).click();
                Thread.sleep(10000);
                
            }
}
    
