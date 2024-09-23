package Tests;

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
    public void AddItemsToCartTest() {
        homePage.AddItemsToCart();

    }
    @Test(dependsOnMethods = "AddItemsToCartTest")
    public void verifyYourCartTitleIsVisibleTest() {
        homePage.verifyYourCartTitleIsVisible();
    }

   /* @AfterTest
    public void closeBrowser() {
        driver.quit();
    }*/


}
