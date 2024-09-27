package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutCompletePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Complete!')]")
    WebElement checkoutComplete_xpath;


    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutCompleteTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutComplete_xpath));
        checkoutComplete_xpath.isDisplayed();
    }


}



