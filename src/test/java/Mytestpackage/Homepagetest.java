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
import Pages.HomePage;
import Pages.degreeFedback360;
public class Homepagetest {
	

		DriverFactory df;
		ConfigpropReader cp;
		Properties prop;
		WebDriver driver;
		HomePage homePage;
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
			
			homePage = new HomePage(driver);
			degreeFedback360 = new degreeFedback360(driver);
		}

		@Test
		public void empgreetings() {
			Assert.assertTrue(homePage.isempgreetingsExist(prop.getProperty("empgreetings")));
		}

		@Test
		public void EmpTotal() {
			Assert.assertTrue(homePage.isEmpTotalExist(prop.getProperty("EmpTotal")));
		}
		
		@Test
		public void EmpstatusTest() {
			Assert.assertTrue(homePage.isEmpstatusTest(prop.getProperty("Empstatus")));
		}
		
		@Test
		public void Emp360feedback() {
			Assert.assertTrue(homePage.isEmp360feedback(prop.getProperty("Emp360feedback")));
		}
		
		@Test
		public void EmpCumulativeReports() {
			Assert.assertTrue(homePage.isEmpCumulativeReports(prop.getProperty("EmpCumulativeReports")));
		}
		@Test
		public void EmpMYGoal() {
			Assert.assertTrue(homePage.isEmpMYGoal(prop.getProperty("EmpMYGoal")));
		}
		@Test
		public void EmpOnTrack() {
			Assert.assertTrue(homePage.isEmpOnTrack(prop.getProperty("EmpOnTrack")));
		}
		@Test
		public void EmpAtRisk() {
			Assert.assertTrue(homePage.isEmpAtRisk(prop.getProperty("EmpAtRisk")));
		}

		@Test
		public void EmpBehind() {
			Assert.assertTrue(homePage.isEmpBehind(prop.getProperty("EmpBehind")));
		}
		@Test
		public void EmpClosed() {
			Assert.assertTrue(homePage.isEmpClosed(prop.getProperty("EmpClosed")));
		}
		@Test
		public void EmpPostponed() {
			Assert.assertTrue(homePage.isEmpPostponed(prop.getProperty("EmpPostponed")));
		}
		@Test
		public void EmpNotStarted() {
			Assert.assertTrue(homePage.isEmpNotStarted(prop.getProperty("EmpNotStarted")));
		}
		@Test
		public void EmpNotApproved() {
			Assert.assertTrue(homePage.isEmpNotApproved(prop.getProperty("EmpNotApproved")));
		}
		@Test
		public void EmpASSIGNEDBY() {
			Assert.assertTrue(homePage.isEmpASSIGNEDBY(prop.getProperty("EmpASSIGNEDBY")));
		}
		@Test
		public void EmpPROGRESSSCORE() {
			Assert.assertTrue(homePage.isEmpPROGRESSSCORE(prop.getProperty("EmpPROGRESSSCORE")));
		}
		@Test
		public void EmpADDNEWKRA() {
			Assert.assertTrue(homePage.isEmpADDNEWKRA(prop.getProperty("EmpADDNEWKRA")));
		}
		@Test
		public void EmpActions() {
			Assert.assertTrue(homePage.isEmpActions(prop.getProperty("EmpActions")));
		}
		@Test
		public void EmpProfileSettings() {
			Assert.assertTrue(homePage.isEmpProfileSettings(prop.getProperty("EmpProfileSettings")));
		}
		@Test
		public void EmpLogOut() {
			Assert.assertTrue(homePage.isEmpLogOut(prop.getProperty("EmpLogOut")));
		}
		@Test
		public void SubmitSelfAssessment() {
			Assert.assertTrue(homePage.isSubmitSelfAssessment(prop.getProperty("SubmitSelfAssessment")));
		}
		@Test
		public void EmpPolicyDocs() {
			Assert.assertTrue(homePage.isEmpPolicyDocs(prop.getProperty("EmpPolicyDocs")));
		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}

	}