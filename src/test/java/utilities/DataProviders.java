package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // DataProvider 1 - Hardcoded data

    @DataProvider(name = "LoginData1")
    public Object[][] getData1() {
        return new Object[][]{
                {"standard_user", "secret_sauce" , "Valid"},
                {"userInvalid", "secret_sauce","Invalid"},
                {"standard_user", "invalid","Invalid"},
                {"userInvalid", "invalid","Invalid"}
        };
    }


    // DataProvider 2 - Get data from excel file

    String excelFilePath = "./testData/TestData.xlsx";
    String xlSheet = "LoginCredentials";
    ExcelUtility dt = new ExcelUtility(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String [][] regData = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                regData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return regData;
    }

}
