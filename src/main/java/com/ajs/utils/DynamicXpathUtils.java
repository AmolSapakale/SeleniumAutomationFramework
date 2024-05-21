package com.ajs.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
    }

    public static String getDynamicXpath(String xpath, String replaceableValue) {

        return xpath.replace("%replaceMe%", replaceableValue);
    }

    public static String getDynamicXpathWithStringFormatter(String xpath, String replaceableValue) {
        //By element = By.xpath("//a[text()='%s']");
        return String.format(xpath, replaceableValue);

    }
}
