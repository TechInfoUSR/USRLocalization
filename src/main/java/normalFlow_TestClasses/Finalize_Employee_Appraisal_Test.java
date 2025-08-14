package normalFlow_TestClasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.Finalize_Employee_Appraisal;
import normalFlow_BaseClasses.LoginPage;

public class Finalize_Employee_Appraisal_Test 
{
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Finalize_Employee_Appraisal Finalize_Employee_Appraisal;
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initFlow("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login(prop.getProperty("MgrUN"), prop.getProperty("Mgrpass"));
        LoginPage.ClosePopUp();
          
        Finalize_Employee_Appraisal = new Finalize_Employee_Appraisal(driver, prop);

    
    }
    
    @Test
    void Finalize_Emp_Appraisal() throws InterruptedException {
    	Finalize_Employee_Appraisal.selectGoalCycle(prop.getProperty("GoalPalnName"));
    	Finalize_Employee_Appraisal.navigateToEmployeeSelf();
    	String isdisp = Finalize_Employee_Appraisal.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Finalized";
    	assertEquals(Act,isdisp,"Finalized not completed!!!!");
    	
    }
    
    @AfterClass
    void teardown() {
    	driver.quit();
    }
}

