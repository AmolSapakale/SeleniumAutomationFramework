package com.ajs.listeners;

import com.ajs.enums.ConfigProperties;
import com.ajs.utils.ReadPropertyFileUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")
                                                                                                            && count++<retries) {
            return  true;
        }
        return false;
    }
}
