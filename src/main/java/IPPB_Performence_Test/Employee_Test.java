package IPPB_Performence_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import IPPB_Performence.Employee_Assessment_submission;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.emp_assesment_Submission;

public class Employee_Test
{
	addGoalPlan addGoalPlan;
	Employee_Assessment_submission Employee_Assessment_submission;
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
//        addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));

        Employee_Assessment_submission = new Employee_Assessment_submission(driver, prop);
    
    }
  @Test(priority = 1)
  public void Employee_Assesment() throws InterruptedException, IOException{
  	Employee_Assessment_submission.DataReader();
  	String isselfsub = Employee_Assessment_submission.isSelfsub();
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
