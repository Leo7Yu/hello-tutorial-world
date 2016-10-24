package cn.leo.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static boolean isBlank(String... params) {
        for (String param : params) {
            if(StringUtils.isBlank(param)){
                return true;
            }
        }
        return false;
    }
    
    public static String replaceMiddle(String target){
        return target.replaceAll("(\\d{3})\\d{4}(\\d*)", "$1****$2");
    }
    
    public static void main(String[] args) {
        String result=replaceMiddle("6145");
        System.out.println(result);
    }
}