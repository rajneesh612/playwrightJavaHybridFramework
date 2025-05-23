package com.qa.opencart.pages;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class LoginPage {

    private Page page;

    // String locator or object repository
    private String emailId= "#input-email";
    private String password = "#input-password";
    private  String loginBtn = "input[value='Login']";
    private  String invalidUserNameOrPasswordWarningMsg = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Passwo')]";


    // Page constructor
    public LoginPage(Page page){
        this.page = page;
    }

    public LoginPage enterEmail(String email){
        this.page.fill(emailId,email);
        return this;
    }

    public  LoginPage enterPassword(String passwd){
        this.page.fill(password,passwd);
        return this;
    }

    public void clickOnLogingBtn(){
        page.click(loginBtn);
    }

    public AccountPage do_login(String email, String passwd){
       new LoginPage(page).enterEmail(email).enterPassword(passwd).clickOnLogingBtn();
       return new AccountPage(this.page);
    }

    public String getPageTitle(){
        return page.title();
    }

    public String getInvalidUserNameOrPasswordWarningMsg() {
        return page.textContent(invalidUserNameOrPasswordWarningMsg);
    }
}
