package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.Delete_the_PMS_Cycle;
import NormalFlowForEmployee.addGoalPlan;

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
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        Delete_the_PMS_Cycle = new Delete_the_PMS_Cycle(driver, prop);
    }
    
    
    @Test
    void Deletion() throws InterruptedException {
    	Delete_the_PMS_Cycle.Deletion();
    }
    
    @AfterClass
    void teardown() {
    	driver.quit();
    }
    
}