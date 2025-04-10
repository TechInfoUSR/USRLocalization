package IPPB_Performence_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testclass {

	
	
	String Aboutwhom1;
	
	
	  void DataReader() throws IOException, InterruptedException {
			
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
	                 case 0: String Aboutwhom = formatter.formatCellValue(cell);
	                 Aboutwhom1=Aboutwhom;
	                 System.out.print(r+" "+c+" "+ Aboutwhom1 + "\t"); break;
	                 case 1: String GoalPlanName = formatter.formatCellValue(cell);
//	                 setUp(Aboutwhom1,GoalPlanName);
	                 System.out.print(r+" "+c+" "+ GoalPlanName + "\t");break;                   
	                 }
	                 
	             }
	             System.out.println(); // Move to the next line after each row
	         }

		        // Close the workbook and input stream
		        workbook1.close();
		        inputStream.close();
		
		}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Testclass Testclass= new Testclass();
		Testclass.DataReader();
	}
	
}
