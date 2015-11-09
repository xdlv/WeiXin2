package com.xdlv.fw.action;

import com.xdlv.fw.FwUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 * Created by xd on 2015/10/31.
 */
public class T {
    public static void main(String[] args)throws Exception{
        //executeSql("select * from t_import_dz_record");
        //executeSqlUpdate("delete from t_import_dz_record");
        System.out.println(FwUtil.getLastDayInMonth(2015,1));
    }

    static void executeSql(String sql)throws Exception{
        //jdbc.username=weixin
        //jdbc.password=hs_sst_cms_sst
        //jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
        //jdbc.url=jdbc:oracle:thin:@127.0.0.1:1521:ORA10G
        //jdbc.validate=select 1 from dual
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@127.0.0.1:1521:ORA10G", "weixin", "hs_sst_cms_sst");
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                for (int i=0;i<resultSet.getMetaData().getColumnCount();i++){
                    System.out.println(resultSet.getString(i+1));
                }
            }
            resultSet.close();
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    static void executeSqlUpdate(String sql)throws Exception{
        //jdbc.username=weixin
        //jdbc.password=hs_sst_cms_sst
        //jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
        //jdbc.url=jdbc:oracle:thin:@127.0.0.1:1521:ORA10G
        //jdbc.validate=select 1 from dual
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@127.0.0.1:1521:ORA10G", "weixin", "hs_sst_cms_sst");
            int c = connection.createStatement().executeUpdate(sql);
            System.out.println(c);
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    static Workbook parseFile(File excelFile) throws Exception{
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
