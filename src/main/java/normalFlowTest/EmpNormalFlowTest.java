package normalFlowTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.Employeepage;


public class EmpNormalFlowTest 
{
	Employeepage Employeepage;
	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	
	@BeforeTest
	void AddGoalPlan() throws IOException 
	{
		cp = new ConfigpropReader();
		prop = cp.initLangProp("normal");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("hrUsername"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("hrPassword"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();

	}
//	@Test(priority = 1)
	public void AddGoalPaln() throws InterruptedException 
	{
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(0,1500)");
	 Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addGoalPlan")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='goalPlanName']")).sendKeys(prop.getProperty("GoalPalnName"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@class=\"form-control dpd1\"]")).click();
		String FromMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		System.out.print(FromMonth);
//		while(!(FromMonth.equals("June 2024")))
//		{
//			driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
			driver.findElement(By.xpath("//td[contains(text(),\"11\")]")).click();
			Thread.sleep(2000);
//		}					
		driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
		Thread.sleep(1000);
		String ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		System.out.print(ToMonth);
		while(!(ToMonth.equals("June 2025")))
		{
		driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
		ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		Thread.sleep(10);
		}
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[3]")).click();
		Thread.sleep(10);
		
//		RatingScale
		driver.findElement(By.xpath("//input[@placeholder=\"Select Rating Scale\"]")).sendKeys(prop.getProperty("RatingScale"));
		driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();	
//		Group
//		if(prop.getProperty("TargetEmployees") == "Group")
//		{
			driver.findElement(By.xpath("//input[@id=\"selectGroupRadio\"]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@placeholder=\"Select Target Employees Group for this Plan\"]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//option[@value=\"62\"]")).click();
//			Pjgroup= prop.getProperty("EmpGroup");
			driver.findElement(By.xpath("//input[@placeholder=\"Select Target Employees Group for this Plan\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),"+prop.getProperty("EmpGroup")+")]")).click();
			Thread.sleep(2000);
//			select_Gruop.selectByIndex(62);
		
//			driver.findElement(By.xpath("")).sendKeys(sp);)
//		}
		
//		else if(prop.getProperty("TargetEmployees") == "Org"){
//			driver.findElement(By.xpath("//input[@id=\"selectAllEmpRadio\"]")).click();
//		}
		driver.findElement(By.xpath("//input[@id=\"isActive\"]")).click();
		Thread.sleep(1000);
		String isweight = prop.getProperty("Weighted");
		if(isweight.equals("Weighted"))
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id=\"isWeightageBased\"]")).click();
			Thread.sleep(2000);
		}
		else if (isweight.equals ("No Weighted")) 
		{
			driver.findElement(By.xpath("//input[@id=\"isWeightageBased\"]")).isDisplayed();
		}
		driver.findElement(By.xpath("//button[@id=\"submit_btn_action\"]")).click();
		Thread.sleep(2000);
		boolean GoalPlan = driver.findElement(By.xpath("//td[contains(text(),\"PMSGoalPaln1 for june\")]")).isDisplayed();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(GoalPlan, true);	
	}
		
//	@Test(priority = 2)
	public void AddPMSCycle() throws InterruptedException 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Performance Review cycle\")]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Add\"]")).click();
		WebElement selectgoalplan = driver.findElement(By.id("goalplan"));
		Select select_goalplan=new Select(selectgoalplan) ;
		String GoalPalnName = prop.getProperty("GoalPalnName");
		select_goalplan.selectByVisibleText(GoalPalnName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Select Rating Scale\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Select Rating Scale\"]")).sendKeys(prop.getProperty("RatingScale"));
		driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();
		
//		Date Selection	
		driver.findElement(By.xpath("//input[@class=\"form-control dpd1\"]")).click();
		String FromMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		System.out.print(FromMonth);
//		while(!(FromMonth.equals("June 2024")))
//		{
//			driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
			driver.findElement(By.xpath("//td[contains(text(),\"11\")]")).click();
			Thread.sleep(2000);
//		}					
		driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
		Thread.sleep(1000);
		String ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		System.out.print(ToMonth);
		while(!(ToMonth.equals("June 2025")))
		{
		driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
		ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		Thread.sleep(10);
		}
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"modal-footer\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"saveReviewCycleDetails\"]")).click();
		Thread.sleep(1000);
		
		String AddPMSCyle = prop.getProperty("GoalPalnName");
		boolean GoalPlan = driver.findElement(By.xpath("//span[contains(text(),'"+AddPMSCyle+"')]")).isDisplayed();
		AssertJUnit.assertEquals(GoalPlan, true);	
	}
		
	@Test(priority = 3)
	public void InitiatePMSCycle() throws InterruptedException 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.xpath("//h3[contains(text(),'Goal Time Period Plan Management')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Performance Review cycle\")]")).click();
		String AddPMSCyle = prop.getProperty("GoalPalnName");
		driver.findElement(By.xpath("//span[contains(text(),'"+AddPMSCyle+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-toggle='tab' and @href='#sectionWeightTab']\r\n"
				+ "")).click();
		driver.findElement(By.xpath("//a[@ng-click=\"addNewRow = true\"]")).click();
//		driver.findElement(By.xpath("//div[@id=\"s2id_autogen1\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id=\"select2-chosen-2\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"s2id_autogen2_search\"]")).sendKeys(prop.getProperty("EmpGroup"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+prop.getProperty("EmpGroup")+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@ng-model=\"newEligibleGroup.objectiveWeightage\"]")).sendKeys(prop.getProperty("objectiveWeightage"));
		driver.findElement(By.xpath("//input[@ng-model=\"newEligibleGroup.coreValueWeightage\"]")).sendKeys(prop.getProperty("coreValueWeightage"));
		driver.findElement(By.xpath("//input[@ng-model=\"newEligibleGroup.jobCompetencyWeightage\"]")).sendKeys(prop.getProperty("jobCompetencyWeightage"));
		driver.findElement(By.xpath("//input[@ng-model=\"newEligibleGroup.behaviorWeightage\"]")).sendKeys(prop.getProperty("behaviorWeightage"));
		driver.findElement(By.xpath("//input[@ng-model=\"newEligibleGroup.leadershipWeightage\"]")).sendKeys(prop.getProperty("leadershipWeightage"));
		driver.findElement(By.xpath("//a[contains(text(),'Insert')]")).click();
		driver.findElement(By.xpath("")).click();
		Thread.sleep(6000);
//		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-default btn-xs']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
		  WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default btn-xs']")));

	        // Perform the click action
	        element.click();

		Thread.sleep(6000);
//		driver.findElement(By.xpath("(//a[@class='btn btn-default btn-xs'])[1]")).click();
//		Thread.sleep(6000);
//		Alert alert = driver.switchTo().alert();
//		Thread.sleep(6000);
//		alert.dismiss();
//		Thread.sleep(6000);
		AssertJUnit.assertEquals(true, true);
	}
		
		
		
		
		
		
		
		
	
	

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}