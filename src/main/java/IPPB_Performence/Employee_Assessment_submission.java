package IPPB_Performence;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import NormalFlowForEmployee.addGoalPlan;

public class Employee_Assessment_submission {

	addGoalPlan addGoalPlan;
	private WebDriver driver;
    private Properties prop;
    String EmpUN;
    
	  public Employee_Assessment_submission(WebDriver driver, Properties prop) 
      {
          this.driver = driver;
          this.prop = prop;
      }

    
    
    public void DataReader() throws IOException, InterruptedException {
		
    	 
		 String excelFilePath = ".\\DataFolder\\IPPB_EMP_Details.xlsx";

	        // Create a FileInputStream to read from the Excel file
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

	        XSSFWorkbook workbook1 = new XSSFWorkbook(inputStream);
	        XSSFSheet sheet = workbook1.getSheetAt(0); // Assuming first sheet, index starts at 0
	       
	        int rows = sheet.getLastRowNum();
           int cols = sheet.getRow(0).getLastCellNum();
	        
           DataFormatter formatter = new DataFormatter();


	        for (int r = 1; r <= rows; r++) {
               XSSFRow row = sheet.getRow(r);
               if (row == null) {
                   continue; // Skip empty rows
               }

               
               // Iterate through each cell in the row
               for (int c = 0; c < cols; c++) {
                   XSSFCell cell = row.getCell(c);
                
				switch(c)
                   {
                   case 0: String EmpUN1 = formatter.formatCellValue(cell);
                   EmpUN=EmpUN1;
                   System.out.print(" "+ EmpUN + "\t"); break;
                   case 1: String Emppass = formatter.formatCellValue(cell);
                   driver.get(prop.getProperty("url"));
                   login(EmpUN,Emppass);
                   
                   
                   System.out.print(" "+ Emppass +" "+ r + "\t");break;      
                   
                   }
                   
               }
               
               
               selectGoalCycle();
               
             	String isselfsub = null;
				try {
					isselfsub = isSelfsub();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              	String Actual="Self Review Completed";
              	assertEquals(Actual,isselfsub,"Self Assesment is not submitted!!");
               System.out.println(); // Move to the next line after each row
           }

	        // Close the workbook and input stream
	        workbook1.close();
	        inputStream.close();
	
	}
    
    
    
    
    
    private By usernameField = By.xpath("//input[@name=\"username\"]");
    private By passwordField = By.xpath("//input[@name=\"password\"]");
    private By loginButton = By.xpath("//button[@type=\"submit\"]");
    
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    
    
    
    
   



  	  
		public void selectGoalCycle() throws InterruptedException 
        {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			 WebElement empElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"card list-view-card\"])[1]")));
//	  	        empElement.();
			
			Thread.sleep(7000);
        //  FOR Clicking on Drop down  
            WebElement elements = driver.findElement(By.xpath("(//div[@class=\"card list-view-card\"])[1]")); 
            // Use JavaScriptExecutor to click on the element
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", elements);
            Thread.sleep(2000);
          
   
            WebElement listContainer  = driver.findElement(By.id("categ105"));

            List<WebElement> noofGoals =listContainer.findElements(By.xpath("//ul[@class=\"flex flex-btn py-1 onhover-section ng-scope\"]"));
            int NoofGoal = noofGoals.size();
            System.out.println(NoofGoal);
            for (int i=1 ;i<=NoofGoal;i++) 
            {
          	Random random = new Random();
            	int randomNumber = random.nextInt(100) + 1;
            	updateProgressBar(driver, "(//input[@type=\"range\"])[1]", randomNumber);
         		Thread.sleep(5000);
         		String Employee_cmt = "EmpCmt";
         		String Employee_comment =Employee_cmt + i;

            }
         driver.findElement(By.xpath("//*[@id=\"s-tab01\"]/div/div[2]/div[3]/div/a")).click();
         Thread.sleep(1000); 
         WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
         WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-bb-handler=\"confirm\"]")));
         okButton.click();
         Thread.sleep(1000);
         
        }
  	  private static void updateProgressBar(WebDriver driver, String cssSelector, int progress) 
  	  {  
	    	  WebElement rangeInput = driver.findElement(By.xpath(cssSelector)); 
          // Cast WebDriver to JavascriptExecutor
          JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
          // Update the value of the range input and trigger the change event
          String script = "arguments[0].value = arguments[1];" +
                          "arguments[0].dispatchEvent(new Event('change'));";
          jsExecutor.executeScript(script, rangeInput, progress);
          // Optionally, update the progress text (if needed)
          WebElement progressText = driver.findElement(By.cssSelector(".risk"));
          jsExecutor.executeScript("arguments[0].innerText = arguments[1];", progressText, String.format("%d%% Complete", progress));

          
             String num = driver.findElement(By.xpath("//*[@id=\"categ105\"]/ul/li[3]/div[2]/div/div[2]")).getText();
            String s= "+progress+"+"%";
            if (num== s)
		{
			System.err.println("Pass");
		}
            else
            {
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
                WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categ105\"]/ul/li[3]/div[2]/div/div[2]")));
                okButton.isDisplayed();
            }
	      }
  	 
  	  
  	  
  	  public String isSelfsub() throws InterruptedException {   	
  		  Thread.sleep(2000);
  		  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
            WebElement okButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Self Review Completed')]")));
            okButton.getText();
  		 return okButton.getText();
  	  }
	
}
