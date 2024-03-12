package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddToCart {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @Test
    public void addToCartTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        driver.findElement(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory \"]")).click();
        homePage.clickCartButton();

        int count  = driver.findElements(By.xpath("//div[@class='cart_item']")).size();
        Assert.assertTrue(count==0);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit(); }
}
