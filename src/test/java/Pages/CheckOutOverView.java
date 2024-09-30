package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CheckOutOverView {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement checkOutOverView_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement itemTotal_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_tax_label')]")
    WebElement tax_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement total_xpath;

    @FindBy(xpath = "//button[contains(@class,'btn btn_action btn_medium cart_button')]")
    WebElement finishButton_xpath;

    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    WebElement cancelButton_xpath;


    public CheckOutOverView(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsOnCheckOutOverView() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkOutOverView_xpath));
        String checkoutText = checkOutOverView_xpath.getText();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400);");
        Assert.assertEquals(checkoutText, "Checkout: Overview");
    }

    public void checkItemsAppearOnCheckOut() {
        sauceLabsBackpack_xpath.isDisplayed();
        sauceLabsBikeLight_xpath.isDisplayed();
    }

    public void verifyTotalIsEqualToItemTotalPlusTax() {

        // Get text for each element
        String itemTotal = itemTotal_xpath.getText();
        String tax = tax_xpath.getText();
        String total = total_xpath.getText();

        //Replace whole text with empty space to get only numbers
        String itemTotalReplace = itemTotal.replace("Item total: $", "");
        String taxReplace = tax.replace("Tax: $", "");
        String totalReplace = total.replace("Total: $", "");

        //Convert values to double
        double itemTotalAmount = Double.parseDouble(itemTotalReplace);
        double taxAmount = Double.parseDouble(taxReplace);
        double taxPlusItemsTotal = itemTotalAmount + taxAmount;
        double totalAmount = Double.parseDouble(totalReplace);

        if (taxPlusItemsTotal == totalAmount) {
            Assert.assertTrue(true);
            finishButton_xpath.click();

        } else {

            cancelButton_xpath.click();
            Assert.assertTrue(false);


        }


    }


}
