package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.Finalize_Employee_Appraisal;
import NormalFlowForEmployee.addGoalPlan;

public class Finalize_Employee_Appraisal_Test 
{
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Finalize_Employee_Appraisal Finalize_Employee_Appraisal;
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
          
        Finalize_Employee_Appraisal = new Finalize_Employee_Appraisal(driver, prop);

    
    }
    
    @Test
    void OntoOneMeeting() throws InterruptedException {
    	Finalize_Employee_Appraisal.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	Finalize_Employee_Appraisal.navigateToEmployeeSelf();
    	
    }
    
    @AfterClass
    void teardown() {
    	driver.quit();
    }
}

