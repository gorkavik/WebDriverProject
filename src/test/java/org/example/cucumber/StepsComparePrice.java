package org.example.cucumber;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepsComparePrice {

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
