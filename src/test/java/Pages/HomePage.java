package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement product_xpath;

    //Add items to cart
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement itemBackPack_id;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement itemBike_id;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement itemBoltShirt_id;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement itemFleeceJacket_id;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement itemOnsie_id;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement itemTShirt_id;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartBadge_xpath;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does axactly the same thing, you need to use one
        product_xpath.isDisplayed();
    }

    public void addProductsToCart(){
        itemBackPack_id.click();
        itemTShirt_id.click();
        itemOnsie_id.click();
        itemFleeceJacket_id.click();
        itemBike_id.click();
        itemBoltShirt_id.click();
    }

    public void viewCart(){
        shoppingCartBadge_xpath.click();
    }


}
