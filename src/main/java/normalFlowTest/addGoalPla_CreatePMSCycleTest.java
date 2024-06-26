package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.PMSCyclePage;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.initiatePMSCycle;
public class addGoalPla_CreatePMSCycleTest 
{
	addGoalPlan addGoalPlan;
	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;

    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("normal");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("hrUsername"), prop.getProperty("hrPassword"));
        
        
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
    }

    @Test(priority = 1)
    public void testAddGoalPlan() throws InterruptedException 
    {
    	addGoalPlan.addGoalPlan1(prop.getProperty("GoalPalnName"), prop.getProperty("EmpGroup"), prop.getProperty("Weighted").equals("Weighted"),prop.getProperty("RatingScale"));
        boolean isDisplayed = addGoalPlan.isGoalPlanDisplayed(prop.getProperty("GoalPalnName"));
        Assert.assertTrue(isDisplayed, "Goal Plan is not displayed!");
    }
    @Test(priority = 2)
    public void testAddPMSCycle() throws InterruptedException 
    {	
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	boolean isDisplayed = PMSCyclePage.isPMSCycleDisplayed();
        Assert.assertTrue(isDisplayed, "PMS Cycle is not displayed");
    }
    @Test(priority = 3)
    public void testinitiatePMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    	boolean isCycleInitiatedDisplayed = initiatePMSCycle.isCycleInitiated(prop.getProperty("EmpGroup"));
        Assert.assertTrue(isCycleInitiatedDisplayed, "Map and content is not displayed");
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
