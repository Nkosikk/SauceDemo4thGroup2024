package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckOutOverview {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='app_logo'][contains(.,'Swag Labs')]")
    WebElement checkoutHome_xpath;
    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement finish_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_price'][contains(.,'$29.99')]")
    WebElement item1_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_price'][contains(.,'$9.99')]")
    WebElement item2_xpath;
    @FindBy(xpath = "//div[@class='summary_tax_label'][contains(.,'Tax: $3.20')]")
    WebElement tax_xpath;
    @FindBy(xpath = "//div[@class='summary_total_label'][contains(.,'Total: $43.18')]")
    WebElement total_xpath;
    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    WebElement cancelButton_xpath;


    //public CheckOutOverview(WebDriver driver){this.driver = driver; }

    public void checkoutOverview(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkoutHome_xpath));
        checkoutHome_xpath.isDisplayed();
    }

    public void validateTotals(){
        // Calculate the sum of the two item prices
        double price1 = Double.parseDouble(item1_xpath.getText().replace("$", "").trim());
        double price2 = Double.parseDouble(item2_xpath.getText().replace("$", "").trim());
        double calculatedSum = price1 + price2;
        double tax = Double.parseDouble(tax_xpath.getText().replace("Tax: $", "").trim());

        // Calculate total including tax
        double totalWithTax = calculatedSum + tax;
        double displayedTotal = Double.parseDouble(total_xpath.getText().replace("Total: $", "").trim());
        // Validate the total
        if (totalWithTax == displayedTotal) {
            Assert.assertTrue(true);
            finish_xpath.click();
        } else {
            Assert.assertTrue(false);
            cancelButton_xpath.click();
        }


    }



}
