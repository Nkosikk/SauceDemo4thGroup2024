package Tests;



import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


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
        takesScreenshots.takesScreenshot(driver, "1.login page");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductTitleIsVisible();
        takesScreenshots.takesScreenshot(driver, "2.Home page");

    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void addItemsTest() {
        homePage.addItems();
        takesScreenshots.takesScreenshot(driver, "3.Added Items page");


    }

    @Test(dependsOnMethods = "addItemsTest")
    public void clickCartIconTest() {

        homePage.clickCartIcon();

    }


    @Test(dependsOnMethods = "clickCartIconTest")
    public void verifyUserIsOnShoppingCartTest() {

        shoppingCart.verifyUserIsOnShoppingCart();
        takesScreenshots.takesScreenshot(driver, "4.Shopping Cart page");
    }

    @Test(dependsOnMethods = "verifyUserIsOnShoppingCartTest")
    public void CheckIfItemsAddedTest() {
        shoppingCart.checkItemsAppearOnShoppingCart();
    }

    @Test(dependsOnMethods = "CheckIfItemsAddedTest")
    public void clickCheckOutTest() {
        shoppingCart.clickCheckOut();

    }

    @Test(dependsOnMethods = "clickCheckOutTest")
    public void checkIfUserIsOnCheckOut() {

        checkOutYourInformation.verifyUserIsInCheckOutPage();

    }

    @Test(dependsOnMethods = "checkIfUserIsOnCheckOut")
    public void enterFirstNameTests() {
        checkOutYourInformation.enterFirstName(readFromExcel.firstName);
    }

    @Test(dependsOnMethods = "enterFirstNameTests")
    public void enterLastNameTests() {
        checkOutYourInformation.enterLastName(readFromExcel.lastName);
    }

    @Test(dependsOnMethods = "enterLastNameTests")
    public void enterZip_Postal_CodeTest() {
        checkOutYourInformation.enter_Zip_Postal_Code(readFromExcel.zipCode);
        takesScreenshots.takesScreenshot(driver, "5.InformationCaptured page");


    }

    @Test(dependsOnMethods = "enterZip_Postal_CodeTest")
    public void continueButtonTest() {
        checkOutYourInformation.clickContinueButton();

    }

    @Test(dependsOnMethods = "continueButtonTest")
    public void verifyUserIsOnCheckOutOverViewTest() {
        checkOutOverView.verifyUserIsOnCheckOutOverView();

    }

    @Test(dependsOnMethods = "continueButtonTest")
    public void checkItemsAppearOnCheckOutTest() {
        checkOutOverView.checkItemsAppearOnCheckOut();

    }

    @Test(dependsOnMethods = "checkItemsAppearOnCheckOutTest")
    public void verifyTotalIsEqualToItemTotalPlusTaxTest() {
        takesScreenshots.takesScreenshot(driver, "6.CheckOutOverview page");
        checkOutOverView.verifyTotalIsEqualToItemTotalPlusTax();


    }

    @Test(dependsOnMethods = "verifyTotalIsEqualToItemTotalPlusTaxTest")
    public void verifyOrderIsCompleteTest() {
        takesScreenshots.takesScreenshot(driver, "7.OrderCompleted page");
        checkOutComplete.verifyOrderIsComplete();

    }

    @Test(dependsOnMethods = "verifyOrderIsCompleteTest")
    public void logOutTest() {
        checkOutComplete.logOut();
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
