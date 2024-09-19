package Tests;

import Pages.YourCartPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;

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
        takesScreenshots.takesScreenshot(driver,"login page");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductTitleIsVisible();
        takesScreenshots.takesScreenshot(driver,"Home page");
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void clickAddToCart(){
        homePage.clickAddToCartButton();
    }

    @Test(dependsOnMethods = "clickAddToCart")
    public void clickShoppingCart() {
        homePage.clickShoppingCartLink();
    }

    @Test(dependsOnMethods = "clickShoppingCart")
    public void verifyYourCartPage(){
        yourCartPage.verifyYourCartTitleIsVisible();
        takesScreenshots.takesScreenshot(driver,"Your Cart Page");
    };

    @Test(dependsOnMethods = "verifyYourCartPage" )
    public void clickCheckout(){
        yourCartPage.clickCheckoutButton();
    }

    @Test(dependsOnMethods = "clickCheckout")
    public void verifyYourInformationPage(){
        yourInformationPage.verifyYourInformationTitleIsVisible();
        takesScreenshots.takesScreenshot(driver,"Your Information Page");
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
