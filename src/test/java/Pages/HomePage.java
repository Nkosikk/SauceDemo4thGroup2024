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

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement addItem1_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement addItem2_xpath;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement clickShoppingCart_xpath;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does exactly the same thing, you need to use one
        product_xpath.isDisplayed();

        String productTExt = product_xpath.getText();
        Assert.assertEquals(productTExt, "Products");
    }

    public void addItems() {
        addItem1_xpath.click();
        addItem2_xpath.click();

    }

    public void clickCartIcon() {
        clickShoppingCart_xpath.click();

    }


}
