package NormalFlowForEmployee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import Utils.ElementUtil;
import normalFlowTest.EmpNormalFlowTest;

public class employeepage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	Properties prop;
	employeepage Employeepage;
	DriverFactory df;
	ConfigpropReader cp;

	
//	 WebDriver driver;
//     addGoalPla_CreatePMSCycle addGoalPla_CreatePMSCycle;
	
	public employeepage(WebDriver driver)
    {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

		     @BeforeClass
		     public void setup() {
		    	 cp = new ConfigpropReader();
		 		prop = cp.initLangProp("normal");
		 		df = new DriverFactory();
		 		driver = df.initDriver("chrome", prop);
		 		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("hrUsername"));
		 		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("hrPassword"));
		 		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
		     }

		     @Test(priority = 1)
		     public void addGoalPlan() throws InterruptedException {
		         // Add the goal plan
//		         boolean isGoalPlanAdded = EmpNormalFlowTest.AddGoalPaln(prop.getProperty("GoalPlanName"));

		         // Assert the goal plan was added successfully
//		         Assert.assertTrue(isGoalPlanAdded, "The goal plan was not added successfully.");
		     }

		     @AfterClass
		     public void teardown() 
		     {
		         if (driver != null) 
		         {
		             driver.quit();
		         }
		     }
		 

	}
	
