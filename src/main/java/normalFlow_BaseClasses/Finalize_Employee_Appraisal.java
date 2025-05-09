package normalFlow_BaseClasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finalize_Employee_Appraisal 
{
    private WebDriver driver;
    private Properties prop;
    
    private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");
//    private By employeeName = By.xpath("//span[contains(text(),'Ranganath ')]");
    private By goalCycleLink(String cycleName) 
    {
        return By.xpath("//a[contains(text(),'" + cycleName + "')]");
    }
    public Finalize_Employee_Appraisal(WebDriver driver, Properties prop) 
    {
        this.driver = driver;
        this.prop = prop;
    }

    
    
    
    public void selectGoalCycle(String cycleName) throws InterruptedException 
    {
        driver.findElement(dropdownToggle).click();
//        Thread.sleep(2000);
        driver.findElement(goalCycleLink(cycleName)).click();
//        Thread.sleep(1000);
    }
    public void navigateToEmployeeSelf() throws InterruptedException {
        
    	String employeeName= prop.getProperty("empname");
        driver.findElement(By.xpath("//span[contains(text(),'"+employeeName+"')]")).click();
    	
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@class=\"form-control finalize_appraisal_meeting\"][1]")).sendKeys("5% Hike will be provided");
//        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[contains(text(),'Finalize Employee Appraisal')])[1]")).click();
//        Thread.sleep(5000);
    }
    public String isSelfsub() throws InterruptedException {
//		  Thread.sleep(4000);
		 return driver.findElement(By.xpath("//span[contains(text(),'Finalized')]")).getText();
	  }
}
