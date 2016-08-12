package cn.leo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DATE_INTEGER_FORMAT = "yyyyMMdd";
    
    public static final String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
    
    public static final String formatAsClean(Date date){
        return format(date, DATE_INTEGER_FORMAT);
    }
    
    public static final Integer formatAsInteger(Date date) {
        String value = format(date, DATE_INTEGER_FORMAT);
        return Integer.parseInt(value);
    }
}
