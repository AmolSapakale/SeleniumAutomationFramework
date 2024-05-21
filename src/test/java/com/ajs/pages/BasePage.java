package com.ajs.pages;

import com.ajs.constants.FrameworkConstants;
import com.ajs.driver.DriverManager;
import com.ajs.reports.ReportLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {


    protected WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.of(FrameworkConstants.getExplicitWaitTime(), TimeUnit.SECONDS.toChronoUnit()));

        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void enterCustomText(By by, String text,String elementName) {

        waitForElement(by).sendKeys(text);
        ReportLogger.pass("Entered "+ text + " successfully in "+elementName+".");
    }


    protected void clickCustomElement(By by,String elementName) {
        waitForElement(by).click();
        ReportLogger.pass("Clicked "+elementName+ " successfully.");
    }


}
