package _360DFeedback;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Respons_to_the_Form {

		 private WebDriver driver;
	     private Properties prop;
	     
	     public Respons_to_the_Form(WebDriver driver, Properties prop) 
	     {
	         this.driver = driver;
	         this.prop = prop;
	     }
	     private By usernameField = By.xpath("//*[@id=\"hello\"]/div[2]/input");
	     private By passwordField = By.xpath("//*[@id=\"hello\"]/div[3]/input");
	     private By loginButton = By.xpath("//*[@id=\"hello\"]/div[4]/button");
		
		public void Response_to_360Form() throws InterruptedException {
			driver.findElement(usernameField).sendKeys(prop.getProperty("U/N_360Degreeresponder"));
	        driver.findElement(passwordField).sendKeys(prop.getProperty("Pass_360Degreeresponder"));
	        driver.findElement(loginButton).click();	
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[contains(text(),'360° feedback')]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	        Thread.sleep(2000);
	        String GoalPlanfor360degreefeedback = prop.getProperty("GoalPlanfor360degreefeedback");
	        driver.findElement(By.xpath("//a[contains(text(),'"+ GoalPlanfor360degreefeedback  +"')]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
	       
	        Thread.sleep(2000);
	        String noforeponsText = driver.findElement(By.xpath("(//h3[@class=\"ng-binding\"]) [5]")).getText();
	        int noforepons = Integer.parseInt(noforeponsText);
	        for (int i=1;i<= noforepons;i++) 
	        {
	        	
	        	
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            
	            String xpath = "(//div[@class='card list-view-card'])[1]"; 
	            
	            boolean elementVisible = false;
	            do {
	                try {
	                	
	                    WebElement element = driver.findElement(By.xpath(xpath));
	                    
//	                    js.executeScript("arguments[0].scrollIntoView(true);", element);
	                    
	                    elementVisible = true;
	                } catch (NoSuchElementException e) {
	                	
	                    js.executeScript("window.scrollBy(0, 100);");
	                }
	            } while (!elementVisible);

	            WebElement element = driver.findElement(By.xpath(xpath));

//	            element.click();
	        	
	        		        
	              JavascriptExecutor executor = (JavascriptExecutor) driver;
	              executor.executeScript("arguments[0].click();", element);
	              Thread.sleep(1000);
	  	        
	              
	              List<WebElement> questions = driver.findElements(By.xpath("(//form[@class=\"form-horizontal degree mt-5 ng-pristine ng-valid\"])[1]//div[@class=\"options\"]"));

	              int numberOfQuestions = questions.size();

	              System.out.println("Number of questions: " + numberOfQuestions);
	              
//	              int noofquestions = (numberOfQuestions);

	              for (int j = 1; j <= numberOfQuestions; j++) 
	              {                  
	                  Thread.sleep(1000);
	                  if(numberOfQuestions<= 3) {
	                  String radioButtonXPath = "(//input[@value=\"1\"])["+(j)+"]";
	                  driver.findElement(By.xpath(radioButtonXPath)).click();
	                  Thread.sleep(1000);
	                  }
	                  else {
	                	  String radioButtonXPath = "(//input[@value=\"1 \"])["+(j)+"]";
		                  driver.findElement(By.xpath(radioButtonXPath)).click();
		                  Thread.sleep(1000);
	                  }
	                  
	              }
	        
	              
	              Thread.sleep(1000); 
	              WebElement scrollViewElement = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
	              js.executeScript("arguments[0].scrollIntoView(true);", scrollViewElement);
	              Thread.sleep(2000); 
	              
	              System.out.println(noforepons);
//	   		  driver.findElement(By.xpath("(//button[@type=\"reset\"])[1]")).click();
	              driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
	              Thread.sleep(1000);
	              Alert alert = driver.switchTo().alert();
	              alert.accept();             
	              Thread.sleep(3000);
	              driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
	              Thread.sleep(1000);
	        
	  	    }
	        
	        }
		
		public void Validate_the_Data() throws InterruptedException 
		{
			String noforeponsText = driver.findElement(By.xpath("(//h3[@class=\"ng-binding\"]) [6]")).getText();
	        int noforepons = Integer.parseInt(noforeponsText);
	        
	        for (int i=1;i<= noforepons;i++) 
	        {
	        WebElement element = driver.findElement(By.xpath("(//div[@class='card list-view-card'])[1]"));
	        
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Thread.sleep(1000);
            
            
	       
            List<WebElement> questionsno = driver.findElements(By.xpath("//div[@id=\\\"myokrCollapse491\\\"]//p[@class=\\\"ng-binding\\\"]"));

            // Print the number of questions
            int numberOfQuestions = questionsno.size();
            System.out.println(numberOfQuestions);
//            driver.findElement(By.xpath("//div[@id=\"myokrCollapse491\"]//p[@class=\"ng-binding\"]"));
	        
	        
	        }
		}
		
		public void DataRead() throws IOException {
			
			String excelFilePath = ".\\DataFolder\\Rsponse For the 360 degree questions.xlsx";

	        // Create a FileInputStream to read from the Excel file
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

	        XSSFWorkbook workbook1 = new XSSFWorkbook(inputStream);
	        XSSFSheet sheet = workbook1.getSheetAt(0); // Assuming first sheet, index starts at 0
	       
	        int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();
	        
            DataFormatter formatter = new DataFormatter();


	        for (int r = 0; r <= rows; r++) {
                XSSFRow row = sheet.getRow(r);
                if (row == null) {
                    continue; // Skip empty rows
                }

                
                // Iterate through each cell in the row
                for (int c = 0; c < cols; c++) {
                    XSSFCell cell = row.getCell(c);
                    switch(c)
                    {
                    case 0: String Aboutwhom = formatter.formatCellValue(cell);
//                    Aboutwhom(Aboutwhom);
                   
                    }
                    
                }
                System.out.println(); // Move to the next line after each row
            }

	        // Close the workbook and input stream
	        workbook1.close();
	        inputStream.close();
	
	       
		}
			
			
			
			
		}
		
		
	       

		

		


