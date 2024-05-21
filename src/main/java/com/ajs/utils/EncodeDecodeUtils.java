package com.ajs.utils;

import java.util.Base64;

public final class EncodeDecodeUtils {

    private EncodeDecodeUtils() {}

    public static String EncodeString(String text){

        return String.valueOf(Base64.getEncoder().encode(text.getBytes()));

    }
    public static String DecodeString(String text){

        return String.valueOf(Base64.getDecoder().decode(text.getBytes()));

    }
}
