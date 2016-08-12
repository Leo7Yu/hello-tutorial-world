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
}