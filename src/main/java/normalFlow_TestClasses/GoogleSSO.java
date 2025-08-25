package normalFlow_TestClasses;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import normalFlow_BaseClasses.SSO_Base_Class;
import normalFlow_BaseClasses.addGoalPlan;

public class GoogleSSO {
	
	
	

	
	
	
	 DriverFactory df;
	    ConfigpropReader cp;
	    Properties prop;
	    WebDriver driver;
	    addGoalPlan addGoalPlan;
	    SSO_Base_Class SSO_Base_Class;
	
	 @BeforeTest
	    void setUp() throws IOException 
	    {
	        cp = new ConfigpropReader();
	        prop = cp.initFlow("NormalFlowTest");
	        df = new DriverFactory();
	        driver = df.initDriver("chrome", prop);
	        addGoalPlan = new addGoalPlan(driver);

	        SSO_Base_Class =new SSO_Base_Class(driver, prop);
	}

	 @Test(priority = 1)
	    public void SSOBase() throws InterruptedException, ParseException 
	    { 
		 
		 SSO_Base_Class.baseSSO();
		 
	    }
}
