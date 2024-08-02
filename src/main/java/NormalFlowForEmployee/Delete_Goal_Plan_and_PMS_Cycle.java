package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Delete_Goal_Plan_and_PMS_Cycle {

    WebDriver driver;
    Properties prop;
    
    public Delete_Goal_Plan_and_PMS_Cycle(WebDriver driver, Properties prop) 
    {
        this.driver = driver;
        this.prop = prop;
    }
	public void DeletionPMSCycle() throws InterruptedException 
	{
		String AddPMSCyle = prop.getProperty("GoalPalnName");
		JavascriptExecutor Srollup = (JavascriptExecutor) driver;
        Srollup.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[contains(text(),'Performance Review Cycle Management')]")).click();
		String cyclename = driver.findElement(By.xpath("//span[contains(text(),'"+AddPMSCyle+"')]")).getText();
		
		
		WebElement spanElement = driver.findElement(By.xpath("//span[text()='"+AddPMSCyle+"']"));

		 WebElement tdElement = driver.findElement(By.xpath("//td[a/span[text()='four of them']]"));

	        // Locate the <a> tag button within the same <td> element
	        WebElement buttonElement = tdElement.findElement(By.xpath(".//a[@id='btnDeleteRow']"));


	        // Print the value
	        System.out.println("Value of the <td> element with class 'sorting_1': " + buttonElement);

	}
	
	
	public void DeletionGoalPlan() 
	{
		
		
	}
} 
