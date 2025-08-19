package Test_Suit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import DirectmanagerFlowMain.PMSCyclePage;
import DirectmanagerFlowMain.Progress_reset;
import DirectmanagerFlowMain.Skip_Approval;
import DirectmanagerFlowMain.addGoalPlan;
import DirectmanagerFlowMain.initiatePMSCycle;
import DirectmanagerFlowMain.manager_AddGoals;
import Factory.DriverFactory;
import Utils.RetryAnalyzer;
import normalFlow_BaseClasses.Delete_Goal_Plan_and_PMS_Cycle;
import normalFlow_BaseClasses.Delete_the_PMS_Cycle;
import normalFlow_BaseClasses.LoginPage;

public class DirectMGR_Smoke

{

    addGoalPlan addGoalPlan;
    PMSCyclePage PMSCyclePage;
    initiatePMSCycle initiatePMSCycle;
    manager_AddGoals manager_AddGoals;
    Skip_Approval Skip_Approval;
    Delete_Goal_Plan_and_PMS_Cycle Delete_Goal_Plan_and_PMS_Cycle;
    Progress_reset Progress_reset;
    LoginPage LoginPage;


    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    //    String GoalPalnName = prop.getProperty("GoalPalnName");
    @BeforeTest
    void setUp() throws IOException
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("DirectMGRProp");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
//        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        Skip_Approval =new Skip_Approval( driver, prop);
        Progress_reset =new Progress_reset(driver, prop);
        Delete_Goal_Plan_and_PMS_Cycle = new Delete_Goal_Plan_and_PMS_Cycle(driver, prop);
        LoginPage =new LoginPage(driver);
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void AddGoalPlan() throws InterruptedException
    {    
    	LoginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
    	String GoalPalnName = prop.getProperty("GoalPalnName");
        String EmpGroup = prop.getProperty("EmpGroup");
        String RatingScale = prop.getProperty("RatingScale");
        addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
        String isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
        assertEquals(GoalPalnName,isDisplayed, "Goal Plan is not displayed!!");
    }
    @Test(priority = 2, dependsOnMethods = "AddGoalPlan", retryAnalyzer = RetryAnalyzer.class)
    public void AddPMSCycle() throws InterruptedException
    {	 
    	
    	String GoalPalnName = prop.getProperty("GoalPalnName");
        PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
        String isDisplayed = PMSCyclePage.isPMSCycleDisplayed();
        assertEquals(GoalPalnName,isDisplayed, "PMS Cycle is not displayed!!!");
    }
    @Test(priority = 3, dependsOnMethods = "AddPMSCycle", retryAnalyzer = RetryAnalyzer.class)
    public void Initiate_PMSCycle() throws InterruptedException
    {
    	
        initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
        initiatePMSCycle.enterWeightages();
        boolean isDisplayed =initiatePMSCycle.isCycleInitiated();
        System.out.println(isDisplayed);
        assertTrue(isDisplayed, "Goal plan didn't initiated");
    }


    @Test(priority = 3 , dependsOnMethods = "Initiate_PMSCycle", retryAnalyzer = RetryAnalyzer.class)
    public void ManagerFlow() throws InterruptedException
    {
    	
        driver.get(prop.getProperty("url"));
        LoginPage.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
        LoginPage.ClosePopUp();
        String pmsCycleName = prop.getProperty("GoalPalnName");
        manager_AddGoals.selectGoalCycle(pmsCycleName);
        manager_AddGoals.openEmployeeAssessment();
        manager_AddGoals.enterGoalDetails();
        boolean isDisplayed = manager_AddGoals.isGoalAdded();
        assertTrue(isDisplayed, "Saved goal successfully");
        manager_AddGoals.selectGoalCycle();

    }

    @Test(priority = 4, dependsOnMethods = "ManagerFlow", retryAnalyzer = RetryAnalyzer.class)
    void Skip_Approval() throws InterruptedException
    {
    	
        driver.get(prop.getProperty("url"));
        LoginPage.login(prop.getProperty("SkipmgrUN"), prop.getProperty("SkipmgrPass"));
        LoginPage.ClosePopUp();
        Skip_Approval.approve();
        String isdisp = Skip_Approval.isSelfsub();
        System.out.println(isdisp);
        String Act="Submitted successfully";
        assertEquals(Act,isdisp,"Skip_approval not completed!!!!");
    }

    @Test(priority = 5,retryAnalyzer = RetryAnalyzer.class)
    void Remove_EmployeesFromGoalPlan() throws InterruptedException 
    {

    	driver.get(prop.getProperty("url"));
    	LoginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
    	Progress_reset.Deletion();
    	boolean isdeleted = Progress_reset.isDeleted();
    	assertTrue(isdeleted,"working fine");
    }

    @Test(priority = 6,retryAnalyzer = RetryAnalyzer.class)
    void DeletionOf_PMSCycleAndGoalPlan() throws InterruptedException 
    {

    	driver.get(prop.getProperty("url"));
    	LoginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
    }



    @AfterTest
    void teardown() 
    {
        driver.quit();
    }

}