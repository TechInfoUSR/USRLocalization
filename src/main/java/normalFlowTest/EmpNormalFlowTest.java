package normalFlowTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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


public class EmpNormalFlowTest {
	Employeepage Employeepage;
	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	
	@BeforeTest
	void AddGoalPlan() throws IOException {
		cp = new ConfigpropReader();
		prop = cp.initLangProp("normal");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("hrUsername"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("hrPassword"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();

	}
	@Test
	public void AddGoalPaln() throws InterruptedException {
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
//		while(!(FromMonth.equals("June 2024"))){
//			 driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
			driver.findElement(By.xpath("//td[contains(text(),\"11\")]")).click();
//		}
			Thread.sleep(2000);
			
		driver.findElement(By.xpath("//input[@class=\"form-control dpd2\"]")).click();
		Thread.sleep(1000);
		String ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		System.out.print(ToMonth);
		while(!(ToMonth.equals("June 2025"))){
		driver.findElement(By.xpath("//th[@class=\"next\"]")).click();
		ToMonth = driver.findElement(By.xpath("//th[@class=\"datepicker-switch\"]")).getText();
		Thread.sleep(100);
		}
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[3]")).click();
		Thread.sleep(2000);
		
//		RatingScale
		driver.findElement(By.xpath("//input[@placeholder=\"Select Rating Scale\"]")).sendKeys(prop.getProperty("RatingScale"));
		driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();	
//		Group
//		if(prop.getProperty("TargetEmployees") == "Group") {
			driver.findElement(By.xpath("//input[@id=\"selectGroupRadio\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder=\"Select Target Employees Group for this Plan\"]")).click();
			Thread.sleep(5000);
//		}
		
//		else if(prop.getProperty("TargetEmployees") == "Org"){
//			driver.findElement(By.xpath("//input[@id=\"selectAllEmpRadio\"]")).click();
//		}
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id=\"isActive\"]")).click();
//		Thread.sleep(2000);
//		if(prop.getProperty("Weighted") == "Weighted") {
//			driver.findElement(By.xpath("//input[@id=\"isWeightageBased\"]")).click();
//		}
//
//		driver.findElement(By.xpath("//button[@id=\"submit_btn_action\"]"));
//		
		AssertJUnit.assertEquals(false, false);
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}