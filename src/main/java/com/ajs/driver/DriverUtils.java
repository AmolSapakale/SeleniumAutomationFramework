package com.ajs.driver;

import com.ajs.enums.ConfigProperties;
import com.ajs.utils.ReadPropertyFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class DriverUtils {

    private DriverUtils() {
    }

    static WebDriver driver;


    //
//
    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {


            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.DOCKERRUN).equalsIgnoreCase("yes")) {
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("chrome");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                     DriverManager.setDriver(new ChromeDriver());
                }

            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                if (ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.DOCKERRUN).equalsIgnoreCase("yes")) {
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("edge");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), dc));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    DriverManager.setDriver(new EdgeDriver());
                }

            }
        }

    }


    public static void tearDown() {


        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
