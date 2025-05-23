package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {

    @Test
    public void editYourAccount(){
        loginPage = homePage.navigateToLoginPage();
        accountPage = loginPage.do_login(prop.getProperty("userEmail"),prop.getProperty("userPassword"));
        accountPage.clickOnEditAccount();
        accountPage.editUserAccountInfo();
        String actualMsg = accountPage.getSuccessMsg();
        Assert.assertEquals(actualMsg, " Success: Your account has been successfully updated.");

    }

}
