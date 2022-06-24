package salesforce.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFile {

	public static String[][] ereadfile(String SheetName) throws IOException {

		XSSFWorkbook excel = new XSSFWorkbook("./TestData/AllDetails.xlsx");
		XSSFSheet sheet = excel.getSheet(SheetName);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();

		String[][] x = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j <lastCellNum; j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				x[i - 1][j] = value;
			}

		}
		excel.close();
		return x;

	}

}
