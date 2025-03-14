package tested;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.LoginPage;

import java.time.Duration;

public class ParallelData extends Base {
    // définir un tableau Data driver
    @DataProvider(name = "dataLogin", parallel = true)
    public Object[][] getDataLogin() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "cas1"}, // Cas 1: idéal
                {"user", "secret_sauce", "cas2"}, // Cas 2: username invalide et password valide
                {"standard_user", "secret", "cas3"}, // Cas 3: username valide et password invalide
                {"user", "secret", "cas4"}, // Cas 4: username invalide et password invalide
                {"standard_user", "", "cas5"}, // Cas 5: username valide et password vide
                {"standard_", "", "cas6"}, // Cas 6: username invalide et password vide
                {"", "secret_sauce", "cas7"}, // Cas 7: username vide et password valide
                {"", "secretauce", "cas8"}, // Cas 8: username vide et password invalide
                {"", "", "cas9"} // Cas 9: username vide et password vide
        };
    }

    // define the test methods and lifecycle hooks
    /*@BeforeMethod
    public void FirstTest() {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        //Assert.assertEquals(title, "Swag Labs", "site saucedemo est ouvert avec succès");
        //System.out.println("Running test on: " + driver.getTitle() + " | Thread ID: " + Thread.currentThread().getId());
    }*/

    @Test(dataProvider = "dataLogin")
    public void Login(String username, String password, String cas) {
        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginPage login_page = new LoginPage(driver);
        login_page.saisirUsername(username);
        login_page.saisirPassword(password);
        login_page.clickLoginButton();
        System.out.println("Executing: " + cas + " on Thread ID: " + Thread.currentThread().getId());
    }
}
