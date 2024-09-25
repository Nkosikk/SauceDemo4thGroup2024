package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public void enterFirstName(String firstName){firstName_xpath.sendKeys(); }
    public void enterLastName(String lastName){ lastName_xpath.sendKeys(); }
    public void enterPostalCode(Integer postalCode){postalCode_xpath.sendKeys(); }
    public void clickContinueButton(){continueButton_xpath.click(); }

}
