package com.ajs.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

    private ExtentReportManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();


    protected static void setExtTest(ExtentTest extref){
        extTest.set(extref);
    }

    protected static ExtentTest getExtTest(){
        return extTest.get();
    }

    protected static void unload(){
        extTest.remove();
    }


}
