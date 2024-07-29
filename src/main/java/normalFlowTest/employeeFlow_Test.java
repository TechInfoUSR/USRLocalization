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

public class employeeFlow_Test
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
        addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
    
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
