package com.ajs.reports;

import com.ajs.enums.ConfigProperties;
import com.ajs.utils.ReadPropertyFileUtils;
import com.ajs.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ReportLogger {

    private ReportLogger() {
    }

    public static void pass(String message) {
        if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
            ExtentReportManager.getExtTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.getbase64Screenshot()).build());
    }else {
        ExtentReportManager.getExtTest().pass(message);
    }

}

    public static void fail(String message) {
        if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentReportManager.getExtTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.getbase64Screenshot()).build());
        } else {
            ExtentReportManager.getExtTest().fail(message);
        }
    }

    public static void skip(String message) {
        if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentReportManager.getExtTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.getbase64Screenshot()).build());
        } else {
            ExtentReportManager.getExtTest().skip(message);
        }
    }
}
