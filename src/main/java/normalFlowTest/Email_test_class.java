package normalFlowTest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ConfigReder.ConfigpropReader;
import Factory.DriverFactory;
import NormalFlowForEmployee.AddEmployeetoDB;
import NormalFlowForEmployee.addGoalPlan;
public class Email_test_class {
	 private WebDriver driver;
		addGoalPlan addGoalPlan;
	    DriverFactory df;
	    ConfigpropReader cp;
	    Properties prop;
	  
	    AddEmployeetoDB AddEmployeetoDB;
	    @BeforeClass
	    public void setUp() {
	    	  cp = new ConfigpropReader();
	          prop = cp.initLangProp("NormalFlowTest");
	          df = new DriverFactory();
	          driver = df.initDriver("chrome", prop);
	          addGoalPlan = new addGoalPlan(driver);
	          addGoalPlan.login(prop.getProperty("EmpUN"), prop.getProperty("Emppass"));
	          AddEmployeetoDB =new AddEmployeetoDB(driver, prop);
	      }

	    @Test
	    public void exampleTest() throws EmailException {
	        
	        WebElement element = driver.findElement(By.id("nonexistent_id")); // This will fail
	        Assert.assertNotNull(element);
	        
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    @AfterMethod
	    
	    public void onTestFailure(ITestResult result) throws EmailException {
	    	
	    	Date currentdate =new Date();
	    	String SS= currentdate.toString().replace(" ", "-").replace(":", "-");
	    	System.err.println(SS);
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = ".//Screenshort/"+SS+".png";
	        try {
	        	 FileUtils.copyFile(screenshot, new File(screenshotPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	        EmailAttachment attachment = new EmailAttachment();
	    	attachment.setPath(screenshotPath);
	    	attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    	attachment.setDescription("in this page bug is there");
	    	attachment.setName("Bug pic"+ SS);
	    	  
	    	System.out.println("Mail trigger");  	
	    	MultiPartEmail email = new MultiPartEmail();
		    email.setHostName("smtp.zeptomail.in");
		    email.setSmtpPort(587);
		    email.setAuthenticator(new DefaultAuthenticator("noreply@okrstars.com", "PHtE6r0OE+/q2TQppkUD4/6/Hs6tZ456+rtlLwMWtopEDfBQGU1Sr9kilWSx/ksuA/VFFP/JzNpqsLuY4uKMI2rtZDxMWWqyqK3sx/VYSPOZsbq6x00bt1gfdkDeUILue9Zq3SfTuN7ZNA=="));
		    email.setSSLOnConnect(true);
		    email.setFrom("noreply@okrstars.com");
		    email.setSubject("Bug is threr in Production Dev Team Please fix it");
		    email.setMsg("Dev team Fix this issue");
		    email.addTo("Hanumanth@usrinfotech.com");	    
	        email.attach(attachment);
	        email.send();
	        

	    }

}