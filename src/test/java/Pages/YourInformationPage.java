package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInformationPage {
    WebDriver driver;
    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement firstName_xpath;
    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement lastName_xpath;
    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement postalCode_xpath;
    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement continueButton_xpath;
    public YourInformationPage(WebDriver driver){this.driver = driver; }
    public void enterFirstName(String firstName) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(firstName_xpath));
        firstName_xpath.sendKeys(firstName);
    }
    public void enterLastName(String lastName){ lastName_xpath.sendKeys(lastName); }
    public void enterPostalCode(Integer postalCode){postalCode_xpath.sendKeys(postalCode.toString()); }
    public void clickContinueButton(){continueButton_xpath.click(); }

}
