package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.nopcommerce.demo.Utils.clickOnElement;

public class JewelryPageWithEuroCurrency extends BasePage{
    public void currencyIsEuro() {

        //Object declaration for SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //Click on currency box and select euro
        driver.findElement(By.id("customerCurrency")).findElement(By.xpath("//option[contains(text(),'Euro')]")).click();

        //Click on Jewelry category
        clickOnElement(By.linkText("Jewelry"));

        //Select list of item with price
        List<WebElement> jewelryPriceList = driver.findElements(By.cssSelector(".item-box .actual-price"));
        //To get total element size System.out.println(jewelryPriceList.size());

        for (WebElement al : jewelryPriceList) {
            System.out.println(al.getText().substring(0, 1));

            //Result Verification
            softAssert.assertEquals("Ђ", al.getText().substring(0, 1));

        }
        softAssert.assertAll();
    }
}

