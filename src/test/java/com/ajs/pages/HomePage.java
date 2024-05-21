package com.ajs.pages;

import com.ajs.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    private By btn_userSettings = By.xpath("//div[@class='oxd-topbar-header-userarea']//li");
    private By lnk_logout = By.xpath("//a[text()='Logout']");


    public HomePage clickUserSettings() {
        clickCustomElement(btn_userSettings, "User Settings");
        return this;
    }

    public LoginPage clickLogout() {
      clickCustomElement(lnk_logout,"Logout");
        return new LoginPage();
    }


}
