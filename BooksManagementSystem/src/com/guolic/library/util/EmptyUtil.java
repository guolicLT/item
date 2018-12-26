package com.guolic.library.util;
/*
 * 判空
 * */
public class EmptyUtil {

    public EmptyUtil() {
        // TODO Auto-generated constructor stub
    }
    public static boolean isEmpty(String string) {
        if(string == null || "".equals(string.trim())) {
            return true;
        }
        return false;
        
    }

}
