package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet worksheet;
    public XSSFRow row;
    public XSSFCell cell;

    public XSSFCellStyle cellStyle;
    String path = null;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String xlsheet) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        int rowCount = worksheet.getLastRowNum();
        workbook.close();
        fi.close();

        return rowCount;
    }

    public int getCellCount(String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        row = worksheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();

        return cellCount;
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        row = worksheet.getRow(rownum);
        cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String ...
        } catch (Exception e) {
            data = "";
        }
        workbook.close();
        fi.close();
        return data;
    }
}
