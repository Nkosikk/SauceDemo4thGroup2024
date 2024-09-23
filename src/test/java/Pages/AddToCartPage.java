package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage {

    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement AddToCart_id;

    public void AddToCartPage(WebDriver driver) {
        this.driver = driver;

    public void clickAddToCartButton() {
        AddToCart_id.click();
    }

}


