package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataExcel(String sheetName,int rowNum,int cellNum) throws Exception {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		Sheet s=w.getSheet(sheetName);
		Row r=s.getRow(rowNum);
		Cell c=r.getCell(cellNum);
		
		DataFormatter formatter=new DataFormatter();
		return formatter.formatCellValue(c);
		
	}
}
