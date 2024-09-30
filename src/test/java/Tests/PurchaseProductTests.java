package Tests;

import Pages.CheckoutYourInformationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

@Test
public class PurchaseProductTests extends Base {


    public void loginWithInvalidDetailsTests() {
        loginPage.enterUsername(readFromExcel.username + "invalid");
        loginPage.enterPassword(readFromExcel.password);
        loginPage.clickLoginButton();
        loginPage.verifyLoginErrorMessage();
    }

    @Test(dependsOnMethods = "loginWithInvalidDetailsTests")
    public void enterUsernameTests() {
        loginPage.enterUsername(readFromExcel.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPassword() {
        loginPage.enterPassword(readFromExcel.password);
        takesScreenshots.takesScreenshot(driver, "login page");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductTitleIsVisible();
        takesScreenshots.takesScreenshot(driver, "login page");
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void addToCart() {
        homePage.addProductsToCart();
    }

    @Test(dependsOnMethods = "addToCart")
    public void checkMyShoppingCart() {
        homePage.viewCart();
    }

    @Test(dependsOnMethods = "checkMyShoppingCart")
    public void verifyMyCart() {
        cartPage.verifyMyCartTitleIsVisible();
        takesScreenshots.takesScreenshot(driver, "Your Cart page");
    }

    @Test(dependsOnMethods = "verifyMyCart")
    public void removeFromCart(){
        cartPage.removeProductsFromCart();
        takesScreenshots.takesScreenshot(driver, "Your Cart page (Item Removed)");
    }

    @Test(dependsOnMethods = "removeFromCart")
    public void checkout(){
        cartPage.proceedToCheckout();
        takesScreenshots.takesScreenshot(driver, "Your Cart page (Item Removed)");
    }

    @Test(dependsOnMethods = "checkout")
    public void verifyCheckoutInfo(){
        checkoutInfoPage.verifyCheckoutYourInformationTitleIsVisible();
        takesScreenshots.takesScreenshot(driver, "Checkout Your Information Page");
    }

    @Test(dependsOnMethods = "verifyCheckoutInfo")
    public void enterFistNameTest(){
        checkoutInfoPage.enterFirstName(readFromExcel.firstName);
    }

    @Test(dependsOnMethods = "enterFistNameTest")
    public void enterLastNameTest(){
        checkoutInfoPage.enterLastName(readFromExcel.lastName);
    }

    @Test(dependsOnMethods = "enterLastNameTest")
    public void enterZipTest(){
        checkoutInfoPage.enterZipCode(readFromExcel.zipCode);
        takesScreenshots.takesScreenshot(driver,"User Information");
    }

    @Test(dependsOnMethods = "enterZipTest")
    public void continueButtonTest(){
        checkoutInfoPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "continueButtonTest")
    public void verifyOverviewPageTest(){
        checkoutOverviewPage.verifyOverviewTitleIsVisible();
        takesScreenshots.takesScreenshot(driver,"Checkout (Overview)");
    }

    @Test(dependsOnMethods = "verifyOverviewPageTest")
    public void calculationsTest(){
        checkoutOverviewPage.calculations();
    }

    @Test(dependsOnMethods = "calculationsTest")
    public void completeTest(){
        checkoutCompletePage.verifyCheckoutCompleteTitleIsVisible();
        takesScreenshots.takesScreenshot(driver,"Checkout (Complete!)");
    }

    @AfterTest
    public void closeBrowser() {
        //driver.quit();
    }


}
