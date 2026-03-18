package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelSheet {

	public static Object[][] excelDatas() throws EncryptedDocumentException, IOException {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDatas\\logintestdata.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		}

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet("loginsheet");

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		DataFormatter df = new DataFormatter();

		Object[][] getdata = new Object[rows - 1][columns];

		for (int a = 1; a < rows; a++) {
			Row row = sheet.getRow(a);
			for (int b = 0; b < columns; b++) {
				Cell cellvalue = row.getCell(b);
				String celldata = df.formatCellValue(cellvalue);
				getdata[a - 1][b] = celldata;
			}

		}
		return getdata;

	}

}
