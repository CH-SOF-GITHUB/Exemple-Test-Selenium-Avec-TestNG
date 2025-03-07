package tested;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.LoginPage;

public class TestData extends Base {

    // définir un tableau Data driver
    @DataProvider(name = "dataLogin")
    public Object[][] getDataLogin() {
        return new Object[][]{
                // cas idéal
                {"standard_user", "secret_sauce", ""},
                // username invalide et password valide
                {"user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                // username valide et password invalide
                {"standard_user", "secret", "Epic sadface: Username and password do not match any user in this service"},
                // username invalide et password invalide
                {"user", "secret", "Epic sadface: Username and password do not match any user in this service"},
                // username valide et password vide
                {"standard_user", "", "Epic sadface: Password is required"},
                // username invalide et password vide
                {"standard_", "", "Epic sadface: Password is required"},
                // username vide et password valide
                {"", "secret_sauce", "Epic sadface: Username is required"},
                // username vide et password invalide
                {"", "secretauce", "Epic sadface: Username is required"},
                // username vide et password vide
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @BeforeMethod
    public void FirstTest() {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "site saucedemo est ouvert avec succès");
    }

    @Test(dataProvider = "dataLogin")
    public void Login(String username, String password, String expectedMessage) {
        LoginPage login_page = new LoginPage(driver);
        login_page.saisirUsername(username);
        login_page.saisirPassword(password);
        login_page.clickLoginButton();
        // vérifier la connexion
        String url = driver.getCurrentUrl();
        if(expectedMessage.equals("")) {
            Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
        }else {
            String msgError = login_page.getErrorMessage().getText();
            Assert.assertTrue(expectedMessage.equals(msgError));
        }
    }
}
