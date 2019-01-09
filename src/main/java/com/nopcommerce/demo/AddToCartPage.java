package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddToCartPage extends Utils {
    public void setAddToCartLIst() {

        //Object declaration for SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //select add to cart button from products by using cssSelector
        List<WebElement> addToCartLIst = driver.findElements(By.cssSelector(".item-box .product-box-add-to-cart-button"));
        //System.out.println(addToCartLIst.size());
        for (WebElement al : addToCartLIst) {

            softAssert.assertEquals(al.getAttribute("value"), "Add to cart");
        }
        softAssert.assertAll();
    }
}