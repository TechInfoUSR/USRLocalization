package DirectmanagerFlowTest;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class managerFlow_Test {
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
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
    
    }
  @Test(priority = 1)
  public void Manager_addGoalto_emp() throws InterruptedException {
//  	manager_AddGoals.navigateToEmployeeSelf();
      String pmsCycleName = prop.getProperty("GoalPalnName");
      manager_AddGoals.selectGoalCycle(pmsCycleName);
      manager_AddGoals.openEmployeeAssessment();
      manager_AddGoals.enterGoalDetails();
      boolean isDisplayed = manager_AddGoals.isGoalAdded();
      assertTrue(isDisplayed, "Goal not Added!"); 
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
