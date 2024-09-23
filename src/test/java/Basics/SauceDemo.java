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


    public void loginWithValidDetails() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        String productTExt = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Products')]")).getText();
        Assert.assertEquals(productTExt,"Products");

        driver.findElement(By.xpath("//span[@class='title'][contains(.,'Products')]")).isDisplayed();
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
