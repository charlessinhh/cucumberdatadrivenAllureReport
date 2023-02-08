package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public  String value;
	FileInputStream file;
	// Main driver method
    public  String readObj(String path,String key,String sheetname) throws IOException
    {
  
        // Try block to check for exceptions
        try {
  
            // Reading file from local directory
        	 file = new FileInputStream(
                new File(path));
  
            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
  
            // Get first/desired sheet from the workbook
            
            XSSFSheet sheet = workbook.getSheet(sheetname);
  
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
  
            // Till there is an element condition holds true
            while (rowIterator.hasNext()) {
  
                Row row = rowIterator.next();
  
                // For each row, iterate through all the
                // columns
                Iterator<Cell> cellIterator
                    = row.cellIterator();
  
                while (cellIterator.hasNext()) {
  
                    Cell cell = cellIterator.next();
                    if(cell.getStringCellValue().equals(key)) {
                    	value=cellIterator.next().getStringCellValue();
                    	
                    }
                    
  
                    
                    }
                }
             
            // Closing file output streams
           
            
            
        }
  
        // Catch block to handle exceptions
        catch (NullPointerException nl) {
            System.out.println("Sheet Name or Field Name Should not be empty");
            System.exit(0);
        }
        catch (IOException nl) {
            System.out.println("Problem Occurred While Reading ExcelFile");
            System.exit(0);
        }
        finally{
        	file.close();
        }
		return value;
    }

}

