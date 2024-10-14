package org.example.selenide;

import com.codeborne.selenide.SelenideElement;
import org.example.helpers.ConfProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageSelenide {

    private SelenideElement loginField = $(By.id("user-name"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement loginBtn = $(By.cssSelector("input#login-button"));

    public void login() {
        loginField.setValue(ConfProperties.getLogin());
        passwordField.setValue(ConfProperties.getPassword());
        loginBtn.click();
    }
}
