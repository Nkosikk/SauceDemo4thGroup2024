package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class YourCartPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Your Cart')]")
    WebElement YourCart_xpath;



    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyYourCartTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(YourCart_xpath));
        YourCart_xpath.isDisplayed();
    }


}
