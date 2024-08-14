package org.example.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    private SelenideElement firstNameField = $(By.id("firstName"));
    private SelenideElement lastNameField = $(By.id("lastName"));
    private SelenideElement userEmailField = $(By.id("userEmail"));
    private SelenideElement genderMaleRadio = $(By.xpath("//input[@id=\"gender-radio-1\"]/following-sibling::label"));
    private SelenideElement userNumberField = $(By.id("userNumber"));
    private SelenideElement dateOfBirthInputField = $(By.id("dateOfBirthInput"));
    private SelenideElement subjectsInputField = $(By.id("subjectsInput"));
    private SelenideElement hobbiesReadingCheckbox = $(By.xpath("//input[@id=\"hobbies-checkbox-2\"]/following-sibling::label"));
    private SelenideElement pictureUpload = $(By.id("uploadPicture"));
    private SelenideElement currentAddressField = $(By.id("currentAddress"));
    private SelenideElement stateSelect = $(By.xpath("//*[@id=\"state\"]"));
    private SelenideElement citySelect = $(By.xpath("//*[@id=\"city\"]"));
    private SelenideElement uttarPradeshStateSelected = $(By.id("react-select-3-option-1"));
    private SelenideElement lucknowCitySelected = $(By.id("react-select-4-option-1"));
    private SelenideElement submitBtn = $(By.id("submit"));

    public SelenideElement getFirstNameField() {
        return firstNameField;
    }

    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    public SelenideElement getUserEmailField() {
        return userEmailField;
    }

    public SelenideElement getGenderMaleRadio() {
        return genderMaleRadio;
    }

    public SelenideElement getUserNumberField() {
        return userNumberField;
    }

    public SelenideElement getDateOfBirthInputField() {
        return dateOfBirthInputField;
    }

    public SelenideElement getSubjectsInputField() {
        return subjectsInputField;
    }

    public SelenideElement getHobbiesReadingCheckbox() {
        return hobbiesReadingCheckbox;
    }

    public SelenideElement getPictureUpload() {
        return pictureUpload;
    }

    public SelenideElement getCurrentAddressField() {
        return currentAddressField;
    }

    public SelenideElement getStateSelect() {
        return stateSelect;
    }

    public SelenideElement getCitySelect() {
        return citySelect;
    }

    public SelenideElement getUttarPradeshStateSelected() {
        return uttarPradeshStateSelected;
    }

    public SelenideElement getLucknowCitySelected() {
        return lucknowCitySelected;
    }

    public SelenideElement getSubmitBtn() {
        return submitBtn;
    }

    public void fillInputs(
            String firstName,
            String lastName,
            String email,
            String mobileNum,
            String date,
            String subject,
            String currentAddress
    ){
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        userEmailField.setValue(email);
        userNumberField.setValue(mobileNum);
        dateOfBirthInputField.setValue(date).pressEnter();
        subjectsInputField.setValue(subject).pressEnter();
        currentAddressField.setValue(currentAddress);
    }
}
