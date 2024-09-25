package Tests;

import Pages.AddProductsToCart;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.BrowserFactory;
import Utils.TakesScreenshots;
import Utils.TakesScreenshots;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    AddProductsToCart addProductsToCart = PageFactory.initElements(driver, AddProductsToCart.class);
    CheckoutPage checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);
    TakesScreenshots takesScreenshots = new TakesScreenshots();
}
