package normalFlow_TestClasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.One_to_One_manager;
import normalFlow_BaseClasses.addGoalPlan;

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
    void OneToOneMeeting_Manager() throws InterruptedException {
    	One_to_One_manager.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	One_to_One_manager.navigateToEmployeeSelf();
    	String isdisp = One_to_One_manager.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"One To One Meeting Manager not completed!!!!");
    	
    }
    
    @AfterClass
    void teardown() {
    	driver.quit();
    }
}
