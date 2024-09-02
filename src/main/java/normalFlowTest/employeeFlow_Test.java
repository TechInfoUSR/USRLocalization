package normalFlowTest;

import static org.testng.Assert.assertEquals;
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
import NormalFlowForEmployee.PMSCyclePage;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.emp_assesment_Submission;
import NormalFlowForEmployee.initiatePMSCycle;
import NormalFlowForEmployee.manager_AddGoals;

public class employeeFlow_Test
{
	addGoalPlan addGoalPlan;
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

        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
    
    }
  @Test(priority = 1)
  public void Employee_Assesment() throws InterruptedException{
  	 String pmsCycleName = prop.getProperty("GoalPalnName");
  	emp_assesment_Submission.selectGoalCycle(pmsCycleName);
  	String isselfsub = emp_assesment_Submission.isSelfsub();
  	String Actual="Self Review Completed";
  	assertEquals(Actual,isselfsub,"Self Assesment is not submitted!!");
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
