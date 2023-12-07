import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\programs\\WebDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#login-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id=\"item_4_title_link\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@class='inventory_item_name '][1]"));
        String elementname = element.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
        System.out.println(elementname);


        Thread.sleep(5000);

        driver.close();
        driver.quit();


    }
}
