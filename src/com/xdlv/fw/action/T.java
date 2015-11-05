package com.xdlv.fw.action;

import com.xdlv.fw.FwUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;

/**
 * Created by xd on 2015/10/31.
 */
public class T {
    public static void main(String[] args){
        try {
            System.out.println(FwUtil.getLastMonth());
            //parseFile(new File("C:\\Users\\xd\\Work\\WeiXing\\dz2.xlsx"));
            //System.out.println(String.format("%0d",1234556));
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
