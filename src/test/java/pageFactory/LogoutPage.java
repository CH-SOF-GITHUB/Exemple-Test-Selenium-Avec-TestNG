package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement reactBurgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutSidebarLink;

    public void clickReactBurgerMenuBtn() {
        reactBurgerMenuBtn.click();
    }

    public void clickLogoutSidebarLink() {
        logoutSidebarLink.click();
    }
}
