package Tests;

import Pages.AddProductsToCart;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;

@Test
public class PurchaseProductTests extends Base {


    public void loginWithInvalidDetailsTests() {
        loginPage.enterUsername("standard_user" + "invalid");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.verifyLoginErrorMessage();
    }
    @Test(dependsOnMethods = "loginWithInvalidDetailsTests")
    public void enterUsernameTests() {
        loginPage.enterUsername("standard_user");
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPassword() {
        loginPage.enterPassword("secret_sauce");
        takesScreenshots.takeScreenshot(driver,"login Page");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductTitleIsVisible();
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void addBackPack() { addProductsToCart.addBackpack(); }
    @Test(dependsOnMethods = "addBackPack")
    public void addBike() { addProductsToCart.addBike(); }
    @Test(dependsOnMethods = "addBike")
    public void clickCart() {addProductsToCart.clickCart();
        takesScreenshots.takeScreenshot(driver,"checkoutPage");}

    @Test(dependsOnMethods = "clickCart")
    public void verifyCheckoutPage() {checkoutPage.verifyCheckoutPageIsVisible(); }
    @Test(dependsOnMethods = "verifyCheckoutPage")
    public void clickCheckOut(){checkoutPage.clickCheckoutButton();}


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
