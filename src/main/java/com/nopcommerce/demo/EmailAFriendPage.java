package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.nopcommerce.demo.Utils.clickOnElement;
import static com.nopcommerce.demo.Utils.enterText;

public class EmailAFriendPage extends BasePage{

    public void emailAFriendForRegisterUser(){
        clickOnElement(By.name("register-continue"));

        //Selecting Product Apple MavBook Pro 13-inch
        clickOnElement(By.linkText("Apple MacBook Pro 13-inch"));

        //Clicking on Email a Friend button to send Product detail with Email
        clickOnElement(By.xpath("//input[@value='Email a friend']"));

        //Entering Friends Email Address
        enterText(By.id("FriendEmail"), "pkpatel@yahoo.com");

        //Entering Personal Message
        enterText(By.id("PersonalMessage"), "It is very nice product have a look");

        //Clicking on send email button
        clickOnElement(By.name("send-email"));

        //Declaring variable for expected result
        String expectedSendEmailSuccessfullyMessage = "Your message has been sent.";

        //Declaring variable for actual result
        String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[@class= 'result']")).getText();
        //Verifying only registered customer can send email successfully
        Assert.assertEquals(actualRegisterSuccessMessage, expectedSendEmailSuccessfullyMessage, "Sorry You are not able to send email successfully");

    }
    public void emailAFriendForUnRegisterUser(){
//selecting Computer Field from the website
        clickOnElement(By.linkText("Computers"));

        //Selecting Desktop form category list of computer
        clickOnElement(By.linkText("Desktops"));

        //Selecting Product
        clickOnElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC"));

        //Clicking on email a friend button from the selected product
        clickOnElement(By.xpath("//input[@value='Email a friend']"));

        //Entering friend's email address
        enterText(By.id("FriendEmail"), "pnpatel@gmail.com");

        //Entering my email address
        enterText(By.id("YourEmailAddress"), "skpatel@hotmail.com");

        //Entering personal message
        enterText(By.id("PersonalMessage"), "I wanted to show you this nice product");

        //Clicking on send email button
        clickOnElement(By.name("send-email"));

        //Declaring variable for expected result
        String expectedErrorMessage = "Only registered customers can use email a friend feature";

        //Declaring variable for Actual result and
        String actualErrorMessage = driver.findElement(By.xpath("//li[contains(text(),'Only registered customers can use email a friend feature')]")).getText();

        //Verifying only registered customer can send email successfully
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Display Message is not as per expected, test is failed");
    }
}
