package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountPage {
    private Page page;
    private String editYourAccount = "a:text('Edit your account information')";
    private String firstName = "#input-firstname";
    private String lastname = "#input-lastname";
    private String continumeBtn = "//input[@value='Continue']";
    private String successMsg = "//div[contains(text(),'Success: Your account has been successfully update')]";
    private String viewOrderHistory = "//a[normalize-space()='View your order history']";
    private String orderHistoryPageHeading = "//h1[normalize-space()='Order History']";
    private String search = "//input[@placeholder='Search']";
    private String serachIcon = "div#search button";
    private String addressBook = "//a[text()='Address Book']";
    private String newAddressBtn = "//a[text()='New Address']";
    // Page constructor
    public AccountPage(Page page){
        this.page = page;
    }

    //methods
    public  void clickOnEditAccount(){
        page.click(editYourAccount);
    }

    public AccountPage editFirstName(){
        page.fill(firstName,"#editedName");
        return this;
    }

    public AccountPage editLastName(){
        page.fill(lastname,"#editedLastName");
        return this;
    }

    public void clickOnContinueBtn(){
        page.click(continumeBtn);

    }
    public void editUserAccountInfo(){
        new AccountPage(page).editFirstName().editLastName().clickOnContinueBtn();
    }

    public String getSuccessMsg(){
        return page.textContent(successMsg);
    }

    public void clickOnViewOrderHistory(){
        page.click(viewOrderHistory);
    }

    public String getOrderHistoryPageText(){
        return page.textContent(orderHistoryPageHeading);
    }

    public CheckoutPage product_search(String productName){
        page.fill(search,productName);
        page.click(serachIcon);
        return new CheckoutPage(this.page);
    }

    public void clickOnAddressBook(){
        page.locator(addressBook).click();
    }

    public void clickOnNewAddressBtn(){
        page.click(newAddressBtn);
    }

}
