package com.xdlv.fw;

import org.aspectj.weaver.ast.Call;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FwUtil {

	public static String UTF8 = "UTF-8";
    static int[] months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getValidateCode(){
        return String.format("%04d",Math.abs(new Random().nextInt(9999)));
    }

    public static Object getBean(String name){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return wac.getBean(name);
    }

    public static int getLastDayInMonth(int year,int month){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(String.format("%d-%d-%d 00:00:00",year,month,1)));
        } catch (ParseException e) {
            throw new IllegalArgumentException("can not parse data", e);
        }
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        return months[month];
    }

    public static int[] getLastMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return new int[]{calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) + 1};
    }
    public static void main(String[] args){
        for (int i=0;i<100;i++)
            System.out.println(getValidateCode());
    }
}
