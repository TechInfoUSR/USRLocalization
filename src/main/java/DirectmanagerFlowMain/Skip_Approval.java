package DirectmanagerFlowMain;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Skip_Approval
{

	   private WebDriver driver;
       private Properties prop;
       public Skip_Approval(WebDriver driver, Properties prop)
       {
           this.driver = driver;
           this.prop = prop;
       }
	
	public void approve() throws InterruptedException 
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class=\"approval\"]")).click();
		Thread.sleep(1000);
		String cycleName = prop.getProperty("GoalPalnName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdownToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='dropdown-toggle']")));
	    dropdownToggle.click();

	    WebElement cycleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + cycleName + "')]")));
	    cycleElement.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-if=\"currentSelectedStatus == reportStatusConst[0]\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id=\"approveSelectedUnapprovedReviews\"]")).click();
		Thread.sleep(1000);


	    driver.findElement(By.xpath("//textarea[@name=\"comment\"][1]")).sendKeys("Skip CMT");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@class=\"mr-1\"][1]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@ng-click=\"submitApprovalForAssessment()\"]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
	    Thread.sleep(500);
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
    
	  public String isSelfsub() throws InterruptedException {
		  
		 return driver.findElement(By.xpath("//div[contains(text(),'Submitted successfully')]")).getText();
	  }
}
