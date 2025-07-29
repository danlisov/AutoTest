import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TrueconfLoginTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://trueconf.ru/login.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test

    public void errorWithEmptyField() {
        var submitButton = By.cssSelector("[type='submit']");

        driver.findElement(submitButton).click();

        String expected = "Поле TrueConf ID не заполнено.\nПоле Пароль не заполнено.";
        String actual = driver.findElement(By.cssSelector("[class='error']")).getText().trim();

        assertEquals(expected, actual);
    }
}
