package ManagerTestPage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import MnagerPages.managerHomePage;

public class managertestHomePage {
	

	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	managertestHomePage managertestHomePage;
	managerHomePage managerHomePage;

	@BeforeTest
	public void setup() {
		cp = new ConfigpropReader();
		prop = cp.initLangProp("english");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("MgrUsername"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("MgrPassword"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
		
		managerHomePage = new managerHomePage(driver);
		
	}

	@Test (priority = 1)
	public void MgrGoalPlan() {
		Assert.assertTrue(managerHomePage.isMgrGoalPlanExist(prop.getProperty("MgrGoalPlan")));
	}
	@Test(priority = 2)
	public void MgrOverallPMSReport() {
		Assert.assertTrue(managerHomePage.isMgrOverallPMSReport(prop.getProperty("MgrOverallPMSReport")));
	}
	@Test(priority = 3)
	public void MgrTeamIDPs() {
		Assert.assertTrue(managerHomePage.isMgrTeamIDPs(prop.getProperty("MgrTeamIDPs")));
	}
	
	@Test(priority = 4)
	public void MgrBellcurve() {
		Assert.assertTrue(managerHomePage.isMgrBellcurve(prop.getProperty("MgrBellcurve")));
	}
	
	@Test(priority = 5)
	public void MgrGapAnalysis() {
		Assert.assertTrue(managerHomePage.isMgrGapAnalysis(prop.getProperty("MgrGapAnalysis")));
	}
	@Test(priority = 6)
	public void MgrCumulativeReports() {
		Assert.assertTrue(managerHomePage.isMgrCumulativeReports(prop.getProperty("MgrCumulativeReports")));
	}
	@Test(priority = 7)
	public void MgrMyTeamsPMSworkflowcompletedstatus() {
		Assert.assertTrue(managerHomePage.isMgrMyTeamsPMSworkflowcompletedstatus(prop.getProperty("MgrMyTeamsPMSworkflowcompletedstatus")));
	}
	@Test(priority = 8)
	public void MgrSKIPLEVELREVIEW() {
		Assert.assertTrue(managerHomePage.isMgrSKIPLEVELREVIEW(prop.getProperty("MgrSKIPLEVELREVIEW")));
	}
	@Test(priority = 9)
	public void YETTOSUBMIT() {
		Assert.assertTrue(managerHomePage.isMgrYETTOSUBMIT(prop.getProperty("MgrYETTOSUBMIT")));
	}
	@Test(priority = 10)
	public void MgrSUBMITTEDUNDERAUTHORIZATION() {
		Assert.assertTrue(managerHomePage.isMgrSUBMITTEDUNDERAUTHORIZATION(prop.getProperty("MgrSUBMITTEDUNDERAUTHORIZATION")));
	}
	@Test(priority = 11)
	public void MgrAPPROVED() {
		Assert.assertTrue(managerHomePage.isMgrAPPROVED(prop.getProperty("MgrAPPROVED")));
	}
	@Test(priority = 12)
	public void MgrREJECTED() {
		Assert.assertTrue(managerHomePage.isMgrREJECTED(prop.getProperty("MgrREJECTED")));
	}
	@Test(priority = 13)
	public void MgrTotalReviewCycleInitiated() {
		Assert.assertTrue(managerHomePage.isMgrTotalReviewCycleInitiated(prop.getProperty("MgrTotalReviewCycleInitiated")));
	}
	@Test(priority = 14)
	public void MgrGoalsApproved() {
		Assert.assertTrue(managerHomePage.isMgrGoalsApproved(prop.getProperty("MgrGoalsApproved")));
	}
	@Test(priority = 15)
	public void MgrEmployeeSelfReview() {
		Assert.assertTrue(managerHomePage.isMgrEmployeeSelfReview(prop.getProperty("MgrEmployeeSelfReview")));
	}
	@Test(priority = 16)
	public void MgrManagerReview() {
		Assert.assertTrue(managerHomePage.isMgrManagerReview(prop.getProperty("MgrManagerReview")));
	}
	@Test(priority = 17)
	public void SelectEmp() {
		Assert.assertTrue(managerHomePage.isSelectEmp(prop.getProperty("MgrSelectEmp")));
		String xpathExpression = prop.getProperty("MgrSelectEmp");
		driver.findElement(By.xpath("//span[contains(text(),"+xpathExpression+")]")).click();
	}
	@Test(priority = 17)
	public void OverallPMSReport() {
		driver.findElement(By.xpath("//a[contains(text(),\"Overall PMS Report\")]")).click();
		Assert.assertTrue(managerHomePage.isOverallPMSReport(prop.getProperty("EmployeeID")));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
}
