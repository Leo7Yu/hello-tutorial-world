package cn.leo.util;

import java.text.NumberFormat;

public class NumberUtil {
    
    public static final String format(Number number,int fraction){
        NumberFormat numberFormat=NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(fraction);
        
        return numberFormat.format(number);
    } 
    
    public static final String formatToInteger(Number number){
        return format(number,0);
    }
    
    public static void main(String[] args) {
        String s="0.9";
        float f=Float.parseFloat(s);
        int i=(int)(f*100);
        System.out.println(s+":"+f+":"+i);
        
        double d1=1.3;
        double d2=3.43;
        double d3=d1+d2;
        System.out.println(d3);//4.73
        
        System.out.println(formatToInteger(794647.8222));
    }
}
