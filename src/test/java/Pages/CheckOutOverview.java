package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutOverview {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='app_logo'][contains(.,'Swag Labs')]")
    WebElement checkoutHome_xpath;
    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement finish_xpath;
    public CheckOutOverview(WebDriver driver){this.driver = driver; }
    public void checkoutOverview(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutHome_xpath));
        checkoutHome_xpath.isDisplayed();
    }
    public void clickFinishButton() { finish_xpath.click();}

}
