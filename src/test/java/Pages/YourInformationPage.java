package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class YourInformationPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
    WebElement yourInformation_xpath;

    @FindBy(id = "first-name")
    WebElement firstName_id;

    @FindBy(id = "last-name")
    WebElement lastName_id;

    @FindBy(id = "postal-code")
    WebElement postalCode_id;

    @FindBy(id = "continue")
    WebElement continue_id;




    public YourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyYourInformationTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(yourInformation_xpath));
        yourInformation_xpath.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        firstName_id.clear();
        firstName_id.sendKeys(firstName);

    }

    public void enterLastName(String lastName) {
        lastName_id.clear();
        lastName_id.sendKeys(lastName);

    }

    public void enterPostalCode(String postalCode) {
        postalCode_id.clear();
        postalCode_id.sendKeys(postalCode);

    }

    public void clickContinueButton(){
        continue_id.click();
    }

}
