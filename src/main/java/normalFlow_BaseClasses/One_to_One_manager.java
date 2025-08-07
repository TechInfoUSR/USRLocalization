package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class One_to_One_manager 
{
    private WebDriver driver;
    private Properties prop;
    
    public One_to_One_manager(WebDriver driver, Properties prop) 
    {
        this.driver = driver;
        this.prop = prop;
    }

    private By dropdownToggle = By.xpath("//a[@class='dropdown-toggle']");
    private By avatarIcon = By.xpath("//a[@class='avatar-sec header-icon']");   
    private By employeeName = By.xpath("//span[contains(text(),'Ranganath ')]");
    private By goalCycleLink(String cycleName) 
    {
        return By.xpath("//a[contains(text(),'" + cycleName + "')]");
    }


    public void selectGoalCycle(String cycleName) throws InterruptedException 
    {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
  	    By section = dropdownToggle;
  	    WebElement dropdownToggle = wait.until(ExpectedConditions.visibilityOfElementLocated(section));
  	    dropdownToggle.click();
  	    
  	    By cycleName_sa = (goalCycleLink(cycleName));
  	    WebElement cycleNameBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(cycleName_sa));
  	    cycleNameBTN.click();

    }
    
    public void navigateToEmployeeSelf() throws InterruptedException 
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	String employeeName= prop.getProperty("empname");
  	    By section = (By.xpath("//span[contains(text(),'"+employeeName+"')]"));
  	    WebElement sectionBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(section));
  	    sectionBTN.click();

  	    By sendKeys = (By.xpath("(//textarea[@class=\"form-control one_to_one_meeting\"])[1]"));
  	    WebElement sendKeysBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(sendKeys));
  	    sendKeysBTN.sendKeys("1:1 meeting comment");

  	    By checkin = (By.xpath("(//a[@class=\"btn checkin-btn block-btn\"])[1]"));
  	    WebElement checkinBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(checkin));
  	    checkinBTN.click();

    }
    public String isSelfsub() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
  	    By section = (By.xpath("//div[contains(text(),'Submitted successfully')]"));
  	    WebElement sectionBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(section));

		return sectionBTN.getText();
	  }
    
}
