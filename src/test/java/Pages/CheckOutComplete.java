package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutComplete {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(@id,'back-to-products')]")
    WebElement checkoutComplete_xpath;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement backToHomePage_xpath;

    public CheckOutComplete(WebDriver driver){this.driver = driver;}
    public void clickBackHomeButton(){checkoutComplete_xpath.click();}
    public void verifyBackToHomePage(){backToHomePage_xpath.isDisplayed();}


}
