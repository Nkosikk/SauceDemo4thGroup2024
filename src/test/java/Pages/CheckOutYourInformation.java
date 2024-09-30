package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutYourInformation {

    WebDriver driver;


    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
    WebElement checkoutYourInformationText_xpath;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName_xpath;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName_xpath;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement zipCode_xpath;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement continue_xpath;


    public CheckOutYourInformation(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsInCheckOutPage() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutYourInformationText_xpath));
        checkoutYourInformationText_xpath.isDisplayed();
    }

    public void enterFirstName(String firstName) {

        firstName_xpath.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        lastName_xpath.sendKeys(lastName);
    }

    public void enter_Zip_Postal_Code(String zipCode) {

        zipCode_xpath.sendKeys(zipCode);

    }

    public void clickContinueButton() {
        continue_xpath.click();
    }
}
