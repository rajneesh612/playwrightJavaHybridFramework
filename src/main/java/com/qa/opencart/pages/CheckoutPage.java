package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    Page page;
    private String billingDetailsContinueBtn = "#button-payment-address";



    // page constructor
    public CheckoutPage(Page page) {this.page = page;}

    // methods
    public void clickOnContinueBtnForBillingDetails(){
        page.click(billingDetailsContinueBtn);
    }




}
