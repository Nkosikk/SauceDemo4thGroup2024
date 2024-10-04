package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Your Cart')]")
    WebElement checkoutPage_xpath;
    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkoutButton_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement backpack;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")
    WebElement bike;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutPageIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutPage_xpath));
        checkoutPage_xpath.isDisplayed();
    }
    public void checkIfItemsAddedInCartDisplay(){
        backpack.isDisplayed();
        bike.isDisplayed();
    }
    public void clickCheckoutButton() {checkoutButton_xpath.click();}
}
