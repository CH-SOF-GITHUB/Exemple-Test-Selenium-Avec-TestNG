package tested;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
    }

    @Test
    public void testGoogle() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Running test on: " + driver.getTitle() + " | Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}