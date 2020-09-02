package cn.leo.lambda;

import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;

/**
 * @author leo 2020/9/2 3:39 下午
 **/
public class Chapter2 {

    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal
        .withInitial(() -> new DateFormatter(new SimpleDateFormat("")));

    public static void main(String[] args) {
    }
}
