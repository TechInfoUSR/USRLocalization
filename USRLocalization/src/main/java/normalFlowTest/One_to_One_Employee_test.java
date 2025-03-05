package normalFlowTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.One_to_One_Employee;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.emp_assesment_Submission;

public class One_to_One_Employee_test {
	addGoalPlan addGoalPlan;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    One_to_One_Employee One_to_One_Employee;
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
         
        One_to_One_Employee = new One_to_One_Employee(driver, prop);
    
    }
  @Test(priority = 1)
  public void OnToOneMeeting_Employee() throws InterruptedException{
  	 String pmsCycleName = prop.getProperty("GoalPalnName");
  	One_to_One_Employee.selectGoalCycle(pmsCycleName);
  	String isdisp = One_to_One_Employee.isSelfsub();
	String Act="Submitted successfully";
	assertEquals(Act,isdisp,"One to One Employee not completed!!!!");
  
  }
  @AfterClass
  void Teardown() {
	  driver.quit();
  }
  
}
