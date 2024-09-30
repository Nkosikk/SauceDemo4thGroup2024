package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Complete!')]")
    WebElement complete_xpath;


    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutCompleteTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(complete_xpath));
        complete_xpath.isDisplayed();
    }



}
