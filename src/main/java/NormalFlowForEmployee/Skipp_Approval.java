package NormalFlowForEmployee;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Skipp_Approval 
{

	   private WebDriver driver;
       private Properties prop;
       public Skipp_Approval(WebDriver driver, Properties prop) 
       {
           this.driver = driver;
           this.prop = prop;
       }
	
	public void approve() throws InterruptedException 
	{
		driver.findElement(By.xpath("//a[@class=\"approval\"]")).click();
		
		String cycleName = prop.getProperty("GoalPalnName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdownToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='dropdown-toggle']")));
	    dropdownToggle.click();

	    WebElement cycleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + cycleName + "')]")));
	    cycleElement.click();

//	    String empname = prop.getProperty("empname");
//	    if (empname != null && !empname.isEmpty()) {
//	        WebElement empElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + empname + " ')]")));
//	        empElement.click();
//	    } else {
//	        throw new IllegalArgumentException("Employee name property is not set or empty.");
//	    }
		
	    Random random = new Random();
    	int randomNumber = random.nextInt(100) + 1;
    	
	    updateProgressBar(driver, "(//input[@type=\"range\"])[5]", randomNumber);

	    driver.findElement(By.xpath("//textarea[@id=\"goal_checkin_commentsa_ULJyebT3Gn6gwh7fiqcK5g\"]")).sendKeys("Skip CMT");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class=\"mr-1\"][1]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@ng-click=\"submitApprovalForAssessment()\"]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
	    Thread.sleep(2000);
	}
	
	
    private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) 
    {  
  	  WebElement rangeInput = driver.findElement(By.xpath(cssSelector)); 
      JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
      String script = "arguments[0].value = arguments[1];" +
                      "arguments[0].dispatchEvent(new Event('change'));";
      jsExecutor.executeScript(script, rangeInput, progress);
      WebElement progressText = driver.findElement(By.cssSelector(".risk"));
      jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));



  }
}
