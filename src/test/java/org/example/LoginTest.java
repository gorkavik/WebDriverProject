package org.example;

import org.example.helpers.ConfProperties;
import org.example.helpers.HomePage;
import org.example.helpers.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    @BeforeEach
    public void setup() {

        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.login();

        String getPageTitle = homePage.getPageTitle();
        Assertions.assertEquals( expectedHomePageTitle, getPageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
