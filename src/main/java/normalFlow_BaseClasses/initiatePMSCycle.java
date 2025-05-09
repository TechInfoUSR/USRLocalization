package normalFlow_BaseClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class initiatePMSCycle 
{

	    private WebDriver driver;
	    private Properties prop;

	    // Locators for elements on the PMSCycleDetailsPage
	    private By tabWeightTab = By.xpath("//a[@data-toggle='tab' and @href='#sectionWeightTab']");
	    private By addNewRowLink = By.xpath("//a[@ng-click=\"addNewRow = true\"]");
	    private By selectGroupDropdown = By.xpath("//span[@id=\"select2-chosen-2\"]");
	    private By groupSearchField = By.xpath("//input[@id=\"s2id_autogen2_search\"]");
//	    private By groupOption = By.xpath("//div[contains(text(),'{{group}}')]");
	    private By objectiveWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.objectiveWeightage\"]");
	    private By coreValueWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.coreValueWeightage\"]");
	    private By jobCompetencyWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.jobCompetencyWeightage\"]");
	    private By behaviorWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.behaviorWeightage\"]");
	    private By leadershipWeightageField = By.xpath("//input[@ng-model=\"newEligibleGroup.leadershipWeightage\"]");
	    private By insertButton = By.xpath("//a[contains(text(),'Insert')]");
	    private By initiateReviewCycleButton = By.xpath("//*[@class='btn btn-default btn-xs' and @ng-click='initiateReviewCycleForGroup(eg.weightageGroupId)']");
	    private By okButton = By.xpath("//button[contains(text(),'OK')]");

	    public initiatePMSCycle(WebDriver driver, Properties prop) 
	    {
	        this.driver = driver;
	        this.prop = prop;
	    }

	    
	    public void goToWeightTab(String group, String AddPMSCyle) throws InterruptedException 
	    {
	    	driver.findElement(By.xpath("//span[contains(text(),'"+AddPMSCyle+"')]")).click();
//			Thread.sleep(1000);
	        driver.findElement(tabWeightTab).click();
//	        Thread.sleep(500);
	        driver.findElement(addNewRowLink).click();
//	        Thread.sleep(500);
	        driver.findElement(selectGroupDropdown).click();
	        driver.findElement(groupSearchField).sendKeys(group);
//	        Thread.sleep(500);
	        driver.findElement(By.xpath("//div[contains(text(),'"+group+"')]")).click();
//	        Thread.sleep(2000);

	    }
//	    public void enterWeightages(String objective, String coreValue, String jobCompetency, String behavior, String leadership) throws InterruptedException 
	    public void enterWeightages() throws InterruptedException 
	    {
	        driver.findElement(objectiveWeightageField).sendKeys("100");
	        driver.findElement(coreValueWeightageField).sendKeys("0");
	        driver.findElement(jobCompetencyWeightageField).sendKeys("0");
	        driver.findElement(behaviorWeightageField).sendKeys("0");
	        driver.findElement(leadershipWeightageField).sendKeys("0");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement InsertBTN = wait.until(ExpectedConditions.elementToBeClickable(insertButton));
	       InsertBTN.click();
	       WebElement initReviewCycleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(initiateReviewCycleButton));
	       initReviewCycleButton.click();
	       WebElement OkBTN = wait.until(ExpectedConditions.elementToBeClickable(okButton));
	       OkBTN.click();
	       
	    }
	    //Not working due to a minor bug
	    public boolean isCycleInitiated() throws InterruptedException 
	    {
//	    	 driver.findElement(By.xpath("//td[contains(text(),'"+GoalPalnName+"')and @class=\"ng-binding\"]")).isDisplayed();
	    	 return driver.findElement(By.xpath("//tr[@class=\"ng-scope\"]")).isDisplayed();
		       
	    }
	    
	}
