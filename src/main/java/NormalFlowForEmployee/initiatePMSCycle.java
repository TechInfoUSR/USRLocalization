package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
			Thread.sleep(1000);
	        driver.findElement(tabWeightTab).click();
	        Thread.sleep(500);
	        driver.findElement(addNewRowLink).click();
	        Thread.sleep(500);
	        driver.findElement(selectGroupDropdown).click();
	        driver.findElement(groupSearchField).sendKeys(group);
	        Thread.sleep(500);
	        driver.findElement(By.xpath("//div[contains(text(),'"+group+"')]")).click();
	        Thread.sleep(2000);

	    }

	    public void enterWeightages(String objective, String coreValue, String jobCompetency, String behavior, String leadership) throws InterruptedException 
	    {
	        driver.findElement(objectiveWeightageField).sendKeys(objective);
	        driver.findElement(coreValueWeightageField).sendKeys(coreValue);
	        driver.findElement(jobCompetencyWeightageField).sendKeys(jobCompetency);
	        driver.findElement(behaviorWeightageField).sendKeys(behavior);
	        driver.findElement(leadershipWeightageField).sendKeys(leadership);

	        driver.findElement(insertButton).click();
	    	Thread.sleep(5000);
	        driver.findElement(initiateReviewCycleButton).click();
	        Thread.sleep(2000);
	        driver.findElement(okButton).click();
	        Thread.sleep(6000);
	        
	    }
	    //Not working due to a minor bug
	    public boolean isCycleInitiated(String GoalPalnName) throws InterruptedException 
	    {
	    	return driver.findElement(By.xpath("//td[contains(text(),'"+GoalPalnName+"')and @class=\"ng-binding\"]")).isDisplayed();
	    }
	    
	}
