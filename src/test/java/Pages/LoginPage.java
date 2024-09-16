package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='user-name']")
    WebElement username_xpath;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(name = "login-button")
    WebElement loginButton_name;

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement product_xpath;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys(username);
    }

    public void enterPassword(String password) {
        password_id.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton_name.click();
    }

    public void verifyProductTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does axactly the same thing, you need to use one
        product_xpath.isDisplayed();

        String productTExt = product_xpath.getText();
        Assert.assertEquals(productTExt, "Products");
    }


}
