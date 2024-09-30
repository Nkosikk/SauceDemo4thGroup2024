package Pages;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement overview_xpath;

    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    WebElement itemTotal_xpath;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    WebElement tax_xpath;

    @FindBy(xpath = "//div[@data-test='total-label']")
    WebElement totalToPay_xpath;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton_xpath;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement cancelButton_xpath;


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOverviewTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(overview_xpath));
        overview_xpath.isDisplayed();
    }

    public void calculations() {

        //Converting Item Total
        String bItemTotal = (itemTotal_xpath.getText()).replace("Item total: $", "");
        DecimalFormat dcf = new DecimalFormat("###.##");
        double aItemTotal = Double.parseDouble(bItemTotal);

        //Converting Tax
        String bTax = (tax_xpath.getText()).replace("Tax: $", "");
        double aTax = Double.parseDouble(bTax);

        //Converting Total to Pay
        String bTotalToPay = (totalToPay_xpath.getText()).replace("Total: $", "");
        double aTotalToPay = Double.parseDouble(bTotalToPay);

        double sum = aItemTotal + aTax;

        System.out.println("Sum of tax plus item total "+sum);
        System.out.println("Total to Pay "+aTotalToPay);


        if (sum == aTotalToPay) {
            finishButton_xpath.click();

        } else {
            cancelButton_xpath.click();
        }


    }


}
