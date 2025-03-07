package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // déclaration et initialisation des web elements de checkout page
    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "finish")
    WebElement finishBtn;

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

    public void saisirFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void saisirLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void saisirPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }
}
