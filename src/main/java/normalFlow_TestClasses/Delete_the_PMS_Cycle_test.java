package normalFlow_TestClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import Utils.RetryAnalyzer;
import normalFlow_BaseClasses.Delete_the_PMS_Cycle;
import normalFlow_BaseClasses.LoginPage;

public class Delete_the_PMS_Cycle_test {

//    Remove Employee from PMS cycle

    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    Delete_the_PMS_Cycle Delete_the_PMS_Cycle;
    
    
    @BeforeTest
    void setUp() throws IOException 
    {
        cp = new ConfigpropReader();
        prop = cp.initLangProp("NormalFlowTest");
        df = new DriverFactory();
        driver = df.initDriver("chrome", prop);
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
        
        Delete_the_PMS_Cycle = new Delete_the_PMS_Cycle(driver, prop);
    }
    
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void DeletionOfEmp_FromCycle() throws InterruptedException {
    	Delete_the_PMS_Cycle.Deletion();
    	boolean isdeleted = Delete_the_PMS_Cycle.isDeleted();
    	assertTrue(isdeleted,"working fine");
    	
    }
}
