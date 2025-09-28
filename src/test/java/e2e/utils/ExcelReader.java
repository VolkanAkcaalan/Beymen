package e2e.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static String getSearchTerm(String filePath, int rowNum) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(0);

        String value = cell.getStringCellValue();

        workbook.close();
        fis.close();

        return value;
    }
}
