package normalFlowTest;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.PMSCyclePage;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.emp_assesment_Submission;
import NormalFlowForEmployee.initiatePMSCycle;
import NormalFlowForEmployee.manager_AddGoals;
public class addGoalPla_CreatePMSCycleTest 
{
	addGoalPlan addGoalPlan;
	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
	manager_AddGoals manager_AddGoals;
	emp_assesment_Submission emp_assesment_Submission;
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
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
    
    }

    @Test(priority = 1)
    public void testAddGoalPlan() throws InterruptedException 
    {   String GoalPalnName = prop.getProperty("GoalPalnName");
    	String EmpGroup = prop.getProperty("EmpGroup");
    	String RatingScale = prop.getProperty("RatingScale");
    	addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
    	boolean isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
    	assertTrue(isDisplayed, "Goal Plan is not displayed!");
    }
    @Test(priority = 2)
    public void testAddPMSCycle() throws InterruptedException 
    {	
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	boolean isDisplayed = PMSCyclePage.isPMSCycleDisplayed();
        assertTrue(isDisplayed, "PMS Cycle is not displayed");
    }
    @Test(priority = 3)
    public void testinitiatePMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    }


    @AfterTest
    void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
