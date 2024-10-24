package org.example.cucumber;

import io.cucumber.java.ru.Допустим;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsBase {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageUrl) {
        open(pageUrl);
        getWebDriver().manage().window().maximize();
        String currentPageUrl = getWebDriver().getCurrentUrl();
        assertEquals(pageUrl, currentPageUrl, "Адреса не совпадают");
    }
}
