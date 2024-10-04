package Tests;

import Pages.AddProductsToCart;
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
        takesScreenshots.takeScreenshot(driver,"login Page");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }
    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductTitleIsVisible();
        takesScreenshots.takeScreenshot(driver,"Home Page");
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void addBackPack() { addProductsToCart.addBackpack(); }
    @Test(dependsOnMethods = "addBackPack")
    public void addBike() { addProductsToCart.addBike(); }
    @Test(dependsOnMethods = "addBike")
    public void clickCart() {addProductsToCart.clickCart();
        takesScreenshots.takeScreenshot(driver,"checkoutPage");}

    @Test(dependsOnMethods = "clickCart")
    public void verifyCheckoutPage() {checkoutPage.verifyCheckoutPageIsVisible();
        takesScreenshots.takeScreenshot(driver,"Cart");}
    @Test(dependsOnMethods = "clickCart")
    public void validateItemsAddedToCartTest(){ checkoutPage.checkIfItemsAddedInCartDisplay();}
    @Test(dependsOnMethods = "verifyCheckoutPage")
    public void clickCheckOut(){checkoutPage.clickCheckoutButton();}
    @Test(dependsOnMethods = "clickCheckOut")
    public void enterFirstNameTest() { yourInformationPage.enterFirstName(readFromExcel.firstName); }
    @Test(dependsOnMethods = "enterFirstNameTest")
    public void enterLastNameTest(){ yourInformationPage.enterLastName(readFromExcel.lastName); }
    @Test(dependsOnMethods = "enterLastNameTest")
    public void enterPostalCodeTest(){ yourInformationPage.enterPostalCode(Integer.valueOf(readFromExcel.postalCode));
        takesScreenshots.takeScreenshot(driver,"Personal info Page");}
    @Test(dependsOnMethods = "enterPostalCodeTest")
    public void clickContinueTest(){ yourInformationPage.clickContinueButton();
        takesScreenshots.takeScreenshot(driver,"Overview Page");}
    @Test(dependsOnMethods = "clickContinueTest")
    public void checkOutOverviewPageTest(){ checkOutOverview.checkoutOverview();}

    @Test(dependsOnMethods = "checkOutOverviewPageTest")
    public void finishButtonTest() { checkOutOverview.validateTotals();
        takesScreenshots.takeScreenshot(driver,"Finish Page");}
    @Test(dependsOnMethods = "finishButtonTest")
    public void backHomeTest() { checkOutComplete.clickBackHomeButton();}
    @Test(dependsOnMethods = "backHomeTest")
    public void backToHomePageTest(){ checkOutComplete.verifyBackToHomePage();}



    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
