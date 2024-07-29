package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\programs\\WebDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input#login-button")).click();
        driver.findElement(By.xpath("//a[@id=\"item_4_title_link\"]")).click();
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("back-to-products")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='inventory_item_name '][1]"));
        String elementname = element.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
        System.out.println(elementname);

        driver.quit();


    }
}
