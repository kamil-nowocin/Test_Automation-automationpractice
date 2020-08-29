package com.buildSettings;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class ExcelEnvironment extends TestEnvironment {

    private static XSSFRow excelRow;
    public static int excelRowNumber;
    private static XSSFSheet excelSheet;
    private static XSSFWorkbook excelWorkBook;
    private static String testDataExcelPath = null;

    public static int CUCUMBER_RESULT_COUNTER_ROW = 1;
    public static final int EXCEL_TC_NAME_COLUMN = 0;
    public static final int EXCEL_TC_RESULT_COLUMN = 4;
    public static final String TEST_DATA_EXCEL_FILE_NAME = "testdata.xlsx";
    public static final String TEST_DATA_EXCEL_SHEET_NAME = "automationData";

    public void setExcelRowNumber(int rowNumber) {
        excelRowNumber = rowNumber;
    }

    public int getExcelRowNumber() {
        return excelRowNumber;
    }

    public void saveTestResultsXLSX(int whichRowNumber) {
        setExcelRowNumber(whichRowNumber);
    }

    public void setExcelSheet(String excelSheetName) {
        testDataExcelPath = getCurrentPath()
                + File.separator
                + "src"
                + File.separator
                + "test"
                + File.separator
                + "resources"
                + File.separator
                + "files"
                + File.separator;
        try {
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + TEST_DATA_EXCEL_FILE_NAME);
            excelWorkBook = new XSSFWorkbook(ExcelFile);
            excelSheet = excelWorkBook.getSheet(excelSheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public XSSFRow getRowData(int rowNumber) {
        excelRow = excelSheet.getRow(rowNumber);
        return excelRow;
    }

    public void setCellData(int rowNumber, String stringValue, int columnNumber) {
        try {
            excelRow = excelSheet.getRow(rowNumber);
            XSSFCell excelCell = excelRow.getCell(columnNumber);
            excelCell.setCellValue(stringValue);
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + TEST_DATA_EXCEL_FILE_NAME);
            excelWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}