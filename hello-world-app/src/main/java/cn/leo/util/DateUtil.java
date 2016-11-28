package cn.leo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    public static final String DATE_INTEGER_FORMAT = "yyyyMMdd";
    public static final String DATE_NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);

    public static final Date parseNormalFormat(String dateString)
            throws ParseException {
        return new SimpleDateFormat(DATE_NORMAL_FORMAT).parse(dateString);
    }

    public static final String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static final String formatAsClean(Date date) {
        return format(date, DATE_INTEGER_FORMAT);
    }

    public static final Integer formatAsInteger(Date date) {
        String value = format(date, DATE_INTEGER_FORMAT);
        return Integer.parseInt(value);
    }

    public static final Date addMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static final Date addDays(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

    public static final Long computRange(Date begin, Date end) {
        return end.getTime() - begin.getTime();
    }

    public static final Date getYesterdayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static final Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        long timestamp = 1479372865079L;
        Timestamp ts = new Timestamp(timestamp);
        Date date =ts;
        System.out.println(date);
        ts = new Timestamp(1479369357853L);
        date =ts;
        System.out.println(date);
        
        long l=TimeUnit.MINUTES.toMillis(30);
        System.out.println(l);
    }
}
