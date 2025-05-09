package IPPB_Performence_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import IPPB_Performence.Manager_Assessment_submission;
import normalFlow_BaseClasses.addGoalPlan;

public class Manager_Test {

	DriverFactory df;
	ConfigpropReader cp;
	Properties prop;
	WebDriver driver;
	addGoalPlan addGoalPlan;
	Manager_Assessment_submission Manager_Assessment_submission;

	@BeforeTest
	void setUp() throws IOException {
		cp = new ConfigpropReader();
		prop = cp.initLangProp("NormalFlowTest");
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		addGoalPlan = new addGoalPlan(driver);
		Manager_Assessment_submission = new Manager_Assessment_submission(driver, prop);
		addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));

	}

	@Test(priority = 1)
	void Manager_Assesmentsubmitto_Skip() throws InterruptedException, IOException {
		Manager_Assessment_submission.DataReader();
		String isselfsub = Manager_Assessment_submission.isSelfsub();
		String Actualtest = "Manager Review Completed";
		assertEquals(Actualtest, isselfsub, "Manager Assesment is not submitted!!");
	}

	@AfterTest
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
