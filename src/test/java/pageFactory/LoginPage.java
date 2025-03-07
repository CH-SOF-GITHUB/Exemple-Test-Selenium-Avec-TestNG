package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // déclaration des web éléments de la page login
    @FindBy(xpath = "//input[@data-test=\"username\"]")
    WebElement usernameFiled;

    @FindBy(id = "password")
    WebElement passwordFiled;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "error-message-container")
    WebElement errorMessage;

    public void saisirUsername(String username) {
        usernameFiled.sendKeys(username);
    }

    public void saisirPassword(String password) {
        passwordFiled.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

}
