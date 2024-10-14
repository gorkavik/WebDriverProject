package org.example.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.example.helpers.Issues.ERROR_MESSAGE_GENERAL;
import static org.example.helpers.Properties.PRACTICE_FORM_SELENIDE;

public class PracticeFormTest {

    private String FILE_PATH_FOR_UPLOAD = "src/test/resources/2024-08-14 12.50.26.jpg";
    private String expectedModalTitle = "Thanks for submitting the form";

    @Test
    public void fillPracticeFormTest() {
        open(PRACTICE_FORM_SELENIDE);
        PracticeForm practiceForm = new PracticeForm();
        practiceForm.fillInputs("John", "Wick", "somemail@mail.com", "1234567890",
                                "14 Aug 2024", "Maths", "Some street");
        practiceForm.getGenderMaleRadio().click();
        practiceForm.getHobbiesReadingCheckbox().click();
        practiceForm.getPictureUpload().uploadFile(new File(FILE_PATH_FOR_UPLOAD));
        practiceForm.getSubmitBtn().scrollTo();
        practiceForm.getStateSelect().click();
        practiceForm.getUttarPradeshStateSelected().shouldBe(visible).click();
        practiceForm.getCitySelect().click();
        practiceForm.getLucknowCitySelected().shouldBe(visible).click();
        practiceForm.getSubmitBtn().click();

        SelenideElement modalTitle =
                $(By.xpath("//div[@class=\"modal-dialog modal-lg\"]//div[@id=\"example-modal-sizes-title-lg\"]"));
        String getModalTitle = modalTitle.getText();
        Assertions.assertEquals(expectedModalTitle, getModalTitle, ERROR_MESSAGE_GENERAL);
    }
}
