package normalFlowTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.addGoalPlan;
import NormalFlowForEmployee.manager_Sumitt_Assesment_To_Skip;

public class manager_Sumitt_Assesment_To_Skip_Test 
{
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    addGoalPlan addGoalPlan;
    manager_Sumitt_Assesment_To_Skip manager_Sumitt_Assesment_To_Skip;

    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        addGoalPlan = new addGoalPlan(driver);
        manager_Sumitt_Assesment_To_Skip = new manager_Sumitt_Assesment_To_Skip(driver, prop);
        addGoalPlan.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));       
      
    }
  @Test(priority = 1)
void select_Emp() throws InterruptedException{
	  manager_Sumitt_Assesment_To_Skip.selectGoalCycle();
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
