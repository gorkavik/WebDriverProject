import io.qameta.allure.Step;
import org.example.cucumber.StepsSearchItems;
import org.example.helpers.ConfProperties;
import org.example.helpers.HomePage;
import org.example.helpers.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    private static final Logger log = LoggerFactory.getLogger(StepsSearchItems.class);

    @BeforeAll
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

//        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    @Step("Первый шаг")
    public void loginTest() {
        log.info("Тест начинается -- ");
        loginPage.login();

        String getPageTitle = homePage.getPageTitle();
        Assertions.assertEquals(expectedHomePageTitle, getPageTitle, ERROR_MESSAGE_AFTER_LOGIN);
        log.info("Тест заканчивается -- getPageTitle=" + getPageTitle);
    }

    @Test
    @Step("Второй шаг")
    public void loginSecondTest() {
        log.info("Тест начинается -- ");
        loginPage.login();

        String getPageTitle = homePage.getPageTitle();
        Assertions.assertEquals(expectedHomePageTitle, getPageTitle, ERROR_MESSAGE_AFTER_LOGIN);
        log.info("Тест заканчивается -- getPageTitle=" + getPageTitle);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
