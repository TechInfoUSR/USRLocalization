package Test_Suit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.AddEmployeetoDB;
import NormalFlowForEmployee.Delete_Goal_Plan_and_PMS_Cycle;
import NormalFlowForEmployee.Delete_the_PMS_Cycle;
import NormalFlowForEmployee.Finalize_Employee_Appraisal;
import NormalFlowForEmployee.One_to_One_Employee;
import NormalFlowForEmployee.One_to_One_manager;
import NormalFlowForEmployee.PMSCyclePage;
import NormalFlowForEmployee.Skipp_Approval;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.emp_assesment_Submission;
import NormalFlowForEmployee.initiatePMSCycle;
import NormalFlowForEmployee.manager_AddGoals;
import NormalFlowForEmployee.manager_Sumitt_Assesment_To_Skip;
import Utils.EmailUtil;
import Utils.RetryAnalyzer;
import Utils.ScreenshotUtil;

public class TestSuitClass {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    
    
    AddEmployeetoDB AddEmployeetoDB;
	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
	manager_AddGoals manager_AddGoals;
	emp_assesment_Submission emp_assesment_Submission;
	manager_Sumitt_Assesment_To_Skip manager_Sumitt_Assesment_To_Skip;
	Skipp_Approval Skipp_Approval;
	One_to_One_manager One_to_One_manager;
	One_to_One_Employee One_to_One_Employee ;
	Finalize_Employee_Appraisal Finalize_Employee_Appraisal;
	Delete_the_PMS_Cycle Delete_the_PMS_Cycle;
	Delete_Goal_Plan_and_PMS_Cycle Delete_Goal_Plan_and_PMS_Cycle;
	
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        AddEmployeetoDB =new AddEmployeetoDB(driver, prop);
    	Skipp_Approval= new Skipp_Approval(driver, prop);
    	manager_Sumitt_Assesment_To_Skip = new manager_Sumitt_Assesment_To_Skip(driver, prop);
    	emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
        AddEmployeetoDB= new AddEmployeetoDB(driver, prop);
    	PMSCyclePage=new PMSCyclePage(driver, prop);
    	initiatePMSCycle=new initiatePMSCycle(driver, prop);
    	manager_AddGoals=new manager_AddGoals(driver, prop);
    	One_to_One_manager=new One_to_One_manager(driver,prop);
    	One_to_One_Employee =new One_to_One_Employee(driver,prop);
    	Finalize_Employee_Appraisal = new Finalize_Employee_Appraisal(driver,prop);
    	Delete_the_PMS_Cycle =new Delete_the_PMS_Cycle(driver,prop);
    	Delete_Goal_Plan_and_PMS_Cycle =new Delete_Goal_Plan_and_PMS_Cycle(driver,prop);
    	
    	
    }
    
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void AddGoalPlan() throws InterruptedException 
    {    
    	String GoalPalnName = prop.getProperty("GoalPalnName");
    	String EmpGroup = prop.getProperty("EmpGroup");
    	String RatingScale = prop.getProperty("RatingScale");
    	addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
    	String isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
    	
    	assertEquals(GoalPalnName,isDisplayed, "Goal Plan is not displayed!!");
    }
    @Test(priority = 2,dependsOnMethods = "AddGoalPlan",retryAnalyzer = RetryAnalyzer.class)
    public void AddPMSCycle() throws InterruptedException 
    {	String GoalPalnName = prop.getProperty("GoalPalnName");
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	String isDisplayed = PMSCyclePage.isPMSCycleDisplayed();    	
        assertEquals(GoalPalnName,isDisplayed, "PMS Cycle is not displayed!!!");
    }
    @Test(priority = 3,dependsOnMethods = "AddPMSCycle",retryAnalyzer = RetryAnalyzer.class)
    public void Initiate_PMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    	boolean isDisplayed =initiatePMSCycle.isCycleInitiated();
    	System.out.println(isDisplayed);    	
    	assertTrue(isDisplayed, "Goal plan didn't initiated");
    }

    @Test(priority = 4,dependsOnMethods = "Initiate_PMSCycle",retryAnalyzer = RetryAnalyzer.class)
    public void Manager_addGoalto_emp() throws InterruptedException {
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
//    	manager_AddGoals.navigateToEmployeeSelf();
        String pmsCycleName = prop.getProperty("GoalPalnName");
        manager_AddGoals.selectGoalCycle(pmsCycleName);
        manager_AddGoals.openEmployeeAssessment();
        manager_AddGoals.enterGoalDetails();
        boolean isDisplayed = manager_AddGoals.isGoalAdded();
        assertTrue(isDisplayed, "Goal not Added!"); 
    }


    @Test(priority = 5,dependsOnMethods = "Manager_addGoalto_emp",retryAnalyzer = RetryAnalyzer.class)
    public void Employee_Assesment() throws InterruptedException{
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
    	String pmsCycleName = prop.getProperty("GoalPalnName");
    	emp_assesment_Submission.selectGoalCycle(pmsCycleName);
    	String isselfsub = emp_assesment_Submission.isSelfsub();
    	String Actual="Self Review Completed";
    	assertEquals(Actual,isselfsub,"Self Assesment is not submitted!!");
    }

    @Test(priority = 6,dependsOnMethods = "Employee_Assesment",retryAnalyzer = RetryAnalyzer.class)
    void Manager_Assesmentsubmitto_Skip() throws InterruptedException{
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
    	  manager_Sumitt_Assesment_To_Skip.selectGoalCycle();
    	  String isselfsub = manager_Sumitt_Assesment_To_Skip.isSelfsub();
    	  String Actualtest = "Manager Review Completed";
    	  assertEquals(Actualtest,isselfsub,"Manager Assesment is not submitted!!");
      }
      
    @Test(priority = 7,dependsOnMethods = "Manager_Assesmentsubmitto_Skip",retryAnalyzer = RetryAnalyzer.class)
    void Skip_approval() throws InterruptedException
    {
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("SkipmgrUN"), prop.getProperty("SkipmgrPass"));
    	Skipp_Approval.approve();
    	String isdisp = Skipp_Approval.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"Skip_approval not completed!!!!");
    }
    @Test(priority = 8,dependsOnMethods = "Skip_approval",retryAnalyzer = RetryAnalyzer.class)
    void OneToOneMeeting_Manager() throws InterruptedException {
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
    	One_to_One_manager.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	One_to_One_manager.navigateToEmployeeSelf();
    	String isdisp = One_to_One_manager.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"One To One Meeting Manager not completed!!!!");
    	
    }
    
    @Test(priority = 9,dependsOnMethods = "OneToOneMeeting_Manager",retryAnalyzer = RetryAnalyzer.class)
    public void OnToOneMeeting_Employee() throws InterruptedException{
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
    	String pmsCycleName = prop.getProperty("GoalPalnName");
    	One_to_One_Employee.selectGoalCycle(pmsCycleName);
    	String isdisp = One_to_One_Employee.isSelfsub();
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"One to One Employee not completed!!!!");
    
    }
    
    @Test(priority = 10,dependsOnMethods = "OnToOneMeeting_Employee",retryAnalyzer = RetryAnalyzer.class)
    void Finalize_Emp_Appraisal() throws InterruptedException {
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
    	Finalize_Employee_Appraisal.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	Finalize_Employee_Appraisal.navigateToEmployeeSelf();
    	String isdisp = Finalize_Employee_Appraisal.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Finalized";
    	assertEquals(Act,isdisp,"Finalized not completed!!!!");
    	
    }
    
    @Test(priority=11,dependsOnMethods = "Finalize_Emp_Appraisal",retryAnalyzer = RetryAnalyzer.class)
    void DeletionodGoalPlan() throws InterruptedException {
    	
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
    	Delete_the_PMS_Cycle.Deletion();
    	boolean isdeleted = Delete_the_PMS_Cycle.isDeleted();
//    	System.out.println(isdeleted);
    	assertTrue(isdeleted,"working fine");
    }
    

    
    @Test(priority=12,dependsOnMethods = "DeletionodGoalPlan",retryAnalyzer = RetryAnalyzer.class)
    void DeletionofPMS() throws InterruptedException {
    	driver.get(prop.getProperty("url"));
    	addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    	boolean ispmsDeleted = Delete_Goal_Plan_and_PMS_Cycle.isPMSDeleted();
    	assertTrue(ispmsDeleted,"PMS Cycle deleted");
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
    	boolean isGoalPlanDeleted = Delete_Goal_Plan_and_PMS_Cycle.isGoalPlanDeleted();
    	assertTrue(isGoalPlanDeleted,"Goal plan deleted");
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
             ScreenshotUtil.captureScreenshot(result.getName(),driver);
            EmailUtil.sendEmail("Hanumanth@usrinfotech.com,partnership@usrinfo.tech,ravi@okrstars.co,santhosh@usrinfo.tech,vaidya@usrinfo.tech,subashini@usrinfo.tech,support@okrstars.co,bharath@usrinfotech.com,ajantha@usrinfotech.com,alisha@usrinfotech.com", 
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
