package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountPage {
    private Page page;
    private String editYourAccount = "a:text('Edit your account information')";
    private String firstName = "#input-firstname";
    private String lastname = "#input-lastname";
    private String continumeBtn = "//input[@value='Continue']";
    private String successMsg = "//div[contains(text(),'Success: Your account has been successfully update')]";

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

}
