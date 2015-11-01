package com.xdlv.fw;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

public class FwUtil {

	public static String UTF8 = "UTF-8";
    static int[] months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};

	public static String getValidateCode(){
        return String.format("%04d",Math.abs(new Random().nextInt(9999)));
    }

    public static Object getBean(String name){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return wac.getBean(name);
    }

    public static int getLastDayInMonth(int month){
        return months[month];
    }
    public static void main(String[] args){
        for (int i=0;i<100;i++)
            System.out.println(getValidateCode());
    }
}
