package com.eternal.oneSoftPass.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5Utils {
    public static String getPWD( String str ){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception ignored) {
        }
        return null;
    }

}
