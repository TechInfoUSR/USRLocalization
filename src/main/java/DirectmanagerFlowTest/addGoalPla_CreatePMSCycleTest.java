package DirectmanagerFlowTest;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import Utils.EmailUtil;
import Utils.ScreenshotUtil;
import normalFlow_BaseClasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//@Listeners(normalFlowTest.TestFailureListener.class)

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
//    String GoalPalnName = prop.getProperty("GoalPalnName");
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
    public void AddGoalPlan() throws InterruptedException 
    {    String GoalPalnName = prop.getProperty("GoalPalnName");
    	String EmpGroup = prop.getProperty("EmpGroup");
    	String RatingScale = prop.getProperty("RatingScale");
    	addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
    	String isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
    	
    	assertEquals(GoalPalnName,isDisplayed, "Goal Plan is not displayed!!");
    }
    @Test(priority = 2)
    public void AddPMSCycle() throws InterruptedException 
    {	 String GoalPalnName = prop.getProperty("GoalPalnName");
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	String isDisplayed = PMSCyclePage.isPMSCycleDisplayed();    	
        assertEquals(GoalPalnName,isDisplayed, "PMS Cycle is not displayed!!!");
    }
    @Test(priority = 3)
    public void Initiate_PMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
//    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    	initiatePMSCycle.enterWeightages();

    	boolean isDisplayed =initiatePMSCycle.isCycleInitiated();
    	System.out.println(isDisplayed);    	
    	assertTrue(isDisplayed, "Goal plan didn't initiated");
    }


    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.captureScreenshot(result.getName(),driver);
            EmailUtil.sendEmail("hanumanth@usrinfotech.com", 
                "Test Failed: " + result.getName(),
                "Please find the attached screenshot of the failed test.",
                "screenshots/" + result.getName() + ".png");
        }
//        driver.quitDriver();
    }
    @AfterTest
    void teardown() {
    	driver.quit();
    }
}
