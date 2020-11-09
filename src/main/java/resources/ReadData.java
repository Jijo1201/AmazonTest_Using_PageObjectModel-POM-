package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static FileInputStream fileInputStream;
	public static FileOutputStream fileOutputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String filename, String sheetName) throws IOException {

		fileInputStream = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		int rowscount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowscount;

	}

	public static int getCellData(String filename, String sheetName, int rowNum) throws IOException {

		fileInputStream = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellCount;

	}

	public static String getCellData(String filename, String sheetName, int rowNum, int colNum) throws IOException {
		fileInputStream = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
			DataFormatter dataFormatter = new DataFormatter();
			String cellData = dataFormatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileInputStream.close();
		return data;

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		FileInputStream ExcelFile = new FileInputStream(
				"C:\\Users\\{USER}\\new\\eclipse-workspace\\Practical\\AmazonTest\\src\\main\\java\\resources\\Data.xlsx");

		workbook = new XSSFWorkbook(ExcelFile);

		sheet = workbook.getSheet("login");		

		String CellValue = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

		return CellValue;

	}

}
