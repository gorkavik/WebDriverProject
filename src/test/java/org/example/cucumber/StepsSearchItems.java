package org.example.cucumber;

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
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StepsSearchItems {

    private static final Logger log = LoggerFactory.getLogger(StepsSearchItems.class);

    @Когда("в поле поиска введено значение {string}")
    public void enterValue(String value) {
        $(By.className("search-box-text")).setValue(value);
    }

    @И("нажата кнопка {string}")
    public void clickButton(String button) {
        $(By.className("search-box-button")).click();
    }

    @Тогда("найден товар {string}")
    public void findItem(String value) {
        List<String> list = new ArrayList<>();
        for (WebElement webElement : getWebDriver().findElements(
                By.xpath("//*[@class='product-title']/a[contains(text(),\"" + value + "\")]"))) {
            list.add(webElement.getText());
        }

        log.info("Найдено элементов -- " + list.size());
        assertFalse(list.isEmpty(), "Элемент не найден");
    }
}
