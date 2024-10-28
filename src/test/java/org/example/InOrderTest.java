package org.example;

import com.google.common.base.Verify;
import org.assertj.core.api.SoftAssertions;
import org.example.helpers.ConfProperties;
import org.example.helpers.HomePage;
import org.example.helpers.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.helpers.Issues.ERROR_MESSAGE_HARD_ASSERT;
import static org.example.helpers.Issues.ERROR_MESSAGE_SOFT_ASSERT;
import static org.example.helpers.Properties.WEBDRIVER_PROPERTY;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InOrderTest {

    private final String FIRST_ELEMENT_WRONG = "Sauce Labs New Backpack";
    private final String FIRST_ELEMENT = "Sauce Labs Backpack";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.login();
    }

    @Test
    @Disabled
    @Order(2)
    public void softAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Verify.verify(getFirstElement.equals(FIRST_ELEMENT), ERROR_MESSAGE_SOFT_ASSERT);
    }

    @Test
    @Disabled
    @Order(1)
    public void softAssertSecondTest() {
        String getFirstElement = homePage.getFirstItem();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(getFirstElement.equals(FIRST_ELEMENT));
    }

    @Test
    @Disabled
    @Order(3)
    public void hardAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Assertions.assertEquals(getFirstElement, FIRST_ELEMENT_WRONG, ERROR_MESSAGE_HARD_ASSERT);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
