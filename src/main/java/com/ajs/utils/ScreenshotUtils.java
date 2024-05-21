package com.ajs.utils;

import com.ajs.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public final class ScreenshotUtils {
private ScreenshotUtils() {}

    public static String getbase64Screenshot(){

       return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
