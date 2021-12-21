package dataProvider;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    
    public static void setExcelFile(String Path,String SheetName) throws Exception {
    	// Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream(Path);
    	 
    	 // Access the required test data sheet
    	 ExcelWBook = new XSSFWorkbook(ExcelFile);
    	 
    	 ExcelWSheet = ExcelWBook.getSheet(SheetName);
    }
    
    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {
			return "";
		}
		
	}
	
	public static int getRowsCount() {
		return ExcelWSheet.getLastRowNum();
	}
	
	public static int getColumnsCount() {
		return ExcelWSheet.getRow(0).getLastCellNum();
	}
	
	public static List<String> getColumnData(String colHeader){
		List<String> dataList = new ArrayList<String>();
		int colIndex = 0;
		int columnsCount = ExcelWSheet.getRow(0).getLastCellNum();
		for(int i=0; i<columnsCount; i++) {
			try {
				Cell = ExcelWSheet.getRow(0).getCell(i);
				String CellData = Cell.getStringCellValue();
				if(CellData.equals(colHeader)) {
					colIndex = i;
					break;
				}
			} catch (Exception e) {}
			
		}
		
		for(int i=1; i<=ExcelWSheet.getLastRowNum(); i++) {
			try {
				Cell = ExcelWSheet.getRow(i).getCell(colIndex);
				String CellData = Cell.getStringCellValue();
				dataList.add(CellData);
			}catch(Exception e) {}
		}
		return dataList;
	}

}
