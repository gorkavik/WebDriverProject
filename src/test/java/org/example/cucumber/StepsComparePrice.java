package org.example.cucumber;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepsComparePrice {

    private static final Logger log = LoggerFactory.getLogger(StepsComparePrice.class);

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageUrl) {
        open(pageUrl);
        getWebDriver().manage().window().maximize();
        String currentPageUrl = getWebDriver().getCurrentUrl();
        assertEquals(pageUrl, currentPageUrl, "Адреса не совпадают");
    }

    @Когда("^выполнено нажатие на ссылку \"([^\"]*)\"$")
    public void clickOnLink(String link) {
        $(By.xpath("//*[contains(text(),\"" + link + "\")]")).click();
    }

    @Тогда("^цена книги равна \"([^\"]*)\"$")
    public void checkPrice(String price) {
        String actualPrice = $(By.xpath("//*[@class=\"product-price\"]/span")).getText();
        assertTrue(actualPrice.contains(price), "Цена не совпадает");
    }
}