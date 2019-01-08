package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage{

    //Reusable method for click
    public static void clickOnElement(By by){ driver.findElement(by).click();}

    //Reusable method for SendKey
    public static void enterText(By by, String text){driver.findElement(by).sendKeys(text);}

    //Reusable method for time stamp

    public static void timeStamp(){

        DateFormat dateFormat = new SimpleDateFormat( "DDMMYYYYSSmmHH");

        Date date = new Date();
     String date1 = dateFormat.format(date);

    }

    public static void selectBy(By by){
        driver.findElement(by).isSelected();
    }

    public static void explicitWait(By by){

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("computers")));
    }



}

