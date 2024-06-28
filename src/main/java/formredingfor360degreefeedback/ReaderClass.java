package formredingfor360degreefeedback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ReaderClass {

	    
	    private static final XSSFCell XSSFCell = null;

		public static void main(String[] args) throws IOException {
	        // Specify the path of the Excel file
	        String excelFilePath = ".\\DataFolder\\EmpDetailsforAutomation.xlsx";

	        // Create a FileInputStream to read from the Excel file
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

	        // Create a workbook object
//	        Workbook workbook = WorkbookFactory.create(inputStream);

	        // Get the first sheet
	        XSSFWorkbook workbook1 = new XSSFWorkbook(inputStream);
	        XSSFSheet sheet = workbook1.getSheetAt(0); // Assuming first sheet, index starts at 0
	        
//	        int rows = sheet.getLastRowNum();
//	        int col = sheet.getRow(1).getLastCellNum();
//	        // Iterate through each row
//	        for (int r=0; r<=rows ; r++){
//	            // Iterate through each cell in the row
//	        	XSSFRow row =sheet.getRow(rows);
//	            for (int c=0; c<=col ; c++) {	
//	                // Fetch the cell value
//	            	XSSFCell cell = row.getCell(c);
//	                String cellValue = cell.getStringCellValue();
//	                System.out.print(cellValue + "\t");
//	            }
//	            System.out.println(); // Move to the next line after each row
//	        }
//
//	        // Close the workbook and input stream
//	        workbook1.close();
//	        inputStream.close();
	        
	        
	        Iterator iterator = sheet.iterator();
	        while(iterator.hasNext())
	        {
	        	 XSSFRow  row = (XSSFRow) iterator.next();
	        	Iterator celliterator = row.iterator();
	        	while(celliterator.hasNext())
	        	{
	        		XSSFCell cell = (XSSFCell) celliterator.next();	
	        		switch(cell.getCellType())
	        		{
	        		case STRING : System.out.println(cell.getStringCellValue());
//	        		case NUMERIC :System.out.println(cell.getNumericCellValue());
//	        		case BOOLEAN :System.out.println(cell.getBooleanCellValue());
	        		}
//	        		System.out.print("  |  ");
	        	}
//	        	System.out.println("  |  ");
	        }
	        
	    }
	}



