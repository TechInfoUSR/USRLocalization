package normalFlowTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.PMSCyclePage;
import NormalFlowForEmployee.Skipp_Approval;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.initiatePMSCycle;
import NormalFlowForEmployee.manager_AddGoals;

public class Skipp_Approval_test 
{
	
	addGoalPlan addGoalPlan;
	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
	manager_AddGoals manager_AddGoals;
	Skipp_Approval Skipp_Approval;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;

    @BeforeTest
    void setUp() throws IOException 
    {
    	 cp = new ConfigpropReader();
         prop = cp.initLangProp("NormalFlowTest");
         df = new DriverFactory();
         driver = df.initDriver("chrome", prop);
         addGoalPlan = new addGoalPlan(driver);
         addGoalPlan.login(prop.getProperty("SkipmgrUN"), prop.getProperty("SkipmgrPass"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        Skipp_Approval = new Skipp_Approval(driver, prop);
    
    }
    
    
    @Test
    void Skip_approval() throws InterruptedException
    {
    	Skipp_Approval.approve();
    	String isdisp = Skipp_Approval.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"Skip_approval not completed!!!!");
    }
	
    
    
	@AfterClass
	void teardown() {
		driver.quit();
	}
}
