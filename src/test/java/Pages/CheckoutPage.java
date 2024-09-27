package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement checkout_xpath;

    @FindBy(id = "finish")
    WebElement finishButton_id;



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutOverviewTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(checkout_xpath));
        checkout_xpath.isDisplayed();
    }

    public void calculateCartItems() {
        WebElement cart = driver.findElement(By.className("cart_list"));
        List<WebElement> items = cart.findElements(By.className("cart_item"));
        if(items.size() > 0){
            String subTotalText = cart.findElement(By.xpath("//div[contains(@class,'summary_subtotal_label')]")).getText();
            double subTotal = Double.parseDouble(subTotalText.split(" ")[2].replace("$", ""));

            String totalText = cart.findElement(By.xpath("//div[contains(@class,'summary_total_label')]")).getText();
            double total = Double.parseDouble(totalText.split(" ")[1].replace("$", ""));

            System.out.println(total);

            double taxPerc = 0.08;
            double taxAmount = subTotal * taxPerc;
            double tempTotal = subTotal + taxAmount;

            if (Math.round(tempTotal * 100.0) / 100.0 == Math.round(total * 100.0) / 100.0) {
                assert true;
            } else {
                assert false;

        }

        }

    }

    public void clickFinishButton(){
        finishButton_id.click();
    }
}



