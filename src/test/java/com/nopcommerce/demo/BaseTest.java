package com.nopcommerce.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils {

    @BeforeMethod
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        // Implicitly Wait for Driver
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //Maximising Browser
        driver.manage().window().fullscreen();

        //Opening Url
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }



}
