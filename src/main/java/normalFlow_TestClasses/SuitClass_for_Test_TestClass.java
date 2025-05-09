package normalFlow_TestClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.SuitClass_for_Test;

public class SuitClass_for_Test_TestClass 
{
	SuitClass_for_Test SuitClass_for_Test;
	
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
        SuitClass_for_Test =new SuitClass_for_Test(driver,prop);

    }

    @Test(priority = 1)
    public void testAddGoalPlan() throws InterruptedException 
    { 
    	String GoalPalnName = prop.getProperty("GoalPalnName");
    	SuitClass_for_Test.addGoalPlan1();
    	boolean isDisplayed = SuitClass_for_Test.isGoalPlanDisplayed(GoalPalnName);
    	assertTrue(isDisplayed, "Goal Plan is not displayed!");
    }
    @Test(priority = 2)
    public void testAddPMSCycle() throws InterruptedException 
    {	
    	SuitClass_for_Test.addPMSCycle(prop.getProperty("GoalPalnName"));
    	boolean isDisplayed = SuitClass_for_Test.isPMSCycleDisplayed();
    	System.out.println(isDisplayed);
        assertTrue(isDisplayed, "PMS Cycle is not displayed");
    }
    @Test(priority = 3)
    public void testinitiatePMSCycle() throws InterruptedException 
    {	
    	SuitClass_for_Test.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
    	SuitClass_for_Test.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    
    }
    
    
    @Test(priority = 4)
    public void empSelf() throws InterruptedException {
//    	manager_AddGoals.navigateToEmployeeSelf();
    	driver.get("https://test.okrstars.com/solutions/login?invalid=1");
    	Thread.sleep(2000);
    	SuitClass_for_Test.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
        Thread.sleep(2000);
    	String pmsCycleName = prop.getProperty("GoalPalnName");
        SuitClass_for_Test.selectGoalCycle(pmsCycleName);
        SuitClass_for_Test.openEmployeeAssessment();
        SuitClass_for_Test.enterGoalDetails();
        Assert.assertTrue(true); 
    }

    @Test(priority = 5)
    public void selectGoalCycle() throws InterruptedException{
    	 String pmsCycleName = prop.getProperty("GoalPalnName");
    	 SuitClass_for_Test.selectGoalCycle(pmsCycleName);
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
