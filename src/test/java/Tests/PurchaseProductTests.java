package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;

@Test
public class PurchaseProductTests extends Base {


    public void loginWithInvalidDetailsTests() throws InterruptedException {
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


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
