package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class SauceDemo {
    WebDriver driver;
    By productsTitle = By.xpath("//span[@class='title'][contains(.,'Products')]");


    public void loginWithValidDetails() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String productTExt = driver.findElement(productsTitle).getText();
        Assert.assertEquals(productTExt,"Products");

        driver.findElement (productsTitle).isDisplayed();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
