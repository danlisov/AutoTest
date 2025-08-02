import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
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

    @Test

    public void openNationalChannel() {
        var urlButton = By.cssSelector(".news-banner__container");

        driver.findElement(urlButton).click();

        String expected = "https://trueconf.ru/blog/press-release/kanal-rt-provodit-efiry-s-videosvyazyu-trukonf";
        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);
    }

    @Test

    public void openHomePage() {
        var logoButton = By.cssSelector(".header-menu__logo-link");

        driver.findElement(logoButton).click();

        String expected = "https://trueconf.ru/";
        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);
    }

    @Test

    public void openPageForgotPassword() {
        var logoButton = By.cssSelector("#forgot-password");

        driver.findElement(logoButton).click();

        String expected = "https://trueconf.ru/products/online/password-reset.html?login=";
        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);
    }

    @Test

    public void openProductsPageWithClass() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-1"));
        var products = driver.findElement(By.cssSelector("#hm-menu-1"));

        urlButton.click();
        String expected = "header-menu__popup header-menu__popup--open";

        assertEquals(expected, products.getAttribute("class"));
    }

    @Test

    public void openProductsPageWithHidden() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-1"));
        var products = driver.findElement(By.cssSelector("#hm-menu-1"));

        urlButton.click();
        String expected = "false";

        assertEquals(expected, products.getAttribute("aria-hidden"));
    }

    @Test

    public void openPagePossibilitiesWithClass() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-2"));
        var products = driver.findElement(By.cssSelector("#hm-menu-2"));

        urlButton.click();
        String expected = "header-menu__popup header-menu__popup--open";

        assertEquals(expected, products.getAttribute("class"));
    }

    @Test

    public void openPagePossibilitiesWithHidden() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-2"));
        var products = driver.findElement(By.cssSelector("#hm-menu-2"));

        urlButton.click();
        String expected = "false";

        assertEquals(expected, products.getAttribute("aria-hidden"));
    }

    @Test

    public void openPricePage() {
        var priceBtn = driver.findElement(By.cssSelector(".header-menu__nav-item" + ".header-menu__nav-item--link"));

        priceBtn.click();

        String expected = "https://trueconf.ru/prices/server-price.html";
        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);
    }

    @Test

    public void openPageCompanyWithClass() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-4"));
        var products = driver.findElement(By.cssSelector("#hm-menu-4"));

        urlButton.click();
        String expected = "header-menu__popup header-menu__popup--open";

        assertEquals(expected, products.getAttribute("class"));
    }

    @Test

    public void openPageCompanyWithHidden() {
        var urlButton = driver.findElement(By.cssSelector("#hm-btn-4"));
        var products = driver.findElement(By.cssSelector("#hm-menu-4"));

        urlButton.click();
        String expected = "false";

        assertEquals(expected, products.getAttribute("aria-hidden"));
    }

    @Test

    public void openPageDownload() {
        var priceBtn = driver.findElement(By.cssSelector(".header-menu__btn" + ".header-menu__btn--navbar" + ".header-menu__btn--navbar--accent"));

        priceBtn.click();

        String expected = "https://trueconf.ru/downloads/windows.html";
        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);
    }
}

