package Mytestpackage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
	@Test(priority= 1)
	public void Organization() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(text(),'ADD NEW KRA')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@data-target='#second']")).click();
		Thread.sleep(5000);
		WebElement selectlevel = driver.findElement(By.id("selectlevel"));
		Select level_select=new Select(selectlevel) ;
		String xpathExpression = prop.getProperty("EmpOrganization");
		 level_select.selectByVisibleText(xpathExpression);
		Assert.assertTrue(dropDowns.isEmpOrganization(prop.getProperty("EmpOrganization")));
	}
	@Test(priority= 2)
	public void Personalgoal() throws InterruptedException {
		Thread.sleep(6000);
		WebElement selectlevel = driver.findElement(By.id("selectlevel"));
		Select level_select=new Select(selectlevel) ;
		String xpathExpression = prop.getProperty("EmpPersonalgoal");
		 level_select.selectByVisibleText(xpathExpression);
		Assert.assertTrue(dropDowns.isEmpPersonalgoal(prop.getProperty("EmpPersonalgoal")));
	}
	@Test(priority= 3)
	public void isEmpDepartment() throws InterruptedException {
		Thread.sleep(6000);
		WebElement selectlevel = driver.findElement(By.id("selectlevel"));
		Select level_select=new Select(selectlevel) ;
		String xpathExpression = prop.getProperty("EmpDepartment");
		 level_select.selectByVisibleText(xpathExpression);
		 Thread.sleep(3000);
		Assert.assertTrue(dropDowns.isEmpDepartment(prop.getProperty("EmpDepartment")));
	}
	
	
	@Test(priority= 4)
	public void Manualupdate() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"tab_default_11\"]/form/div[4]/div[1]/div[1]/div[1]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(@id,\"select2-connectionId-container\")]")).click();
		Thread.sleep(6000);
		String xpathExpression = prop.getProperty("Manualupdate");
		driver.findElement(By.xpath("//li[contains(text(),"+xpathExpression+")] ")).click();
		Thread.sleep(6000);
		Assert.assertTrue(dropDowns.isManualupdate(prop.getProperty("Manualupdate")));
		Thread.sleep(6000);
	}
	@Test(priority= 5)
	public void Manualandaverage() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@id,\"select2-connectionId-container\")]")).click();
		
		String xpathExpression = prop.getProperty("Manualandaverage");
		driver.findElement(By.xpath("//li[contains(text(),"+xpathExpression+")] ")).click();
		Thread.sleep(6000);
		Assert.assertTrue(dropDowns.isManualandaverage(prop.getProperty("Manualandaverage")));
		Thread.sleep(6000);
	}
	@Test(priority= 6)
	public void Manualandweightedaveragefromkeyresults() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(@id,\"select2-connectionId-container\")]")).click();
		Thread.sleep(6000);
		String xpathExpression = prop.getProperty("Manualandweightedaveragefromkeyresults");
		driver.findElement(By.xpath("//li[contains(text(),"+xpathExpression+")] ")).click();
		Thread.sleep(6000);
		Assert.assertTrue(dropDowns.isManualandweightedaveragefromkeyresults(prop.getProperty("Manualandweightedaveragefromkeyresults")));
		Thread.sleep(6000);
	}
	@Test(priority= 7)
	public void Manualandsummationfromkeyresults() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(@id,\"select2-connectionId-container\")]")).click();
		Thread.sleep(6000);
		String xpathExpression = prop.getProperty("Manualandsummationfromkeyresults");
		driver.findElement(By.xpath("//li[contains(text(),"+xpathExpression+")] ")).click();
		Thread.sleep(6000);
		Assert.assertTrue(dropDowns.isManualandsummationfromkeyresults(prop.getProperty("Manualandsummationfromkeyresults")));
		Thread.sleep(6000);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
