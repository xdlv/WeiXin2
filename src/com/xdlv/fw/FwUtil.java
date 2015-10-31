package com.xdlv.fw;

import java.util.Random;

public class FwUtil {

	public static String UTF8 = "UTF-8";

	public static String getValidateCode(){
        return String.format("%04d",Math.abs(new Random().nextInt(9999)));
    }

    public static void main(String[] args){
        for (int i=0;i<100;i++)
            System.out.println(getValidateCode());
    }
}
