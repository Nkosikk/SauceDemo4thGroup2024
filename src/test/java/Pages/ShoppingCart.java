package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ShoppingCart {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Your Cart')]")
    WebElement yourCart_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight_xpath;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout_xpath;


    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsOnShoppingCart() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(yourCart_xpath));
        yourCart_xpath.isDisplayed();
    }

    public void checkItemsAppearOnShoppingCart() {
        sauceLabsBackpack_xpath.isDisplayed();
        sauceLabsBikeLight_xpath.isDisplayed();
    }

    public void clickCheckOut() {
        checkout_xpath.click();
    }
}
