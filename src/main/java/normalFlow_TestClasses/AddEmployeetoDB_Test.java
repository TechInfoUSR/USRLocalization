package normalFlow_TestClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.AddEmployeetoDB;
import normalFlow_BaseClasses.addGoalPlan;

public class AddEmployeetoDB_Test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    AddEmployeetoDB AddEmployeetoDB;
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        AddEmployeetoDB =new AddEmployeetoDB(driver, prop);
    }
    
    @Test(priority = 1)
    public void testAddGoalPlan() throws InterruptedException 
    {   String GoalPalnName = prop.getProperty("GoalPalnName");
    	AddEmployeetoDB.AddEmployee();
    	
    	
    
    }
    @AfterClass
    void trardown() {
    driver.quit();
    }
    
    
}
