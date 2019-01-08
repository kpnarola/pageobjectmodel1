package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.nopcommerce.demo.Utils.clickOnElement;
import static com.nopcommerce.demo.Utils.enterText;

public class CheckOutPage extends BasePage{

    public void userIsNotAbleToBuyProductSuccessFully(){
        //click on continue button for continuing other page for selecting product
        clickOnElement(By.name("register-continue"));

        //Selecting Product
        clickOnElement(By.linkText("Build your own computer"));

        //Selecting Hdd button in product Description
        clickOnElement(By.id("product_attribute_3_6"));

        //Clicking on add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));

        //Clicking on shopping cart button
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        //Clicking on Checkout button
        clickOnElement(By.id("checkout"));

        //Declaring variable for expected result
        String expectedErrorMessage = "Please accept the terms of service before the next step.";

        //Declaring variable for actual result and getting actual result from the page
        String actualErrorMessage = driver.findElement(By.xpath("//p[contains(text(),'Please accept the terms of service before the next step.')]")).getText();

        //Verifying for buying any product successfully user must have to accept terms and condition
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Display message is not as per expected, Test failed");
    }

    public void userIsAbleToBuyProductSuccessfully(){
        //click on continue button
        clickOnElement(By.name("register-continue"));

        //Selecting Product
        clickOnElement(By.linkText("HTC One M8 Android L 5.0 Lollipop"));

        //Clicking on add to cart button
        clickOnElement(By.id("add-to-cart-button-18"));

        //Clicking on shopping cart button
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Clicking on terms of service
        clickOnElement(By.id("termsofservice"));

        //Clicking on Checkout button
        clickOnElement(By.id("checkout"));

        //Selecting country for billing adress
        Select country = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country.selectByVisibleText("United Kingdom");

        //Entering city name
        enterText(By.id("BillingNewAddress_City"), "London");

        //Entering first line of message
        enterText(By.id("BillingNewAddress_Address1"), "15,Talbet Road");

        //Entering Second line of message
        enterText(By.id("BillingNewAddress_Address2"), "Wembley");

        //Entering postal code
        enterText(By.id("BillingNewAddress_ZipPostalCode"), "HA04UA");

        //Entering phone number
        enterText(By.id("BillingNewAddress_PhoneNumber"), "07894234443");

        //Entering Fax number
        enterText(By.id("BillingNewAddress_FaxNumber"), "02073638352");

        //Clicking on continue button for shipping method
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        //Step - 3 Shipping Method

        //Clicking on first option Ground from Shipping method
        clickOnElement(By.id("shippingoption_0"));

        //Clicking on continue button for Payment Method
        clickOnElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));

        //Step-4 Payment method

        //Click on Credit Card option
        clickOnElement(By.id("paymentmethod_1"));

        //Click on continue button for payment information
        clickOnElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));

        //Step 5- Payment Information

        //Entering card holder name
        enterText(By.id("CardholderName"), "Shital");

        //Entering Card number
        enterText(By.id("CardNumber"), "4111 1111 1111 1111");

        //Entering Expire month for Credit card
        Select expireDate = new Select(driver.findElement(By.id("ExpireMonth")));
        expireDate.selectByValue("2");

        //Entering Expire Year
        Select expireYear = new Select(driver.findElement(By.id("ExpireYear")));
        expireYear.selectByVisibleText("2020");

        //Entering short code
        enterText(By.id("CardCode"), "737");

        //Clicking on Continue button for order confirmation
        clickOnElement(By.xpath("//input[@onclick=\"PaymentInfo.save()\"]"));

        //Step 6-Confirm Order

        //Clicking on Confirm Order button
        clickOnElement(By.xpath("//input[@onclick=\"ConfirmOrder.save()\"]"));

        //Declaring String for expected result
        String expectedResult = "Your order has been successfully processed!";

        //declaring string for actual result
        String actualResult = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();

        //Verifying  Registered user can buy any single product successfully
        Assert.assertEquals(expectedResult, actualResult, "You are not able to buy product successfully, test failed");
    }

    }

