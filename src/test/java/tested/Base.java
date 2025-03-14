package tested;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base {
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE); // Cache les logs Selenium sauf erreurs critiques
    }

    public Base() {
    }

    // créer une variable locale à chaque Thread (chaque test a son propre web driver)
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void beforeTest() {
        System.out.println("avant chaque test");
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void afterTest() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
        System.out.println("aprés chaque test");
    }
}
