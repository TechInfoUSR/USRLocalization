package normalFlowTest;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

public class CLasstoTest {
	
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
	
	@Test
	 void DeletionOf_PMSCycleAndGoalPlan() throws InterruptedException {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
		
	    	driver.get(prop.getProperty("url"));
	    	addGoalPlan = new addGoalPlan(driver);
	    	addGoalPlan.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
	    	Delete_Goal_Plan_and_PMS_Cycle.DeletionPMSCycle();
	    	boolean ispmsDeleted = Delete_Goal_Plan_and_PMS_Cycle.isPMSDeleted();
	    	assertTrue(ispmsDeleted,"PMS Cycle deleted");
	    	Delete_Goal_Plan_and_PMS_Cycle.DeletionGoalPlan();
	    	boolean isGoalPlanDeleted = Delete_Goal_Plan_and_PMS_Cycle.isGoalPlanDeleted();
	    	assertTrue(isGoalPlanDeleted,"Goal plan deleted");
	    }
}
