package _360DFeedback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HR_Admin_page {

	
	 private WebDriver driver;
     private Properties prop;
     
     public HR_Admin_page(WebDriver driver, Properties prop) 
     {
         this.driver = driver;
         this.prop = prop;
     }
     private By usernameField = By.xpath("//*[@id=\"hello\"]/div[2]/input");
     private By passwordField = By.xpath("//*[@id=\"hello\"]/div[3]/input");
     private By loginButton = By.xpath("//*[@id=\"hello\"]/div[4]/button");
	
	public void login(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();	
	}
	
	
	
	
	
	void DataReader() throws IOException, InterruptedException {
		
		 String excelFilePath = ".\\DataFolder\\EmpDetailsforAutomation.xlsx";

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
                    Aboutwhom(Aboutwhom);
                    System.out.print(r+" "+c+" "+ Aboutwhom + "\t"); break;
                    case 1: String GoalPlanName = formatter.formatCellValue(cell);
                    GoalPlanName(GoalPlanName);
                    System.out.print(r+" "+c+" "+ GoalPlanName + "\t");break;
                    case 2: String SelectForm = formatter.formatCellValue(cell);
                    SelectForm(SelectForm);
                    System.out.print(r+" "+c+" "+ SelectForm + "\t");break;
                    case 3: String Responder = formatter.formatCellValue(cell);
                    Responder(Responder);
                    System.out.print(r+" "+c+" "+ Responder + "\t");break;
             
                    }
                    
                }
                System.out.println(); // Move to the next line after each row
            }

	        // Close the workbook and input stream
	        workbook1.close();
	        inputStream.close();
	
	}
	
	
	
	void Aboutwhom(String Empname) throws InterruptedException {

//        About whom need be asked for Feedback 
        driver.findElement(By.xpath("//input[@placeholder=\"Select employee about whom you need to collect 360° feedback\"]")).sendKeys(Empname);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"selectize-dropdown-content\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[@class=\"menu-open ng-scope\"]")).click();
        Thread.sleep(3000);
	} 
	 
        void GoalPlanName(String GoalPalnName) throws InterruptedException {
//      Select goal plan name 
      driver.findElement(By.id("goalid")).click();
      Thread.sleep(3000);
      WebElement Select_Goalplan = driver.findElement(By.id("goalid"));
      Select select = new Select(Select_Goalplan);      
      Thread.sleep(2000);      
      select.selectByVisibleText(GoalPalnName);
      Thread.sleep(2000);
      driver.findElement(By.id("goalid")).click();
      Thread.sleep(2000);
        }
        void SelectForm(String Form) throws InterruptedException {
//        Select the Form to Ask feedback
        driver.findElement(By.xpath("//input[@placeholder=\"Select 360° Feedback form template from library\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder=\"Select 360° Feedback form template from library\"]")).sendKeys(Form);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"selectize-dropdown single\"]")).click();
        Thread.sleep(2000);
        }
        void Responder(String Responder) throws InterruptedException {
//      Select the Responder
        driver.findElement(By.xpath("//div[@class=\"selectize-input items not-full has-options\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Please enter minimum 2 character to search the employee\"]")).sendKeys(Responder);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=\"selectize-dropdown multi\"])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[@class=\"menu-open ng-scope\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    
	}

}
