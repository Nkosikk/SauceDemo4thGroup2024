package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutYourInformationPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
    WebElement checkoutYourInformationPage_xpath;

    @FindBy(id = "first-name")
    WebElement firstName_id;

    @FindBy(id = "last-name")
    WebElement lastName_id;

    @FindBy(id = "postal-code")
    WebElement zipCode_id;


    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutYourInformationTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutYourInformationPage_xpath));
        checkoutYourInformationPage_xpath.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(firstName_id));
        //firstName_id.clear();
        firstName_id.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        //lastName_id.clear();
        lastName_id.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        zipCode_id.clear();
        zipCode_id.sendKeys(zipCode);
    }
}
