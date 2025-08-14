package normalFlow_TestClasses;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.LoginPage;
import normalFlow_BaseClasses.addGoalPlan;
import normalFlow_BaseClasses.manager_Sumitt_Assesment_To_Skip;

public class manager_Sumitt_Assesment_To_Skip_Test 
{
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    manager_Sumitt_Assesment_To_Skip manager_Sumitt_Assesment_To_Skip;

    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        manager_Sumitt_Assesment_To_Skip = new manager_Sumitt_Assesment_To_Skip(driver, prop);
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));    
        LoginPage.ClosePopUp();
      
    }
  @Test(priority = 1)
void Manager_Assesmentsubmitto_Skip() throws InterruptedException{
	  manager_Sumitt_Assesment_To_Skip.selectGoalCycle();
	  String isselfsub = manager_Sumitt_Assesment_To_Skip.isSelfsub();
	  String Actualtest = "Manager Review Completed";
	  	assertEquals(Actualtest,isselfsub,"Manager Assesment is not submitted!!");
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
