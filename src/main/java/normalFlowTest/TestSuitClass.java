package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    
//    @Test(priority = 1)
    public void testAddGoalPlan1() throws InterruptedException 
    {  
    	String GoalPalnName = prop.getProperty("GoalPalnName");
    	AddEmployeetoDB.AddEmployee();
	
    }
    @Test(priority = 2)
    public void testAddGoalPlan() throws InterruptedException 
    {   String GoalPalnName = prop.getProperty("GoalPalnName");
    	String EmpGroup = prop.getProperty("EmpGroup");
    	String RatingScale = prop.getProperty("RatingScale");
    	addGoalPlan.addGoalPlan1(GoalPalnName, EmpGroup ,RatingScale);
    	boolean isDisplayed = addGoalPlan.isGoalPlanDisplayed(GoalPalnName);
    	Assert.assertTrue(isDisplayed, "Goal Plan is not displayed!");
    }
    @Test(priority = 3)
    public void testAddPMSCycle() throws InterruptedException 
    {	
    	PMSCyclePage.addPMSCycle(prop.getProperty("GoalPalnName"));
    	boolean isDisplayed = PMSCyclePage.isPMSCycleDisplayed();
        Assert.assertTrue(isDisplayed, "PMS Cycle is not displayed");
    }
    @Test(priority = 4)
    public void testinitiatePMSCycle() throws InterruptedException 
    {	
    	initiatePMSCycle.goToWeightTab(prop.getProperty("EmpGroup"),prop.getProperty("GoalPalnName"));
    	initiatePMSCycle.enterWeightages(prop.getProperty("objectiveWeightage"),prop.getProperty("coreValueWeightage"), prop.getProperty("jobCompetencyWeightage"), prop.getProperty("behaviorWeightage"), prop.getProperty("leadershipWeightage"));
    }


    @Test(priority = 5)
    public void empSelf() throws InterruptedException {
//    	manager_AddGoals.navigateToEmployeeSelf();
        String pmsCycleName = prop.getProperty("GoalPalnName");
        manager_AddGoals.selectGoalCycle(pmsCycleName);
        manager_AddGoals.openEmployeeAssessment();
        manager_AddGoals.enterGoalDetails();
        Assert.assertTrue(true); 
    }

    @Test(priority = 6)
    public void selectGoalCycle() throws InterruptedException{
    	 String pmsCycleName = prop.getProperty("GoalPalnName");
    	emp_assesment_Submission.selectGoalCycle(pmsCycleName);
    }
    
    @Test(priority = 7)
    void select_Emp() throws InterruptedException{
    	  manager_Sumitt_Assesment_To_Skip.selectGoalCycle();
      }
  
    @Test(priority = 8)
    void approve() throws InterruptedException
    {
    	Skipp_Approval.approve();
    }
    
    @Test(priority = 9)
    void OntoOneMeeting() throws InterruptedException {
    	One_to_One_manager.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	One_to_One_manager.navigateToEmployeeSelf();
    	
    }
    
    @Test(priority = 10)
    public void selectGoalCycle1() throws InterruptedException{
    	 String pmsCycleName = prop.getProperty("GoalPalnName");
    	One_to_One_Employee.selectGoalCycle(pmsCycleName);
    }
    
    @Test(priority =11)
    void OntoOneMeeting1() throws InterruptedException {
    	Finalize_Employee_Appraisal.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	Finalize_Employee_Appraisal.navigateToEmployeeSelf();
    	
    }
    @Test(priority= 12)
    void Deletion() throws InterruptedException {
    	Delete_the_PMS_Cycle.Deletion();
    }
    @Test(priority=13)
    void DeletionodGoalPlan() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
    }
    
    @Test(priority=14)
    void DeletionofPMS() throws InterruptedException {
    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
    }
    
    
    
}
