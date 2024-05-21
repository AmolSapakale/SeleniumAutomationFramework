package com.ajs.tests;

import com.ajs.annotations.CustomAnnotation;
import com.ajs.driver.DriverManager;
import com.ajs.driver.DriverUtils;
import com.ajs.enums.ConfigProperties;
import com.ajs.enums.TestCategories;
import com.ajs.listeners.RetryAnalyzer;
import com.ajs.pages.LoginPage;
import com.ajs.utils.ReadExcelFileUtils;
import com.ajs.utils.ReadPropertyFileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginLogoutTest extends BaseTest {


    @CustomAnnotation(authors = {"Tester1"},categories = {TestCategories.SMOKE,TestCategories.REGRESSION})
    @Parameters("Browser")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test1(String browser) {
        DriverUtils.initDriver(browser);
        DriverManager.getDriver().get(ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.URL));

        LoginPage lp = new LoginPage();
        lp.enterUsername("Admin").enterPassword("admin123").clickLoginButton()
                                                    .clickUserSettings().clickLogout();

    }

    @CustomAnnotation(authors = {"Tester1,Tester2,Tester3"},categories = {TestCategories.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = LoginLogoutTest.class,retryAnalyzer = RetryAnalyzer.class)
    public void test2(HashMap<String,String> map) {
        DriverUtils.initDriver(map.get("browser"));
        DriverManager.getDriver().get(ReadPropertyFileUtils.getValueFromPropertyFile(ConfigProperties.URL));

        LoginPage lp = new LoginPage();
        lp.enterUsername(map.get("username")).enterPassword(map.get("password")).clickLoginButton()
                .clickUserSettings().clickLogout();
    }

    @DataProvider(parallel = true)
    public Object[] getData() {
        return ReadExcelFileUtils.getExcelData("Sheet1");
    }

//    @DataProvider(parallel = true)
//    public Object[] getData() {
//        return ReadJSONFile.getJsonData();
//    }

}
