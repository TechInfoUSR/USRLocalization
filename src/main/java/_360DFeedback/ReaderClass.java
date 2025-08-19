package _360DFeedback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

public class ReaderClass {
	

	    private static final XSSFCell XSSFCell = null;

		public static void main(String[] args) throws IOException {

//			
			 String excelFilePath = ".\\DataFolder\\EmpDetailsforAutomation.xlsx";

		        // Create a FileInputStream to read from the Excel file
		        try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

		            // Get the first sheet
		            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming first sheet, index starts at 0

		            int rows = sheet.getLastRowNum();
		            int cols = sheet.getRow(0).getLastCellNum();

		            DataFormatter formatter = new DataFormatter();

		            // Iterate through each row
		            for (int r = 0; r <= rows; r++) {
		                XSSFRow row = sheet.getRow(r);
		                if (row == null) {
		                    continue; // Skip empty rows
		                }

		                // Iterate through each cell in the row
		                for (int c = 0; c < cols; c++) {
		                    XSSFCell cell = row.getCell(c);
		                    switch(r)
		                    {
		                    case 0: String cellValue = formatter.formatCellValue(cell);
		                    System.out.print(r+" "+c+" "+ cellValue + "\t"); break;
		                    case 1: String cellValue1 = formatter.formatCellValue(cell);
		                    System.out.print(r+" "+c+" "+ cellValue1 + "\t");break;
		                    case 2: String cellValue2 = formatter.formatCellValue(cell);
		                    System.out.print(r+" "+c+" "+ cellValue2 + "\t");break;
		                    case 3: String cellValue4 = formatter.formatCellValue(cell);
		                    System.out.print(r+" "+c+" "+ cellValue4 + "\t");break;
		                    
		                    
		                    }
//		                    if(r==0 ) {
//		                    	String cellValue = formatter.formatCellValue(cell);
//			                    System.out.print(r+" "+c+" "+ cellValue + "\t");
//		                    }
//		                    if (r==1 ) {
//		                    	String cellValue = formatter.formatCellValue(cell);
//			                    System.out.print(r+" "+c+" "+ cellValue + "\t");
//		                    }
//		                    if(r==3 ) {
//		                    	String cellValue = formatter.formatCellValue(cell);
//			                    System.out.print(r+" "+c+" "+ cellValue + "\t");
//		                    }
//		                    if(r==4 ) {
//		                    	String cellValue = formatter.formatCellValue(cell);
//			                    System.out.print(r+" "+c+" "+ cellValue + "\t");
//		                    }
//		                    else if (cell == null) {
//		                        System.out.print("\t");
//		                        continue; // Skip empty cells
//		                    }

		                    // Fetch the cell value
		                    
		                }
		                System.out.println(); // Move to the next line after each row
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        
//	        Iterator iterator = sheet.iterator();
//	        while(iterator.hasNext())
//	        {
//	        	 XSSFRow  row = (XSSFRow) iterator.next();
//	        	Iterator celliterator = row.iterator();
//	        	while(celliterator.hasNext())
//	        	{
//	        		XSSFCell cell = (XSSFCell) celliterator.next();	
//	        		switch(cell.getCellType())
//	        		{
//	        		case STRING : System.out.println(cell.getStringCellValue());
////	        		case NUMERIC :System.out.println(cell.getNumericCellValue());
////	        		case BOOLEAN :System.out.println(cell.getBooleanCellValue());
//	        		}
////	        		System.out.print("  |  ");
//	        	}
////	        	System.out.println("  |  ");
//	        }
	        
	    }

	}



