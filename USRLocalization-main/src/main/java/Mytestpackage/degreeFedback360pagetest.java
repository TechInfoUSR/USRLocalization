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
import Pages.degreeFedback360;

public class degreeFedback360pagetest {
	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	degreeFedback360 degreeFedback360;

	@BeforeTest
	public void setup() {
		cp = new ConfigpropReader();
		prop = cp.initLangProp("english");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[2]/input")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[3]/input")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[@id=\"hello\"]/div[4]/button")).click();
		driver.findElement(By.xpath("//a[contains(text(),'360° feedback')]")).click();
		
		degreeFedback360 = new degreeFedback360(driver);
	}
	@Test(priority= 1)
	public void Pending() {
		Assert.assertTrue(degreeFedback360.isPending(prop.getProperty("EmpPending")));
	}
	@Test(priority= 2)
	public void Completed() {
		Assert.assertTrue(degreeFedback360.isCompleted(prop.getProperty("Completed")));
	}
	@Test(priority= 3)
	public void KRAPEERREVIEW() {
		Assert.assertTrue(degreeFedback360.isKRAPEERREVIEW(prop.getProperty("KRAPEERREVIEW")));
	}
	@Test(priority= 4)
	public void SCOPE() {
		Assert.assertTrue(degreeFedback360.isSCOPE(prop.getProperty("KRAPEERREVIEW")));
	}
	@Test(priority= 5)
	public void EMPLOYEE() {
		Assert.assertTrue(degreeFedback360.isEMPLOYEE(prop.getProperty("EMPLOYEE")));
	}
	@Test(priority= 6)
	public void REQUESTEDBY() {
		Assert.assertTrue(degreeFedback360.isREQUESTEDBY(prop.getProperty("REQUESTEDBY")));
	}
	@Test(priority= 7)
	public void EMPLOYEESELFREVIEW() {
		Assert.assertTrue(degreeFedback360.isEMPLOYEESELFREVIEW(prop.getProperty("EMPLOYEESELFREVIEW")));
	}
	@Test(priority= 8)
	public void MANAGERREVIEW() {
		Assert.assertTrue(degreeFedback360.isMANAGERREVIEW(prop.getProperty("MANAGERREVIEW")));
	}
	@Test(priority= 9)
	public void GOALPEERFEEDBACK() {
		Assert.assertTrue(degreeFedback360.isGOALPEERFEEDBACK(prop.getProperty("GOALPEERFEEDBACK")));
	}
	@Test(priority= 10)
	public void My360FEEDBACK() {
		Assert.assertTrue(degreeFedback360.isMy360FEEDBACK(prop.getProperty("My360FEEDBACK")));
	}
	@Test(priority= 11)
	public void COMPETENCIESPEERREVIEW() {
		Assert.assertTrue(degreeFedback360.isCOMPETENCIESPEERREVIEW(prop.getProperty("COMPETENCIESPEERREVIEW")));
	}
	@Test(priority= 12)
	public void Provide360Feedbackabout() {
		Assert.assertTrue(degreeFedback360.isProvide360Feedbackabout(prop.getProperty("Provide360Feedbackabout")));
	}
	@Test(priority= 13)
	public void Feedbackrequestedby() {
		Assert.assertTrue(degreeFedback360.is360Feedbackrequestedby(prop.getProperty("360Feedbackrequestedby")));
	}
	@Test(priority= 14)
	public void ReportingManager() {
		Assert.assertTrue(degreeFedback360.isReportingManager(prop.getProperty("ReportingManager")));
	}
	@Test(priority= 15)
	public void Requestcameon() {
		Assert.assertTrue(degreeFedback360.isRequestcameon(prop.getProperty("Requestcameon")));
	}

	@Test(priority= 16)
	public void SelectReport() {
		Assert.assertTrue(degreeFedback360.isSelectReport(prop.getProperty("SelectReport")));
	}
	@Test(priority= 17)
	public void ExporttoExcel() {
		Assert.assertTrue(degreeFedback360.isExporttoExcel(prop.getProperty("ExporttoExcel")));
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	}
