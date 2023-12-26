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
		FileInputStream inputfile = new FileInputStream("\\C:\\Users\\lenovo\\Downloads\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputfile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(r);
		Cell cell = row.getCell(c);
	 stringValue=cell.getStringCellValue();
	 return stringValue;
	}
}
