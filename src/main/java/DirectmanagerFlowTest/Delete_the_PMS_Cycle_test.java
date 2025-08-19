package DirectmanagerFlowTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import DirectmanagerFlowMain.Progress_reset;
import Factory.DriverFactory;
import normalFlow_BaseClasses.addGoalPlan;

public class Delete_the_PMS_Cycle_test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Progress_reset Progress_reset;
    
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("DirectMGRProp");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Progress_reset = new Progress_reset(driver, prop);
    }
    
    
    @Test
    void DeletionOfEmp_FromCycle() throws InterruptedException {
    	Progress_reset.Deletion();
    	boolean isdeleted = Progress_reset.isDeleted();
    	assertTrue(isdeleted,"working fine");
    	
    }

}
