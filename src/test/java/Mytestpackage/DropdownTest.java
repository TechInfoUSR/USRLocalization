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
import Pages.dropDowns;

public class DropdownTest {
	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	dropDowns dropDowns;

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
		
		dropDowns = new dropDowns(driver);
	}
//	@Test(priority= 1)
	public void Organization() {
		Assert.assertTrue(dropDowns.isOrganization(prop.getProperty("Organization")));
	}
	@Test(priority= 2)
	public void Manualupdate() {
		Assert.assertTrue(dropDowns.isManualupdate(prop.getProperty("Manualupdate")));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
