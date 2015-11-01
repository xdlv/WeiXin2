package com.xdlv.fw.action;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by xd on 2015/10/31.
 */
public class T {
    public static void main(String[] args){
        try {
            parseFile(new File("C:\\Users\\xd\\Work\\WeiXing\\dz2.xlsx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Workbook parseFile(File excelFile) throws Exception{
        Workbook book = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(excelFile);
            book = new HSSFWorkbook(inputStream);
        } catch (Exception ex) {
            book = new XSSFWorkbook(excelFile);
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return book;
    }
}
