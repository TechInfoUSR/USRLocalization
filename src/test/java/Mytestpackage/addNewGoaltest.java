package Mytestpackage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import Pages.addNewGoal;

public class addNewGoaltest {
	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	addNewGoal addNewGoal;

	@BeforeTest
	public void setup() {
		cp = new ConfigpropReader();
		prop = cp.initLangProp("english");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'ADD NEW KRA')]")).click();
		
		addNewGoal = new addNewGoal(driver);
	}
	@Test(priority= 1)
	public void ADDNEWKRA() {
		Assert.assertTrue(addNewGoal.isADDNEWKRA(prop.getProperty("ADDNEWKRA")));
	}
	@Test(priority= 2)
	public void PersonalKRA() {
		Assert.assertTrue(addNewGoal.isPersonalKRA(prop.getProperty("PersonalKRA")));
	}
	@Test(priority= 3)
	public void OrgKRA() {
		Assert.assertTrue(addNewGoal.isOrgKRA(prop.getProperty("OrgKRA")));
	}
	@Test(priority= 4)
	public void SampleKRA() {
		Assert.assertTrue(addNewGoal.isSampleKRA(prop.getProperty("SampleKRA")));
	}
	@Test(priority= 5)
	public void Upload() {
		Assert.assertTrue(addNewGoal.isupload(prop.getProperty("upload")));
	}
	@Test(priority= 6)
	public void Clone() {
		Assert.assertTrue(addNewGoal.isclone(prop.getProperty("Clone")));
	}
	@Test(priority= 7)
	public void AI() {
		Assert.assertTrue(addNewGoal.isAI(prop.getProperty("AI")));
	}
	@Test(priority= 7)
	public void KPI() {
		Assert.assertTrue(addNewGoal.isKPI(prop.getProperty("KPI")));
	}
	

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
