package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    Page page;
    private String billingDetailsContinueBtn = "#button-payment-address";
    private String deliveryDetailsContinueBtn = "#button-shipping-address";
    private String shippingMethodContinueBtn = "#button-shipping-method";
    private String termsAndConditionCheckBox = "//input[@type='checkbox']";
    private String paymentMethodContinueBtn = "#button-payment-method";
    private String confirmOrderBtn = "#button-confirm";
    private String orderPlacedMsg = "//div[@id='content']//h1";



    // page constructor
    public CheckoutPage(Page page) {this.page = page;}

    // methods
    public CheckoutPage clickOnContinueBtnForBillingDetails(){
        page.click(billingDetailsContinueBtn);
        return this;
    }

    public CheckoutPage clickOnContinueBtnForDeliveryDetails(){
        page.click(deliveryDetailsContinueBtn);
        return this;
    }

    public CheckoutPage clickOnContinueBtnForShippingMethod(){
        page.click(shippingMethodContinueBtn);
        return this;
    }

    public CheckoutPage clickOnTermsAndContinueCheckbox(){
        page.click(termsAndConditionCheckBox);
        return this;
    }

    public CheckoutPage clickOnPaymentMethodContinueBtn(){
        page.click(paymentMethodContinueBtn);
        return this;
    }

    public void clickOnConfirmOrderBtn(){
        page.click(confirmOrderBtn);
    }

    public void completeCheckoutProcess(){
        clickOnContinueBtnForBillingDetails().clickOnContinueBtnForDeliveryDetails().
                clickOnContinueBtnForShippingMethod().clickOnTermsAndContinueCheckbox().
                clickOnPaymentMethodContinueBtn().clickOnConfirmOrderBtn();

    }

    public String getOrderConfirmationMsg(){
        return page.textContent(orderPlacedMsg);
    }

}
