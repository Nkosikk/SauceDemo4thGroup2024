package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductsToCart {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='inventory_item_name '][contains(.,'Sauce Labs Backpack')]")
    WebElement backpack_xpath;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement bike_xpath;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement shoppingCart_xpath;

    public AddProductsToCart(WebDriver driver) {
        this.driver = driver;
    }


    public void addBackpack() { backpack_xpath.click(); }
    public void addBike(){ bike_xpath.click(); }

    public void clickCart(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(shoppingCart_xpath));
        shoppingCart_xpath.click(); }

}


