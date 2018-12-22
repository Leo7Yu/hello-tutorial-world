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
    
    public static final void compare() {
    	Integer i1 = 120;
		Integer i2 = 120;

		System.out.println(i1==i2);
		
		int ii1=200;
		int ii2=200;
		System.out.println(ii1==ii2);


		Integer i3 = new Integer(200);
		Integer i4 = new Integer(200);

		System.out.println(i3==i4);
		System.out.println(ii2==i4);
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
