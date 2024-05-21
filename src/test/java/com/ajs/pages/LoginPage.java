package com.ajs.pages;

import com.ajs.driver.DriverManager;
import com.ajs.utils.EncodeDecodeUtils;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage{


    private By txt_username = By.xpath("//input[@name='username']");
    private By txt_password = By.xpath("//input[@name='password']");
    private By btn_login = By.xpath("//button[@type='submit']");


    public LoginPage enterUsername(String username) {

        enterCustomText(txt_username,username,"Username");
        return this;
    }
    public LoginPage enterPassword(String password) {

        enterCustomText(txt_password, EncodeDecodeUtils.DecodeString(password),"Password");
        return this;

    }
    public HomePage clickLoginButton() {

        clickCustomElement(btn_login,"Login");
        return new HomePage();

    }
}
