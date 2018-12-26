package com.guolic.library.util;

import java.util.UUID;
/*
 * 返回一个唯一的ID；
 */
public class UUIDUtil {

    private UUIDUtil() {
    }
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }
}
