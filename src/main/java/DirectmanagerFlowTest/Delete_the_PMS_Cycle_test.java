package DirectmanagerFlowTest;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.Delete_the_PMS_Cycle;
import normalFlow_BaseClasses.addGoalPlan;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class Delete_the_PMS_Cycle_test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Delete_the_PMS_Cycle Delete_the_PMS_Cycle;
    
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("DirectMGRProp");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Delete_the_PMS_Cycle = new Delete_the_PMS_Cycle(driver, prop);
    }
    
    
    @Test
    void DeletionOfEmp_FromCycle() throws InterruptedException {
    	Delete_the_PMS_Cycle.Deletion();
    	boolean isdeleted = Delete_the_PMS_Cycle.isDeleted();
    	assertTrue(isdeleted,"working fine");
    	
    }
    
//    @AfterClass
//    void teardown() {
//    	driver.quit();
//    }
    
}
