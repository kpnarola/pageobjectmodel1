package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JewelryPage extends Utils{
    LoadProperty loadProperty = new LoadProperty();
    SoftAssert softAssert = new SoftAssert();
    By listOfJewelryProducts = By.cssSelector(".item-box .actual-price");


    public void assertForCurrencyIsEuro() {

         //Select list of item with price
        List<WebElement> jewelryPriceList = driver.findElements(listOfJewelryProducts);
        //To get total element size System.out.println(jewelryPriceList.size());

        for (WebElement al : jewelryPriceList) {
            System.out.println(al.getText().substring(0, 1));

            //Result Verification
            softAssert.assertEquals("Ђ", al.getText().substring(0, 1));
        }
        softAssert.assertAll();
    }

    public void assertForCurrencyUSDollar(){
         //Select list of product with price
        List<WebElement> jewelryPriceList = driver.findElements(listOfJewelryProducts);

        for (WebElement al : jewelryPriceList) {

            //Excrete Dollar sing by using substring
            System.out.println(al.getText().substring(0, 1));

            //Result Verification
            softAssert.assertEquals("$", al.getText().substring(0, 1));
        }
        softAssert.assertAll();
    }
}

