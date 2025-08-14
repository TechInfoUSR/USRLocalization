package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Delete_the_PMS_Cycle {
    WebDriver driver;
    Properties prop;

    public Delete_the_PMS_Cycle(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }
    public void Deletion() throws InterruptedException {

        String goal = prop.getProperty("GoalPalnName");
        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
        Srollup.executeScript("window.scrollBy(0,1850)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[contains(text(),'PMS Program Management')][1]")).click();
        WebElement drop = driver.findElement(By.xpath("//select[@ng-model=\"encReviewCycleId\"]"));
        Select S = new Select(drop);
        S.selectByVisibleText(goal);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the rows to be present
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']//tbody")));

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));


        // Count the number of rows
        int rowCount = tableRows.size();
        System.out.println("Number of rows: " + rowCount);
        Thread.sleep(2000);
        for(int i=1;i<=rowCount;i++)
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();
            String actualTextRemoveEmp = driver.findElement(By.xpath("/html/body/div/div[6]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b")).getText();
            System.out.println(actualTextRemoveEmp);
            String actualResetManagerAssessment = driver.findElement(By.xpath("//a[@ng-click=\"resetAppraisal(pp.reviewCycleId,pp.employeeId,true,2)\"]//b")).getText();
            System.out.println(actualResetManagerAssessment);
            String ResetEmpAssesmet = driver.findElement(By.xpath("(//a[@ng-click=\"resetAppraisal(pp.reviewCycleId,pp.employeeId,false,1,1)\"]//b)[1]")).getText();
            System.out.println(ResetEmpAssesmet);
            String actResetEmpAssesmet = driver.findElement(By.xpath("(//a[@ng-click=\"resetAppraisal(pp.reviewCycleId, pp.employeeId, false,3)\"]//b)[1]")).getText();
            

            String RemoveEmployee = "Remove Employee from this PMS Cycle";
            String ResetManager = "Reset Manager's and Authorized Assessment (without deleting contents already filled by employee and manager)";
            String ResetEmployee = "Reset Employee Assessment";
            String ResetApproverAsses = "Reset Approver's Assessment (the comment provided by the approver will be deleted)";
            
            Thread.sleep(2000);
            
            if(actualTextRemoveEmp.equals(RemoveEmployee))
            {

                RemoveEmp();
            }
            else if(actualResetManagerAssessment.equals(ResetManager))
            {
                System.out.println("ResetManagerAssessment");
                ResetManagerAssessment();
            }
            else if(ResetEmpAssesmet.equals(ResetEmployee))
            {
                System.out.println("ResetEmpAssesmet");
                ResetEmpAssesmet();
            }

            else if(actResetEmpAssesmet.equals(ResetApproverAsses))
            {
                System.out.println("ResetApproverAsses");
                ResetApproverAssesmet();
            }
            
        }

    }

    void RemoveEmp() throws InterruptedException
    {    	
    	Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By Isbuttonclickable =  By.xpath("/html/body/div/div[6]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b");
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(Isbuttonclickable));      
        element.click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
        Thread.sleep(3000);
    }


    void ResetEmpAssesmet() throws InterruptedException
    {Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By Isbuttonclickable =  By.xpath("(//b[contains(text(),\"Reset Employee Assessment \")])[1]");
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(Isbuttonclickable));      
        element.click();

    	Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();
        Thread.sleep(3000);
        RemoveEmp();
    }

    void ResetManagerAssessment() throws InterruptedException
    {Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By Isbuttonclickable =  By.xpath("(//b[contains(text(),\"Reset Manager's and Authorized Assessment (without deleting contents already filled by employee and manager)\")])[1]");
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(Isbuttonclickable));      
        element.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
        Thread.sleep(3500);
//        driver.findElement(By.xpath("(//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"])[1]")).click();
//        Thread.sleep(4000);
//        driver.findElement(By.xpath("(/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/*)[1]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
//        Thread.sleep(3500);
        driver.findElement(By.xpath("(//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"])[1]")).click();
        Thread.sleep(3000);
        ResetEmpAssesmet();

    }
    
    void ResetApproverAssesmet() throws InterruptedException{
    	
    	Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By Isbuttonclickable =  By.xpath("(//b[contains(text(),\"Reset Approver's Assessment (the comment provided by the approver will be deleted)\")])[1]");
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(Isbuttonclickable));      
        element.click();   
        
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"])[1]")).click();
        Thread.sleep(2000);
        ResetManagerAssessment();
        
    }
    
    
    public boolean isDeleted() throws InterruptedException {
        Thread.sleep(500);
        return driver.findElement(By.xpath("//span[contains(text(),'0-1000 of 0')]")).isDisplayed();
    }
}
