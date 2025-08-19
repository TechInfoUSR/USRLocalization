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
import normalFlow_BaseClasses.LoginPage;
import normalFlow_BaseClasses.PMSCyclePage;
import normalFlow_BaseClasses.Skipp_Approval;
import normalFlow_BaseClasses.initiatePMSCycle;
import normalFlow_BaseClasses.manager_AddGoals;

public class Skipp_Approval_test 
{

	PMSCyclePage PMSCyclePage;
	initiatePMSCycle initiatePMSCycle;
	manager_AddGoals manager_AddGoals;
	Skipp_Approval Skipp_Approval;
    DriverFactory df;
    ConfigpropReader cp;
    Properties prop;
    WebDriver driver;
    LoginPage LoginPage;
    

    @BeforeTest
    void setUp() throws IOException 
    {
    	 cp = new ConfigpropReader();
         prop = cp.initFlow("NormalFlowTest");
         df = new DriverFactory();
         driver = df.initDriver("chrome", prop);
         LoginPage LoginPage = new LoginPage(driver);
         LoginPage.login(prop.getProperty("SkipmgrUN"), prop.getProperty("SkipmgrPass"));
         LoginPage.ClosePopUp();
         
        PMSCyclePage = new PMSCyclePage(driver, prop);
        initiatePMSCycle = new initiatePMSCycle(driver, prop);
        Skipp_Approval = new Skipp_Approval(driver, prop);
    
    }
    
    
    @Test
    void Skip_approval() throws InterruptedException
    {
    	Skipp_Approval.approve();
    	String isdisp = Skipp_Approval.isSelfsub();
    	System.out.println(isdisp);
    	String Act="Submitted successfully";
    	assertEquals(Act,isdisp,"Skip_approval not completed!!!!");
    }
	
    
    
	@AfterClass
	void teardown() {
		driver.quit();
	}
}
