package com;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class ExcelEnvironment extends FrameworkEnvironment {

    public static String testDataExcelPath = null;
    public static int rowNumber;
    public static int columnNumber;
    public static int columnNumber2;
    private static XSSFWorkbook excelWorkBook;
    private static XSSFSheet excelSheet;
    private static XSSFCell excelCell;
    private static XSSFCell excelCell2;
    private static XSSFRow excelRow;
    private static final String testDataExcelFileName = "testdata.xlsx";

    public static void setRowNumber(int _rowNumber) {
        rowNumber = _rowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int _columnNumber) {
        columnNumber = _columnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    public static void setColumnNumber2(int _columnNumber2) {
        columnNumber2 = _columnNumber2;
    }

    public static int getColumnNumber2() {
        return columnNumber2;
    }

    public static void setExcelSheet(String sheetName) {
        testDataExcelPath = FrameworkEnvironment.getCurrentPath()
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
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWorkBook = new XSSFWorkbook(ExcelFile);
            excelSheet = excelWorkBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static XSSFRow getRowData(int RowNum) {
        try {
            excelRow = excelSheet.getRow(RowNum);
            return excelRow;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static void setCellData(int RowNum, String firstValue, int ColNum, String secondValue, int ColNum2) {
        try {
            excelRow = excelSheet.getRow(RowNum);
            excelCell = excelRow.getCell(ColNum);
            excelCell2 = excelRow.getCell(ColNum2);
            if (excelCell == null) {
                excelCell = excelRow.createCell(ColNum);
                excelCell.setCellValue(firstValue);
                excelCell2 = excelRow.createCell(ColNum2);
                excelCell2.setCellValue(secondValue);
            } else {
                excelCell.setCellValue(firstValue);
                excelCell2.setCellValue(secondValue);
            }
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTestResultsXLSX(int whichRowNumber) {
        ExcelEnvironment.setRowNumber(whichRowNumber);
        ExcelEnvironment.setColumnNumber(EXCEL_TC_NAME);
        ExcelEnvironment.setColumnNumber2(EXCEL_TC_RESULT);
    }
}