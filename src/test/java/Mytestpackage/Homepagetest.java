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
public class Homepagetest {
	

		DriverFactory df;
		ConfigpropReader cp;
		Properties prop;
		WebDriver driver;
		HomePage homePage;

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
		}

		@Test
		public void headerTest() {
			Assert.assertTrue(homePage.isHeaderExist(prop.getProperty("empgreetings")));
		}

		@Test
		public void contactFooterTest() {
			Assert.assertTrue(homePage.isContactExist(prop.getProperty("EmpTotal")));
		}
		
		@Test
		public void EmpstatusTest() {
			Assert.assertTrue(homePage.isEmpstatusTest(prop.getProperty("Empstatus")));
		}
		

		@AfterTest
		public void tearDown() {
			driver.quit();
		}

	}