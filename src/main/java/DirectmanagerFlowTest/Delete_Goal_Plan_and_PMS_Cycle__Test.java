package DirectmanagerFlowTest;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.Delete_Goal_Plan_and_PMS_Cycle;
import normalFlow_BaseClasses.addGoalPlan;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

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
        prop = cp.initFlow("DirectMGRProp");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Delete_Goal_Plan_and_PMS_Cycle = new Delete_Goal_Plan_and_PMS_Cycle(driver, prop);
    }
    
    
    @Test(priority=1)
    void DeletionodGoalPlan() throws InterruptedException {

    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    	boolean ispmsDeleted = Delete_Goal_Plan_and_PMS_Cycle.isPMSDeleted(prop.getProperty("GoalPalnName"));
    	assertTrue(ispmsDeleted,"PMS Cycle deleted");
    }
    
    @Test(priority=2)
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
