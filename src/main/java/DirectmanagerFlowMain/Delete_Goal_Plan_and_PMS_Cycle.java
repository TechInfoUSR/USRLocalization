package DirectmanagerFlowMain;

import java.util.List;
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
		JavascriptExecutor Srollup = (JavascriptExecutor) driver;
		Srollup.executeScript("window.scrollBy(0,1800)");

		WebElement PMS=driver.findElement(By.xpath("(//h3[contains(text(),'Performance Review Cycle Management')])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", PMS);


		PMS.click();
		String GoalPlanName = prop.getProperty("GoalPalnName");
		WebElement tbody = driver.findElement(By.cssSelector("tbody[role='alert']"));

		// Find all <tr> elements within the <tbody>
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		// Get the count of <tr> elements
		int rowCount = rows.size();
		System.out.println("Number of rows in the table: " + rowCount);


		for (int i = 1;i<=rowCount ;i++)
		{
			String test=driver.findElement(By.xpath("//tr["+i+"]//span[contains(text(),'"+GoalPlanName+"')]")).getText();
			if(test.equals(GoalPlanName))
			{
				System.out.println(test);
				driver.findElement(By.xpath("//tr["+i+"]//a[@title=\"Delete\"]")).click();
				driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
				break;
			}
		}


	}


	public void DeletionGoalPlan() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Goal Plan')]")).click();
		String GoalPlanName = prop.getProperty("GoalPalnName");
		WebElement tbody = driver.findElement(By.cssSelector("tbody[role='alert']"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		int rowCount = rows.size();
		System.out.println("Number of rows in the table: " + rowCount);


		for (int i = 1;i<=rowCount ;i++)
		{
			String test=driver.findElement(By.xpath("//tr["+i+"]//td[contains(text(),'"+GoalPlanName+"')]")).getText();
			System.out.println(test);
			if(test.equals(GoalPlanName))
			{
				System.out.println(test);
				driver.findElement(By.xpath("//tr["+i+"]//a[@title=\"Delete\"]")).click();
				driver.findElement(By.xpath("//button[@data-bb-handler=\"confirm\"]")).click();
				Thread.sleep(500);
				break;
			}

		}


	}
	public boolean isPMSDeleted() throws InterruptedException {

		return driver.findElement(By.xpath("//div[contains(text(),'Performance Review Cycle deleted successfully ')]")).isDisplayed();
	}
	public boolean isGoalPlanDeleted() throws InterruptedException {

		return driver.findElement(By.xpath("//div[contains(text(),'Selected Goal Plan/PMS Cycle is deleted successfully ')]")).isDisplayed();

	}
} 
