package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.One_to_One_manager;
import NormalFlowForEmployee.addGoalPlan;

public class One_to_One_manager_test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    One_to_One_manager One_to_One_manager;
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
          
        One_to_One_manager = new One_to_One_manager(driver, prop);

    
    }
    
    @Test
    void OntoOneMeeting() throws InterruptedException {
    	One_to_One_manager.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	One_to_One_manager.navigateToEmployeeSelf();
    	
    }
    
    @AfterClass
    void teardown() {
    	driver.quit();
    }
}
