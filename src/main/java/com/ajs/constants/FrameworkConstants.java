package com.ajs.constants;

import com.ajs.enums.ConfigProperties;
import com.ajs.utils.ReadPropertyFileUtils;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGPROPERTYFILEPATH = getResourcesPath() + "/config.properties";
    private static final int EXPLICITWAITTIME = 10;
    private static final String EXCELFILEPATH = getResourcesPath() + "/testdata.xlsx";
    private static final String JSONFILEPATH = getResourcesPath() + "/testdata.json";
    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "/test-output-reports";
    private static String extentReportsFilePath = "";


    public static String getResourcesPath() {
        return RESOURCESPATH;
    }

    public static String getConfigPropertyFilePath() {

        return CONFIGPROPERTYFILEPATH;
    }

    public static int getExplicitWaitTime() {
        return EXPLICITWAITTIME;
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    public static String getJSONFilePath() {
        return JSONFILEPATH;
    }

    public static String getExtentReportsFolderPath() {
        return EXTENTREPORTSFOLDERPATH;
    }

    public static String getExtentReportsFilePath() {
        if (extentReportsFilePath.isEmpty()) {
            extentReportsFilePath=createDynamicReportPath();
        }
        return extentReportsFilePath;
    }


    private static String createDynamicReportPath() {
        if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {

            return EXTENTREPORTSFOLDERPATH + "/index.html";

        } else {
            return EXTENTREPORTSFOLDERPATH + "/"+System.currentTimeMillis() + "/index.html";
        }
    }
}

