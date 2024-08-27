package normalFlowTest;

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
import NormalFlowForEmployee.Delete_Goal_Plan_and_PMS_Cycle;
import NormalFlowForEmployee.addGoalPlan;
import Utils.EmailUtil;
import Utils.ScreenshotUtil;

public class Delete_Goal_Plan_and_PMS_Cycle__Test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Delete_Goal_Plan_and_PMS_Cycle Delete_Goal_Plan_and_PMS_Cycle;
    
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Delete_Goal_Plan_and_PMS_Cycle = new Delete_Goal_Plan_and_PMS_Cycle(driver, prop);
    }
    
    
    @Test(priority=1)
    void DeletionodGoalPlan() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    }
    
    @Test(priority=2)
    void DeletionofPMS() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.captureScreenshot(result.getName(),driver);
            EmailUtil.sendEmail("hanumanth@usrinfotech.com", 
                "Test Failed: " + result.getName(),
                "Please find the attached screenshot of the failed test.",
                "screenshots/" + result.getName() + ".png");
        }
    }
    @AfterClass
    void teardown() {
    	driver.quit();
    }
    
}
