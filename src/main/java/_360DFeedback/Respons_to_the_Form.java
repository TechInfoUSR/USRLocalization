package _360DFeedback;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
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
		
	     void login() {
	    	 driver.findElement(usernameField).sendKeys(prop.getProperty("U/N_360Degreeresponder"));
		        driver.findElement(passwordField).sendKeys(prop.getProperty("Pass_360Degreeresponder"));
		        driver.findElement(loginButton).click();	
	     }
	     
	     
	     void Response_to_360Form() throws InterruptedException, IOException
	     	{
	    	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		        driver.findElement(By.xpath("//a[contains(text(),'360° feedback')]")).click();

		        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		      
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
	                 
//	                 js.executeScript("arguments[0].scrollIntoView(true);", element);
	                 
	                 elementVisible = true;
	             } catch (NoSuchElementException e) {
	             	
	                 js.executeScript("window.scrollBy(0, 100);");
	             }
	         } while (!elementVisible);

	         WebElement element = driver.findElement(By.xpath(xpath));

//	         element.click();
	         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     		        
	           JavascriptExecutor executor = (JavascriptExecutor) driver;
	           executor.executeScript("arguments[0].click();", element);
	          
	           
		        //Call for loop to read data from Excel
	           Datafor();
	          
	           WebElement scrollViewElement = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
	           js.executeScript("arguments[0].scrollIntoView(true);", scrollViewElement);
	           
	           
	           System.out.println(noforepons);
//			  driver.findElement(By.xpath("(//button[@type=\"reset\"])[1]")).click();
	           driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
	           Thread.sleep(1000);
	           Alert alert = driver.switchTo().alert();
	           alert.accept();  
	           Thread.sleep(1000);
	           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	           driver.findElement(By.xpath("//h3[contains(text(),'My 360° FEEDBACK')]")).click();
	         
	     
		    }
	}
	     
	    
	     void Datafor() throws IOException, InterruptedException{
	     	
	    	 String excelFilePath = ".\\DataFolder\\Rsponse For the 360 degree questions.xlsx";

		        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		        XSSFWorkbook workbook1 = new XSSFWorkbook(inputStream);
		        XSSFSheet sheet = workbook1.getSheetAt(0); 
		       
		        int rows = sheet.getLastRowNum();
	         int cols = sheet.getRow(0).getLastCellNum();
		        
	         DataFormatter formatter = new DataFormatter();

	         
	         List<WebElement> questions = driver.findElements(By.xpath("(//form[@class='form-horizontal degree mt-5 ng-pristine ng-valid'])[1]//div[@class='options']"));

	         int numberOfQuestions = questions.size();
	         System.out.println("Number of questions: " + numberOfQuestions);

	       if (numberOfQuestions == 13) {
	         for (int r = 1; r <= numberOfQuestions; r++) {
	             XSSFRow row = sheet.getRow(r);
	             if (row == null) {
	                 continue; // Skip empty rows
	             }

	             // Read the value from the specific column (e.g., column 0)
	             XSSFCell cell = row.getCell(0); 
	             if (cell != null) {
          
	                 cell.getCellType();
	                 int option_no = (int) cell.getNumericCellValue();
	                 System.out.println("Row " + r + " Column 0 value: " + option_no);

	                 callfordata(option_no,numberOfQuestions, r);
	             }
	         
	         }
	       }
	       else if(numberOfQuestions==12) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue; 
	               }

	               XSSFCell cell = row.getCell(1); 
	               if (cell != null) {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);

	                   callfordata(option_no,numberOfQuestions, r);
	               }
	           
	           }
	           
	       }
	       else if (numberOfQuestions==11) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue;
	               }

	               XSSFCell cell = row.getCell(2); 
	               if (cell != null) {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);

	                   callfordata(option_no,numberOfQuestions, r);
	               }
	           
	           }
	       }
	       else if(numberOfQuestions==10) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue; 
	               }
	               XSSFCell cell = row.getCell(3); 
	               if (cell != null) {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);

	                   callfordata(option_no,numberOfQuestions, r);
	               }
	           
	           }
	       }
	       else if(numberOfQuestions==14) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue; 
	               }

	               XSSFCell cell = row.getCell(4); 
	               if (cell != null) {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);
	                   callfordata(option_no,numberOfQuestions, r);
	               }
	           
	           }
	       }
	       else if(numberOfQuestions==2) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue;
	               }

	               XSSFCell cell = row.getCell(5);
	               if (cell != null) 
	               {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);

	                   WebElement question = questions.get(r - 1);

	                   callfordata(option_no,numberOfQuestions, r);
	               }           
	           }
	       }
	       else if(numberOfQuestions==1) {
	           for (int r = 1; r <= numberOfQuestions; r++) {
	               XSSFRow row = sheet.getRow(r);
	               if (row == null) {
	                   continue;
	               }

	               XSSFCell cell = row.getCell(6);
	               if (cell != null) 
	               {
	                   cell.getCellType();
	                   int option_no = (int) cell.getNumericCellValue();
	                   System.out.println("Row " + r + " Column 0 value: " + option_no);

	                   WebElement question = questions.get(r - 1);

	                   callfordata(option_no,numberOfQuestions, r);
	               }           
	           }
	       }
	             System.out.println(); 
	         
	      
		        workbook1.close();
		        inputStream.close();
		
	     } 
	     
	     void callfordata(int optionno,int numberOfQuestions,int r) throws InterruptedException{	    		       
	         for (int j = 1; j <= numberOfQuestions; j++) 
	         {  
	             System.out.println(r);         
	             if(numberOfQuestions<= 3) 
	             {
	            	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            	 String radioButtonXPath = "(//input[@value=\"" + optionno + " \"])[" + r + "]";
	            	 driver.findElement(By.xpath(radioButtonXPath)).click();//input[@value="1 "]
//	            	 Thread.sleep(1000);
	             }
	             else 
	             {
	            	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            	 String radioButtonXPath = "(//input[@value=\"" + optionno + " \"])[" + r + "]";
	                 driver.findElement(By.xpath(radioButtonXPath)).click();
//	                 Thread.sleep(1000);
	             }	          
	                  
	         }

	     }
		
			
}
		
		
	       

		

		


