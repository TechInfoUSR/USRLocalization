package normalFlow_TestClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import Utils.RetryAnalyzer;
import Utils.ScreenshotUtil;
import normalFlow_BaseClasses.Delete_Goal_Plan_and_PMS_Cycle;
import normalFlow_BaseClasses.LoginPage;

public class Delete_Goal_Plan_and_PMS_Cycle__Test 
{
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Delete_Goal_Plan_and_PMS_Cycle Delete_Goal_Plan_and_PMS_Cycle;
    
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Delete_Goal_Plan_and_PMS_Cycle = new Delete_Goal_Plan_and_PMS_Cycle(driver, prop);
    }
    
    
    @Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
    void DeletionodGoalPlan() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    	boolean ispmsDeleted = Delete_Goal_Plan_and_PMS_Cycle.isPMSDeleted(prop.getProperty("GoalPalnName"));
    	assertTrue(ispmsDeleted,"PMS Cycle deleted");
    }
    
    @Test(priority=2, retryAnalyzer = RetryAnalyzer .class)
    void DeletionofPMS() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
    	boolean isGoalPlanDeleted = Delete_Goal_Plan_and_PMS_Cycle.isGoalPlanDeleted();
    	assertTrue(isGoalPlanDeleted,"Goal plan deleted");
    }

    @AfterClass
    void teardown() {
    	driver.quit();
    }
    
}
