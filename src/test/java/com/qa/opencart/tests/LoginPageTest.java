package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginValidUser(){
        loginPage = homePage.navigateToLoginPage();

        loginPage.do_login(prop.getProperty("userEmail"), prop.getProperty("userPassword"));
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, "My Account");
    }

    @Test
    public void loginInValidUser(){
        loginPage = homePage.navigateToLoginPage();

        loginPage.do_login(prop.getProperty("invalidUserEmail"), prop.getProperty("userPassword"));
        String actualMsg = loginPage.getInvalidUserNameOrPasswordWarningMsg();
        Assert.assertEquals(actualMsg, " Warning: No match for E-Mail Address and/or Password.");
    }


}
