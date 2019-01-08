package com.nopcommerce.demo;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

    RegistrationPage register = new RegistrationPage();
    HomePage homePage = new HomePage();
    EmailAFriendPage emailAFriend = new EmailAFriendPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    ProductPage productPage = new ProductPage();
    AddToCartPage addToCartPage = new AddToCartPage();
    JewelryPageWithEuroCurrency jewelryPageWithEuroCurrency= new JewelryPageWithEuroCurrency();
    JewelryPageWithUSDollarCurrency jewelryPageWithUSDollarCurrency=new JewelryPageWithUSDollarCurrency();
    @Test(priority = 0)
    public void userShouldBeAbleToRegisterSuccessfully() {
        homePage.openHomePage();
        register.registration();
    }

    @Test(priority = 1 )

    public void registeredUserShouldBeAbleToSendEmailWithProductSuccessfully() {
         /* /*https://demo.nopcommerce.com/
      click on Apple MacBook Pro 13-inch - email a friend -fill up required details and click on Send Email button
      Registered user should be able to send Email with product Successfully*/
         homePage.openHomePage();
         register.registration();
        emailAFriend.emailAFriendForRegisterUser();
    }

    @Test(priority = 5)

    public void toVerifyUnRegisteredUserShouldNotBeAbleToSendEmail() {
        homePage.openHomePage();
        emailAFriend.emailAFriendForUnRegisterUser();
    }

    @Test(priority = 3)
    public void toVerifyUserMustHaveToAcceptTermsAndConditionForCheckOut(
    ) {
        homePage.openHomePage();
        register.registration();
        checkOutPage.userIsNotAbleToBuyProductSuccessFully();
    }

    @Test(priority = 2)
    public void toVerifyRegisteredUserShouldBeAbleToBuyAnySingleProductSuccessfully() {
        homePage.openHomePage();
        register.registration();
        checkOutPage.userIsAbleToBuyProductSuccessfully();
    }

    @Test(priority = 4)
    public void toVerifyUserShouldBeAbleToSortByPriceHighToLow() {
        homePage.openHomePage();
        productPage.sortBYPriceHighToLOw();

    }

    @Test(priority = 5)
    public void toVerifyUserShouldBePricesSortingLowToHigh() {
        homePage.openHomePage();
        productPage.sortByProductLowToHIgh();
    }

@Test
public void toVerifyAddToCartButtonIsPresentInAllProductOnHomePage() {
        homePage.openHomePage();
        addToCartPage.setAddToCartLIst();

}
@Test
    public void toVerifyCustomerCurrencyIsEuro(){
        homePage.openHomePage();
        jewelryPageWithEuroCurrency.currencyIsEuro();
}
@Test
public void toVerifyCustomerCurrencyIsDollar(){
        homePage.openHomePage();
        jewelryPageWithUSDollarCurrency.currencyIsDollar();
}
}