package tested;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.LoginPage;

public class Test1 extends Base {

    @Test(priority = 0)
    public void Test4() {
        System.out.println("Test 4");
    }

    @Test(priority = 1)
    public void FirstTest() {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "site saucedemo est ouvert avec succès");
    }

    // (enabled = false)
    @Test
    public void SecondTest() {
        driver.get("https://automationteststore.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "A place to practice your automation skills!", "navigateur automation test store est ouvert avec succès");
    }

    // timOut: limite de temps d'éxecution: timeOut = 1000
    @Test(priority = 2)
    public void Test3() {
        driver.get("https://www.google.com/");
    }

    @Test(dependsOnMethods = {"FirstTest"})
    public void Login() {
        LoginPage login_page = new LoginPage(driver);
        login_page.saisirUsername("locked_out_user");
        login_page.saisirPassword("secret_sauce");
        login_page.clickLoginButton();
    }
}
