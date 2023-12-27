package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtil {
	public String readExcelData (int r, int c) throws IOException {
		String stringValue=null;
		String inputfile = System.getProperty("user.dir")+"/src/test/resources/Book1.xlsx";
		 try (FileInputStream fis = new FileInputStream(inputfile);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	            XSSFSheet sheet = workbook.getSheet("Employeedetails");
	            XSSFRow row = sheet.getRow(r);
	            Cell cell = row.getCell(c);
	            stringValue = cell.getStringCellValue();
	        }
	 return stringValue;
	}
}
