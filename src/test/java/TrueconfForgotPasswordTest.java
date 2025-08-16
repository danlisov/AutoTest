import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.attribute.Attribute;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TrueconfForgotPasswordTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://trueconf.ru/login.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("#forgot-password")).click();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void openPageForgotPassword() {
        String expected = "Забыли пароль или TrueConf ID?";
        String actual = driver.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void forgotPasswordInfoStepOne() {
        String expected = "Забыли пароль или TrueConf ID?\n" +
                "Шаг 1\n" +
                "Пожалуйста, введите TrueConf ID или адрес электронной почты, которые вы указали при регистрации.\n" +
                "E-mail или TrueConf ID\n" +
                "\n" +
                "\n" +
                "Восстановить\n" +
                "Видеоконференция » Список продуктов » Сервис видеоконференций TrueConf Online » Восстановление пароля";
        String actual = driver.findElement(By.className("outside-index")).getText();
        assertEquals(expected, actual);
    }

    @Test
    public void errorTextForEmptyField() {
        var forgotButton = driver.findElement(By.cssSelector(".btn" + ".light-blue" +
                ".darken-2" + ".waves-effect"));
        forgotButton.click();

        String expected = "Поле не заполнено";
        String actual = driver.findElement(By.className("info")).getText();

        assertEquals(expected, actual);
    }

    @Test
    public void errorTextStyleForEmptyField() {
        var forgotButton = driver.findElement(By.cssSelector(".btn" + ".light-blue" +
                ".darken-2" + ".waves-effect"));
        forgotButton.click();

        String expected = "color: red;";
        String actual = driver.findElement(By.cssSelector(".info")).getAttribute("style");

        assertEquals(expected, actual);
    }

    @Test
    public void textForValidMail() {
        var mail = driver.findElement(By.cssSelector("#recoverLogin"));
        mail.sendKeys("test@trueconf.com");

        String expected = "Формат верен";
        String actual = driver.findElement(By.className("info")).getText();

        assertEquals(expected, actual);
    }

    @Test
    public void styleTextForValidMail() {
        var mail = driver.findElement(By.cssSelector("#recoverLogin"));
        mail.sendKeys("test@trueconf.com");

        String expected = "color: green;";
        String actual = driver.findElement(By.cssSelector(".info")).getAttribute("style");

        assertEquals(expected, actual);
    }

    @Test
    public void inputValidEmail() {
        var mail = driver.findElement(By.cssSelector("#recoverLogin"));
        var forgotButton = driver.findElement(By.cssSelector(".btn" + ".light-blue" +
                ".darken-2" + ".waves-effect"));
        mail.sendKeys("test@trueconf.com");
        forgotButton.click();

        String expected = "Забыли пароль или TrueConf ID?\n" +
                "Шаг 2\n" +
                "\n" +
                "Письмо с ссылкой для восстановления пароля отправлено на адрес электронной почты, на который была зарегистрирована ваша учетная запись.\n" +
                "← Назад" +
                "Видеоконференция » Список продуктов » Сервис видеоконференций TrueConf Online » Восстановление пароля";
        String actual = driver.findElement(By.cssSelector(".outside-index")).getText();
        assertEquals(expected, actual);
    }
}
