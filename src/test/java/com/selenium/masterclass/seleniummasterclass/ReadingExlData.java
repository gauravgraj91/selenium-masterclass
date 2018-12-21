package com.selenium.masterclass.seleniummasterclass;

import com.selenium.masterclass.seleniummasterclass.Utilities.ExcelReader;

public class ReadingExlData {

    public static String DATA_SHEET = "SearchData";
    ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");

    int rows = excel.getRowCount(DATA_SHEET);

}
