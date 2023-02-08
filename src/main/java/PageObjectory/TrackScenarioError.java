package PageObjectory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TrackScenarioError {

	public static int sr=1;
	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet spreadsheet = workbook.createSheet("Error_Details");
	static XSSFRow row;
	static Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	public static void insertErrorIntoExcel(String fname,String sc_name,String fstepname,String error_mgs) throws IOException{
		String rowno=Integer.toString(++sr);
		String srno=Integer.toString(sr-1);
		
		studentData.put("1" , new Object[] { "Sr.No","Feature File","Scenario Name","Failed Step","Error Description"});
		studentData.put(rowno , new Object[] {srno,fname,sc_name,fstepname,error_mgs});
		Set<String> keyid = studentData.keySet();
		  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        
        //dynamic path 
        String path1="C:\\Work\\Cucumber_DataDrivenFramework_Exceptions\\Cucumber_DataDrivenFramework_Exceptions\\target\\ErrorExcel.xlsx";
        String path= System.getProperty("user.dir") + "//target//ErrorExcel.xlsx";
        
        File f=new File(path);
        FileOutputStream out = new FileOutputStream(f);
        if(f.exists()) {
        	System.out.println("Error file created successfully");
        }else {
        	System.out.println("prob while creating the file");
        }
        workbook.write(out);
        out.close();
		
		
	}
}
