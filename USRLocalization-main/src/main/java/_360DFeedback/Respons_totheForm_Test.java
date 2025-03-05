
package _360DFeedback;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;

public class Respons_totheForm_Test {

		    DriverFactory df;
		    ConfigpropReader cp;
		    Properties prop; 
		    WebDriver driver;
		    Respons_to_the_Form Respons_to_the_Form;
		    TestResponse TestResponse;
		    Test11 Test11;
		    @BeforeTest
		    void setUp() throws IOException, InterruptedException 
		    {
		        cp = new ConfigpropReader();
		        prop = cp.initLangProp("360Degree_Flow");
		        df = new DriverFactory();
		        driver = df.initDriver("chrome", prop);
		       
		        Respons_to_the_Form = new Respons_to_the_Form(driver, prop);
		        TestResponse = new TestResponse(driver,prop);
		        Test11 = new Test11(driver, prop);
		    }

		    @Test
		    void Responsto_360form() throws InterruptedException, IOException {
		    	Respons_to_the_Form.login();
		    	Respons_to_the_Form.Response_to_360Form();
//		    	Respons_to_the_Form.Validate_the_Data();
		    }

//		    @Test (priority =2)
		    void test() throws InterruptedException, IOException {
		    	TestResponse.call();
		    }
		    
//		    @Test
		    void test11() throws InterruptedException, IOException {
		    	Test11.call();
		    }
		    @AfterClass
		    void teardown() {
			driver.quit();
		    }

	}
