package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
    WebDriver driver;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // déclaration et initialisation des web d'ajout des produits
    WebElement addToChart;

    @FindBy(className = "shopping_cart_link")
    WebElement panierIcon;

    public void clickAddToChart(String produit) {
        String namePath = "add-to-cart-" + produit.toLowerCase().replace(" ", "-");
        addToChart = driver.findElement(By.name(namePath));
        addToChart.click();
    }

    public void clickPanierIcon() {
        panierIcon.click();
    }
}
