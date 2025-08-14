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

public class Send360formtoEmployess_Test {
	  DriverFactory df;
	    ConfigpropReader cp;
	    Properties prop; 
	    WebDriver driver;
	    Send360formto_Employess Send360formto_Employess;
	    
	    @BeforeTest
	    void setUp() throws IOException, InterruptedException 
	    {
	        cp = new ConfigpropReader();
	        prop = cp.initFlow("360Degree_Flow");
	        df = new DriverFactory();
	        driver = df.initDriver("chrome", prop);
	        Send360formto_Employess = new Send360formto_Employess(driver, prop);
	        Send360formto_Employess.login(prop.getProperty("HrUsername"), prop.getProperty("HrPassword"));
	          
	        Send360formto_Employess = new Send360formto_Employess(driver, prop);
	        
	        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
	        Srollup.executeScript("window.scrollBy(0,2000)");        
	        Thread.sleep(100);
	        driver.findElement(By.xpath("(//h3[contains(text(),'360° Feedback for SMART IDPs')])[1]")).click();
	        Thread.sleep(100);
	        driver.findElement(By.xpath("//span[contains(text(),'Send 360° Feedback Request')]")).click();
	        Thread.sleep(100);
	    
	    }
	   
	    
	    @Test
	    void send360form() throws InterruptedException, IOException {
	    	Send360formto_Employess.DataReader();
	    	
	    }
	    

	    @AfterClass
	    void teardown() {
	    	driver.quit();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
}
	    
	    
	    
