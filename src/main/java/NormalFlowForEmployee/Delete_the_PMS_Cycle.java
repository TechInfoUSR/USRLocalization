package NormalFlowForEmployee;

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
    Srollup.executeScript("window.scrollBy(0,1500)");
    driver.findElement(By.xpath("//h3[contains(text(),'PMS Program Management')][1]")).click();
    WebElement drop = driver.findElement(By.xpath("//select[@ng-model=\"encReviewCycleId\"]"));
//    driver.findElement(By.xpath("//select[@ng-model=\"encReviewCycleId\"]")).click();
    Select S = new Select(drop);
    S.selectByVisibleText(goal);
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    // Wait for the rows to be present
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']//tr[@ng-repeat=\"pp in allProgressData | filter:{employeeName: searchEmployeeName}\"]")));

    List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr[@ng-repeat=\"pp in allProgressData | filter:{employeeName: searchEmployeeName}\"]"));
    
    // Count the number of rows
    int rowCount = tableRows.size();
    System.out.println("Number of rows: " + rowCount);
    Thread.sleep(2000);
    for(int i=1;i<=rowCount;i++) 
    {
   	
    	driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();   	
//	    driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle cmenu-hide\"])[1]")).click();
//	    WebElement status = driver.findElement(By.xpath("//span[contains(text(),'Goal Setting Incomplete')]"));
	     
    	String actualText = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b")).getText();
	    System.out.println(actualText);
	    String actualText1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[2]/a/b")).getText();
	    System.out.println(actualText);
	    String ResetEmpAssesmet = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]/b")).getText();
	    System.out.println(actualText);
	    
	    String exp = "Remove Employee from this PMS Cycle";
	    String rmtex = "Reset Manager's Assessment (without deleting contents filled already by emp. and manager)";
	    String ResetAct = "Reset Employee's Assessment (without deleting contents filled already by emp.)";
	    Thread.sleep(2000);
	    if(actualText.equals(exp)) 
	     {
    		
	    	 RemoveEmp();
    	 }
	     else if(actualText1.equals(rmtex)) 
	     {
	    	 System.out.println("ResetManagerAssessment");
	    	 ResetManagerAssessment();
	     }
	     else if(ResetEmpAssesmet.equals(ResetAct)) 
	     {
	    	 System.out.println("ResetEmpAssesmet");
	    	 ResetEmpAssesmet();
	     }
    	
	    
//    	switch(i) {
//	    case 1: RemoveEmp(); break;
//	    case 2: DeleteSkipLevelManagersAssessment(); break;
//	    case 3: ResetManagerAssessment();break;
//	    default : System.out.println("Invalid");
//	    }
    	
    	
//	    driver.findElement(By.xpath("(//a[@ng-click=\"deleteEmpfromCycle(pp.reviewCycleId,pp.employeeId)\"])[1]")).click();
    }
    
	}

	void RemoveEmp() throws InterruptedException 
	{
		driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b")).click();
//		driver.findElement(By.xpath("//a[@class=\"dropdown-toggle cmenu-hide\"]")).click();
//		driver.findElement(By.xpath("(//b[contains(text(),'Remove Employee from this PMS Cycle')])[2]"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
		Thread.sleep(1000);
	}
	
	
   void ResetEmpAssesmet() throws InterruptedException 
   {
	   driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]/b")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();
	   Thread.sleep(1000);
	   RemoveEmp();
   }
   
   void ResetManagerAssessment() throws InterruptedException
   {
	   
	   driver.findElement(By.xpath("//a[@ng-click=\"resetMangerAssessment(pp.reviewCycleId,pp.employeeId)\"]//b")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();
	   RemoveEmp();
	   
   }
   
   
   
   
}

