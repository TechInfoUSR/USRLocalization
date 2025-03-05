package NormalFlowForEmployee;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddEmployeetoDB 
{
    WebDriver driver;
    Properties prop;
    public AddEmployeetoDB(WebDriver driver,Properties prop) 
    {
        this.driver = driver;
        this.prop= prop;
    }
	
    
    public void AddEmployee() throws InterruptedException {
        JavascriptExecutor Srollup = (JavascriptExecutor) driver;
        Srollup.executeScript("window.scrollBy(0,700)");
        Thread.sleep(500);
    	driver.findElement(By.xpath("//*[@id=\"services\"]/div[2]/div/div[4]/div/a/h3")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(@id,'addNewUser')]")).click();
		Thread.sleep(500);
		
		
		String Empname = prop.getProperty("Empname");
		String EmpUN = prop.getProperty("EmpUN");
		String Emppass = prop.getProperty("EmpPass");
		String EmpID = prop.getProperty("EmpID");

		String Mgrname = prop.getProperty("Mgrname");
		String MgrUN = prop.getProperty("MgrUN");
		String Mgrpass = prop.getProperty("Mgrpass");
		String MgrID = prop.getProperty("EmpID");
		
		String Skipname = prop.getProperty("Empname");
		String SkipmgrUN = prop.getProperty("EmpUN");
		String SkipmgrPass = prop.getProperty("EmpPass");
		String SkipID = prop.getProperty("EmpID");
		
      //  Basic Information
		driver.findElement(By.xpath("//input[contains(@placeholder,'Employee ID')]")).sendKeys(EmpID);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys(Empname);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]")).sendKeys(EmpUN);
		Thread.sleep(500);
		driver.findElement(By.xpath("//select[contains(@class,'form-control ng-pristine ng-untouched ng-invalid ng-invalid-required')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[contains(@value,'0')]")).click();
		Thread.sleep(500);
//		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default pull-right')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'Employee Database')])[2]")).click();
		
      //		Work Location
		driver.findElement(By.xpath("//span[contains(@id,'select2-chosen-36')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'select2-result-label-207')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-white btn-xs')])[1]")).click();
		Thread.sleep(2000);
		
	  //		Designation
		driver.findElement(By.xpath("//span[contains(@id,'select2-chosen-40')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'select2-result-label-245')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-white btn-xs')])[5]")).click();
		Thread.sleep(2000);
		
      //		Reporting Manager
		driver.findElement(By.xpath("//div[contains(@id,'s2id_mgr')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'select2-result-label-322')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-white btn-xs')])[6]")).click();
		Thread.sleep(2000);
		
      //		Department
		driver.findElement(By.xpath("//span[contains(@id,'select2-chosen-39')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'select2-result-label-352')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-white btn-xs')])[4]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();
		Thread.sleep(2000);
		
//		Compensation Info
		
		driver.findElement(By.xpath("//span[contains(@id,'select2-chosen-398')]")).click();
		Thread.sleep(2000);
    }
}
