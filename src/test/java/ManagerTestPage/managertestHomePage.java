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

	@Test
	public void MgrGoalPlan() {
		Assert.assertTrue(managerHomePage.isMgrGoalPlanExist(prop.getProperty("MgrGoalPlan")));
	}
	@Test
	public void MgrOverallPMSReport() {
		Assert.assertTrue(managerHomePage.isMgrOverallPMSReport(prop.getProperty("MgrOverallPMSReport")));
	}
	@Test
	public void MgrTeamIDPs() {
		Assert.assertTrue(managerHomePage.isMgrTeamIDPs(prop.getProperty("MgrTeamIDPs")));
	}
	
	@Test
	public void MgrBellcurve() {
		Assert.assertTrue(managerHomePage.isMgrBellcurve(prop.getProperty("MgrBellcurve")));
	}
	
	@Test
	public void MgrGapAnalysis() {
		Assert.assertTrue(managerHomePage.isMgrGapAnalysis(prop.getProperty("MgrGapAnalysis")));
	}
	@Test
	public void MgrCumulativeReports() {
		Assert.assertTrue(managerHomePage.isMgrCumulativeReports(prop.getProperty("MgrCumulativeReports")));
	}
	@Test
	public void MgrMyTeamsPMSworkflowcompletedstatus() {
		Assert.assertTrue(managerHomePage.isMgrMyTeamsPMSworkflowcompletedstatus(prop.getProperty("MgrMyTeamsPMSworkflowcompletedstatus")));
	}
	@Test
	public void MgrSKIPLEVELREVIEW() {
		Assert.assertTrue(managerHomePage.isMgrSKIPLEVELREVIEW(prop.getProperty("MgrSKIPLEVELREVIEW")));
	}
	@Test
	public void YETTOSUBMIT() {
		Assert.assertTrue(managerHomePage.isMgrYETTOSUBMIT(prop.getProperty("MgrYETTOSUBMIT")));
	}
	@Test
	public void MgrSUBMITTEDUNDERAUTHORIZATION() {
		Assert.assertTrue(managerHomePage.isMgrSUBMITTEDUNDERAUTHORIZATION(prop.getProperty("MgrSUBMITTEDUNDERAUTHORIZATION")));
	}
	@Test
	public void MgrAPPROVED() {
		Assert.assertTrue(managerHomePage.isMgrAPPROVED(prop.getProperty("MgrAPPROVED")));
	}
	@Test
	public void MgrREJECTED() {
		Assert.assertTrue(managerHomePage.isMgrREJECTED(prop.getProperty("MgrREJECTED")));
	}
	@Test
	public void MgrTotalReviewCycleInitiated() {
		Assert.assertTrue(managerHomePage.isMgrTotalReviewCycleInitiated(prop.getProperty("MgrTotalReviewCycleInitiated")));
	}
	@Test
	public void MgrGoalsApproved() {
		Assert.assertTrue(managerHomePage.isMgrGoalsApproved(prop.getProperty("MgrGoalsApproved")));
	}
	@Test
	public void MgrEmployeeSelfReview() {
		Assert.assertTrue(managerHomePage.isMgrEmployeeSelfReview(prop.getProperty("MgrEmployeeSelfReview")));
	}
	@Test
	public void MgrManagerReview() {
		Assert.assertTrue(managerHomePage.isMgrManagerReview(prop.getProperty("MgrManagerReview")));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
}
