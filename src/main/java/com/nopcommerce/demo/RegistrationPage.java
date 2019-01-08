package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPage extends Utils {
    public void registration() {

        //Click on Register Button
        clickOnElement(By.linkText("Register"));

        //Click on gender
        clickOnElement(By.id("gender-male"));

        //Click on First Name
        enterText(By.id("FirstName"), "Kp");

        //Click on Last Name
        enterText(By.id("LastName"), "patel");

        //Date of Birth Field

        //Input Date of Birth Day by using Value
        Select dateOfBirthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dateOfBirthDay.selectByValue("6");

        //Input Date of Birth Month by using Index
        Select dateOfBirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dateOfBirthMonth.selectByIndex(4);

        //Input Date of Birth Year
        Select dateOfBirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dateOfBirthYear.selectByVisibleText("1979");

        //For Enter email Id

        //for Re enter Email id creating date format
     DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmSS");
       Date date = new Date();
       String date1 = dateFormat.format(date);

        //Entering email Address with Date Format

        //Variable Declaration for email Id
        String emailAddress = "kppatel+" + date1 + "@yahoo.com";

        //Entering email id in the email field
        driver.findElement(By.id("Email")).sendKeys(emailAddress);

        //For Company Detail
        //Enter Company name
        enterText(By.id("Company"), "Yogiraj");

        //For Options - Click on Newsletters box
        clickOnElement(By.id("Newsletter"));

        //For Your Password Field - password for registration

        //Declaring variable for password
        String password = "test123";

        //Entering Password in Password field
        enterText(By.id("Password"), password);

        //Confirming Password
        enterText(By.id("ConfirmPassword"), password);

        //Click on Registration Button
        clickOnElement(By.id("register-button"));

    //Declaring variable for expected Result
    String expectedRegisterSuccessMessage = "Your registration completed";

    //Declaring variable for actual result and getting actual result from the registration completed successful page
    String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();

    //Verifying for an account registration successfully
    Assert.assertEquals(actualRegisterSuccessMessage, expectedRegisterSuccessMessage, "Sorry your registration is not successful - It");


}

}

