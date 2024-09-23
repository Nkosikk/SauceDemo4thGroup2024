package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyCartPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Your Cart')]")
    WebElement myCartPage_xpath;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement itemBike_id;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement itemBoltShirt_id;

    @FindBy(id = "checkout")
    WebElement checkout_id;

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyMyCartTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(myCartPage_xpath));
        myCartPage_xpath.isDisplayed();
    }

    public void removeProductsFromCart() {
        itemBike_id.click();
        itemBoltShirt_id.click();
    }
    public void proceedToCheckout() {
        checkout_id.click();
    }
}
