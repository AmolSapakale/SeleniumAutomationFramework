package com.ajs.listeners;

import com.ajs.annotations.CustomAnnotation;
import com.ajs.driver.DriverUtils;
import com.ajs.enums.TestCategories;
import com.ajs.reports.ExtentReport;
import com.ajs.reports.ExtentReportManager;
import com.ajs.reports.ReportLogger;
import com.aventstack.extentreports.model.Report;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).authors();
        ExtentReport.addAuthors(authors);
        TestCategories[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).categories();
        ExtentReport.addCategories(categories);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportLogger.pass("Test is completed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ReportLogger.fail(result.getThrowable().toString());
        ReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ReportLogger.fail("Test got failed.");

    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ReportLogger.skip("Test got skipped");

    }


    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }
}
