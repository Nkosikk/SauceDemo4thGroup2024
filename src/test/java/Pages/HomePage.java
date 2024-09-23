package Pages;

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

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement Item1_id;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement Item2_id;

    @FindBy(id = "shopping_cart_container")
    WebElement cart;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Your Cart')]")
    WebElement yCart_xpath;




    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does axactly the same thing, you need to use one
        product_xpath.isDisplayed();

        String productTExt = product_xpath.getText();
        Assert.assertEquals(productTExt, "Products");
    }


    public void AddItemsToCart(){
    Item1_id.click();
    Item2_id.click();
    cart.click();
    }

    public void verifyYourCartTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does axactly the same thing, you need to use one
        yCart_xpath.isDisplayed();

        String productTExt = yCart_xpath.getText();
        Assert.assertEquals(productTExt, "Your Cart");
    }

}
