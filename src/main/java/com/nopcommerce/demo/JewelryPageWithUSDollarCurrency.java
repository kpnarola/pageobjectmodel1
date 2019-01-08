package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.nopcommerce.demo.Utils.clickOnElement;

public class JewelryPageWithUSDollarCurrency extends BasePage{
    public void currencyIsDollar() {

        //Object declaration for SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //Select currency USDollar
        clickOnElement(By.id("customerCurrency"));

        //Click on Jewelry from category
        clickOnElement(By.linkText("Jewelry"));

        //Select list of product with price
        List<WebElement> jewelryPriceList = driver.findElements(By.cssSelector(".item-box .actual-price"));

        for (WebElement al : jewelryPriceList) {

            //Excrete Dollar sing by using substring
            System.out.println(al.getText().substring(0, 1));

            //Result Verification
            softAssert.assertEquals("$", al.getText().substring(0, 1));

        }
        softAssert.assertAll();
    }
}
