package com.ajs.tests;

import com.ajs.driver.DriverUtils;
import com.ajs.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    protected BaseTest() {
    }

    @BeforeMethod
    public static void setUpDriver() {

    }

    @AfterMethod
    public static void quitDriver() {
        DriverUtils.tearDown();
    }


}
