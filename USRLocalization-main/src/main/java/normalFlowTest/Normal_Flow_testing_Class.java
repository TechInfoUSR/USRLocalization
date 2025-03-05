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
import NormalFlowForEmployee.emp_assesment_Submission;
import NormalFlowForEmployee.initiatePMSCycle;
import NormalFlowForEmployee.manager_AddGoals;

public class Normal_Flow_testing_Class {
	addGoalPlan addGoalPlan;
	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
	manager_AddGoals manager_AddGoals;
	emp_assesment_Submission emp_assesment_Submission;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    String GoalPalnName = prop.getProperty("GoalPalnName");
    
    
    
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
    {  
    	String EmpGroup = prop.getProperty("EmpGroup");
    	String RatingScale = prop.getProperty("RatingScale");
    	addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
    	String isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
    	Assert.assertEquals(GoalPalnName,isDisplayed, "Goal Plan is not displayed!");
    	driver.quit();
    }
//    @Test(priority = 2)
    public void testAddPMSCycle() throws InterruptedException 
    {	
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	String isDisplayed = PMSCyclePage.isPMSCycleDisplayed();
        Assert.assertEquals(GoalPalnName,isDisplayed, "PMS Cycle is not displayed");
    }
//    @Test(priority = 3)
    public void testinitiatePMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
//    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    	initiatePMSCycle.enterWeightages();
    	driver.quit();
    }
    
    
    
    @Test(priority = 4)
    public void empSelf() throws InterruptedException {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
    	
    	addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
    	
//    	manager_AddGoals.navigateToEmployeeSelf();
        String pmsCycleName = prop.getProperty("GoalPalnName");
        manager_AddGoals.selectGoalCycle(pmsCycleName);
        manager_AddGoals.openEmployeeAssessment();
        manager_AddGoals.enterGoalDetails();
        Assert.assertTrue(true); 
    }

    @Test(priority = 1)
    public void selectGoalCycle() throws InterruptedException{
    	 String pmsCycleName = prop.getProperty("GoalPalnName");
    	emp_assesment_Submission.selectGoalCycle(pmsCycleName);
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
