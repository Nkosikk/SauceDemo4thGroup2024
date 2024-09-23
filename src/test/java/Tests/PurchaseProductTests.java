package Tests;

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
        AddToCartPage.clickAddToCartButton();
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
        takesScreenshots.takesScreenshot(driver,"login page");
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void clickAddToCartButton() {
        AddToCartButtonPage.clickAddToCartButtonButton();
        takesScreenshots.takesScreenshot(driver,"AddToCart page");
    }



    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
