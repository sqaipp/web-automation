package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] excelToObj(String excelLocation) {
        FileInputStream file;
        XSSFWorkbook workbook;
        try {
            file = new FileInputStream(excelLocation);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        XSSFSheet sheet = workbook.getSheetAt(0);
        int maxRow = sheet.getLastRowNum() + 1;
        int maxCol = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[maxRow][maxCol];

        if (maxCol == 0) {
            return null;
        } else {
            for (int i = 0; i < maxRow; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < maxCol; j++) {
                    obj[i][j] = row.getCell(j).toString();
                }
            }
        }
        return obj;
    }

    public static Object[][] excelToObjWithHeader(String excelLocation, int sheetIndex) {
        FileInputStream file;
        XSSFWorkbook workbook;
        try {
            file = new FileInputStream(excelLocation);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        int maxRow = sheet.getLastRowNum() + 1;
        int maxCol = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[maxRow - 1][maxCol];

        if (maxCol == 0) {
            return null;
        } else {
            for (int i = 1; i < maxRow; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < maxCol; j++) {
                    obj[i - 1][j] = row.getCell(j).toString();
                }
            }
        }
        return obj;
    }

}
