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

public class DemoEnterTest {

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
    public void demoEnter() {
        var demoEnterButton = By.cssSelector(".demo-login");

        driver.findElement(demoEnterButton).click();

        String iconBy = (".icon-close-sm");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(iconBy)));
        driver.findElement(By.cssSelector(iconBy)).click();

        var logo = By.cssSelector(".bgc3");

        Assert.assertTrue("Логотип в левом верхнем углу не отображается",
                driver.findElement(logo).isDisplayed());
    }
}
