package cn.leo.util;

public class NumberUtil {
    
    public static void main(String[] args) {
        String s="0.9";
        float f=Float.parseFloat(s);
        int i=(int)(f*100);
        System.out.println(s+":"+f+":"+i);
    }
}
