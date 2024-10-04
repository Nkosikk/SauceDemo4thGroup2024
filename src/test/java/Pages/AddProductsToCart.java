package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductsToCart {
    WebDriver driver;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement backpack_xpath;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bike_xpath;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement shoppingCart_xpath;

    public AddProductsToCart(WebDriver driver) {
        this.driver = driver;
    }
    public void addBike(){
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(bike_xpath));
        bike_xpath.click(); }
    public void addBackpack() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(backpack_xpath));
        backpack_xpath.click(); }

    public void clickCart(){ shoppingCart_xpath.click(); }

}


