package com.guolic.library.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    public StringUtil() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 生成时间字符串 yyyy-MM-dd: HH:mm:ss
     */

    public static String generateDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }

}
