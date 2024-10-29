package org.example.selenide;

import org.example.helpers.ConfProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.example.helpers.Issues.ERROR_MESSAGE_AFTER_LOGIN;

public class LoginSelenideTest {

    private static String expectedHomePageTitle = "Products";

    @Test
    public void loginTest() {
        open(ConfProperties.getLoginPage());
        LoginPageSelenide loginPageSelenide = new LoginPageSelenide();
        loginPageSelenide.login();

        String getPageTitle = $(By.className("title")).getText();
        Assertions.assertEquals(expectedHomePageTitle, getPageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }
}
