package com.ajs.reports;

import com.ajs.constants.FrameworkConstants;
import com.ajs.enums.TestCategories;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
    }

    static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportsFilePath());
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("P1 Reporting");

        }
    }


    public static void tearDownReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentReportManager.unload();
        }

        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportsFilePath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String testCaseName) {
        ExtentTest extentTest = extent.createTest(testCaseName);

        ExtentReportManager.setExtTest(extentTest);

    }

    public static void addAuthors(String[] authors) {
        for (String author : authors)
            ExtentReportManager.getExtTest().assignAuthor(author);
    }

    public static void addCategories(TestCategories[] categories) {
        for (TestCategories category : categories)
            ExtentReportManager.getExtTest().assignAuthor(String.valueOf(category));
    }


}
