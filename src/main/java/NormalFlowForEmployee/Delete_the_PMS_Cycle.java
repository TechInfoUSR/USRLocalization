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
    ExplicitWait ExplicitWait;
    
    public Delete_the_PMS_Cycle(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }
public void Deletion() throws InterruptedException {
	
    String goal = prop.getProperty("GoalPalnName");
    JavascriptExecutor Srollup = (JavascriptExecutor) driver;
    Srollup.executeScript("window.scrollBy(0,1800)");
    driver.findElement(By.xpath("//h3[contains(text(),'PMS Program Management')][1]")).click();
    WebElement drop = driver.findElement(By.xpath("//select[@ng-model=\"encReviewCycleId\"]"));
    Select S = new Select(drop);
    S.selectByVisibleText(goal);
    
    
    By tableRows1 = By.xpath("//table[@class='table table-striped']//tr[@ng-repeat=\"pp in allProgressData | filter:{employeeName: searchEmployeeName}\"]");
    WebElement Is_tableRows = ExplicitWait.waitUntillClickable(tableRows1);
    Is_tableRows.isDisplayed();
    
    List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr[@ng-repeat=\"pp in allProgressData | filter:{employeeName: searchEmployeeName}\"]"));
    
    // Count the number of rows
    int rowCount = tableRows.size();
    System.out.println("Number of rows: " + rowCount);
//    Thread.sleep(2000);
    for(int i=1;i<=rowCount;i++) 
    {
   	
    	driver.findElement(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]")).click();   	     
    	String actualText = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr[1]/td[1]/div/ul[2]/li/a/b")).getText();
	    System.out.println(actualText);
	    String actualText1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[2]/a/b")).getText();
	    System.out.println(actualText1);
	    String ResetEmpAssesmet = driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr[1]/td[1]/div/ul[2]/li/a")).getText();
	    System.out.println(ResetEmpAssesmet);
	    
	    String RE_Assessment = "Remove Employee from this PMS Cycle";
	    String RM_Assessment = "Reset Manager's Assessment (without deleting contents filled already by emp. and manager)";

//	    String ResetAct = "Reset Employee's Assessment (without deleting contents filled already by emp.)";
		String RemoveEMP = "Reset Employee's Assessment ";

		
	    if(actualText.equals(RE_Assessment)) 
	     {
    		
	    	 RemoveEmp();
    	 }
	     else if(actualText1.equals(RM_Assessment)) 
	     {
	    	 System.out.println("ResetManagerAssessment");
	    	 ResetManagerAssessment();
	     }
	     else if(ResetEmpAssesmet.equals(RemoveEMP)) 
	     {
	    	 System.out.println("ResetEmpAssesmet");
	    	 ResetEmpAssesmet();
	     }
    	
 }
    
	}

	void RemoveEmp() throws InterruptedException 
	{
		By EMPicon = By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]");
	       JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	       jsExecutor.executeScript("arguments[0].scrollIntoView(true);", EMPicon);
		driver.findElement(EMPicon).click();

		By OKBTN = By.xpath("//button[@data-bb-handler=\"confirm\"]");
		WebElement BTN = ExplicitWait.waitForElementVisiblity(OKBTN);
		BTN.click();
	}
	
	
   void ResetEmpAssesmet() throws InterruptedException 
   {   
	   By section = (By.xpath("//b[contains(text(),\"Reset Employee's Assessment \")]"));
	   WebElement sectionBTN = ExplicitWait.waitUntillClickable(section);
       sectionBTN.click();
//       driver.findElement(By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div[2]/table/tbody/tr[1]/td[1]/div/ul[1]/li[1]/a[2]/b")).click();


       By confirm =(By.xpath("//button[@data-bb-handler=\"confirm\"]"));
	   WebElement confirmBTN = ExplicitWait.waitUntillClickable(confirm);
	   confirmBTN.click();
	   
	   By images =(By.xpath("//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"][1]"));
	   WebElement imagesBTN = ExplicitWait.waitUntillClickable(images);
	   imagesBTN.click();
	   
	   RemoveEmp();
   }
   
   void ResetManagerAssessment() throws InterruptedException
   {
       By is = (By.xpath("//a[@ng-click=\"resetAppraisal(pp.reviewCycleId,pp.employeeId,true,2)\"]//b"));
	   WebElement element = ExplicitWait.waitUntillClickable(is);
       element.click();

       By Confirm = (By.xpath("//button[@data-bb-handler=\"confirm\"]"));
       WebElement ConfirmBTN = ExplicitWait.waitUntillClickable(Confirm);
       ConfirmBTN.click();  
       
       By images = (By.xpath("(//div[@style=\"text-align:left;position:absolute;\"]//img[@src=\"asssets/media/images/plasticine/40/000000/serial-tasks.png\"])[1]"));
       WebElement imagesBTN = ExplicitWait.waitUntillClickable(images);
       imagesBTN.click();

       By section = (By.xpath("/html/body/div/div[5]/div/div/div/div[2]/div/section/div[2]/b/div/table/tbody/tr/td[1]/div/ul[1]/li[1]/a[2]"));   
       WebElement OKBTN = ExplicitWait.waitUntillClickable(section);
       OKBTN.click();

       
       WebElement ConfirmBTN1 = ExplicitWait.waitUntillClickable(Confirm);
       ConfirmBTN1.click(); 
       
       WebElement imagesBTN1 = ExplicitWait.waitUntillClickable(images);
	   imagesBTN1.click();
	   
	   RemoveEmp();
	   
   }
	  public boolean isDeleted() throws InterruptedException {

		 return driver.findElement(By.xpath("//span[contains(text(),'0-1000 of 0')]")).isDisplayed();
	  }
}
