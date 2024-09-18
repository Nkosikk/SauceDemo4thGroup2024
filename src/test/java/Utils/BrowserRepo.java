package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class BrowserRepo {
    static WebDriver driver;


//Method to call for opening the browser
@BeforeTest
    public static WebDriver startBrowser(String browserChoice,String url){
        if (browserChoice.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }


}
