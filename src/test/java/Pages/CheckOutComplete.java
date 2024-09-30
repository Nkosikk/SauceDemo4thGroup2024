package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckOutComplete {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your order!')]")
    WebElement completedOrder_xpath;

    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    WebElement burgerMenu_xpath;

    @FindBy(xpath = "//a[contains(.,'Logout')]")
    WebElement logOutButton_xpath;


    public CheckOutComplete(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOrderIsComplete() {
        String completedOrderText = completedOrder_xpath.getText();
        Assert.assertEquals(completedOrderText, "Thank you for your order!");

    }

    public void logOut() {

        burgerMenu_xpath.click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(logOutButton_xpath));
        logOutButton_xpath.click();

    }
}
