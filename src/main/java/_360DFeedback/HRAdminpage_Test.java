package _360DFeedback;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;

public class HRAdminpage_Test {
	  DriverFactory df;
	    ConfigpropReader cp;
	    Properties prop; 
	    WebDriver driver;
	    HR_Admin_page HR_Admin_page;
	    
	    @BeforeTest
	    void setUp() throws IOException, InterruptedException 
	    {
	        cp = new ConfigpropReader();
	        prop = cp.initLangProp("normal");
	        df = new DriverFactory();
	        driver = df.initDriver("chrome", prop);
	        HR_Admin_page = new HR_Admin_page(driver, prop);
	        HR_Admin_page.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
	          
	        HR_Admin_page = new HR_Admin_page(driver, prop);
	        
	        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
	        Srollup.executeScript("window.scrollBy(0,2000)");        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//h3[contains(text(),'360° Feedback for SMART IDPs')])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[contains(text(),'Send 360° Feedback Request')]")).click();
	        Thread.sleep(2000);
	    
	    }
	    
	    @Test
	    void send360form() throws InterruptedException, IOException {
	    	HR_Admin_page.DataReader();
	    	
	    }
	    

//	    @AfterClass
	    void teardown() {
	    	driver.quit();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
}
	    
	    
	    
