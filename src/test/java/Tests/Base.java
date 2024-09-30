package Tests;

import Pages.*;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);

    CheckOutYourInformation checkOutYourInformation = PageFactory.initElements(driver, CheckOutYourInformation.class);

    CheckOutOverView checkOutOverView = PageFactory.initElements(driver, CheckOutOverView.class);

    CheckOutComplete checkOutComplete = PageFactory.initElements(driver, CheckOutComplete.class);

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
