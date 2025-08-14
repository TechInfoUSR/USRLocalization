package DirectmanagerFlowTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.LoginPage;
import normalFlow_BaseClasses.PMSCyclePage;
import normalFlow_BaseClasses.addGoalPlan;
import normalFlow_BaseClasses.emp_assesment_Submission;
import normalFlow_BaseClasses.initiatePMSCycle;
import normalFlow_BaseClasses.manager_AddGoals;

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
    LoginPage LoginPage;

    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("DirectMGRProp");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
          
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        manager_AddGoals = new manager_AddGoals(driver, prop);
        emp_assesment_Submission = new emp_assesment_Submission(driver, prop);
        LoginPage = new LoginPage(driver);
    
    }
  @Test(priority = 1)
  public void Manager_addGoalto_emp() throws InterruptedException {
//  	manager_AddGoals.navigateToEmployeeSelf();
	  
	  LoginPage.ClosePopUp();
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
