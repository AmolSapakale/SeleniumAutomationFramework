package com.ajs.utils;

import com.ajs.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ReadExcelFileUtils {


    private ReadExcelFileUtils() {
    }

    static XSSFWorkbook workbook;

    static HashMap<String, String> map = null;

    public static Object[] getExcelData(String sheetName) {


        Object[] data;
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {

            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int totalRows = sheet.getLastRowNum();
            int totalColumns = sheet.getRow(0).getLastCellNum();
            data = new Object[totalRows];

            for (int i = 1; i <= totalRows; i++) {
                map = new HashMap<>();
                for (int j = 0; j < totalColumns; j++) {

                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                    data[i - 1] = map;


                }
            }
            System.out.println("********* Values derived from Excel test data input *********");
            for (Object temp : data) {

                System.out.println(temp);
            }
            return data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Map<String, String>> getExcelDataAndReturnList() {


        ArrayList<Map<String, String>> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {

            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("RUNMANAGER");

            int totalRows = sheet.getLastRowNum();
            int totalColumns = sheet.getRow(0).getLastCellNum();
            System.out.println("Total rows got is " + totalRows);
            System.out.println("Total columns got is " + totalColumns);


            for (int i = 1; i <= totalRows; i++) {
                map = new HashMap<>();
                for (int j = 0; j < totalColumns; j++) {

                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

            System.out.println("********* Values derived from Excel test data input *********");
            System.out.println(list);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Excel File you are trying to read is not found.");
        } catch (IOException e) {
            throw new RuntimeException("Internal IO exception happened while reading the excel file.");
        }
        return list;

    }

}
