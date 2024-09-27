package Tests;

import Pages.*;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakesScreenshots;
import Utils.TakesScreenshots;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    AddProductsToCart addProductsToCart = PageFactory.initElements(driver, AddProductsToCart.class);
    CheckoutPage checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);
    YourInformationPage yourInformationPage = PageFactory.initElements(driver, YourInformationPage.class);
    TakesScreenshots takesScreenshots = new TakesScreenshots();
    ReadFromExcel readFromExcel;

    {
        try {
            readFromExcel = new ReadFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
