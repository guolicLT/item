package com.guolic.library.util;

import java.util.Properties;

/**
 * 操作properties文件的工具类
 * @author Administrator
 *
 */
public class PropertiesUtil {

private PropertiesUtil() {
        
    }
    private static Properties properties;
    
    
    public static void setProperties(Properties properties) {
        PropertiesUtil.properties = properties;
    }



    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}
