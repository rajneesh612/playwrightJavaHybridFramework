package com.qa.opencart.tests;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtendReportListner.ExtendReport;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import com.qa.util.ReportLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test(priority = 3)
    public void loginValidUser(){
        ExtentTest test = ExtendReport.createTest("Login Test", "Valid login scenario");
        test.assignCategory("Authentication");
        test.assignAuthor("Rajneesh");
        try {
            ReportLogger.logInfo("Navigating to the login page.");
            loginPage = homePage.navigateToLoginPage();
            ReportLogger.logInfo("Entering valid Email and password");
            loginPage.do_login(prop.getProperty("userEmail"), prop.getProperty("userPassword"));
            String actualTitle = loginPage.getPageTitle();
            Assert.assertEquals(actualTitle, "My Account");
            ReportLogger.logInfo("Test passed successfully.");
        } catch (Exception e) {
            ReportLogger.logInfo("Test failed :" +e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void loginInValidUser(){

        ExtentTest test = ExtendReport.createTest("Login Test", "Invalid email login scenario");
        test.assignCategory("Authentication");
        test.assignAuthor("Rajneesh");

        try {
            ReportLogger.logInfo("Navigate to login page.");
            loginPage = homePage.navigateToLoginPage();
            ReportLogger.logInfo("Entering invalid email.");
            loginPage.do_login(prop.getProperty("invalidUserEmail"), prop.getProperty("userPassword"));
            String actualMsg = loginPage.getInvalidUserNameOrPasswordWarningMsg();
            Assert.assertEquals(actualMsg, " Warning: No match for E-Mail Address and/or Password.");
            ReportLogger.logInfo("Test Passed ");
        } catch (Exception e) {
            ReportLogger.logInfo("Test Failed :" +e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Test(priority = 1)
    public void loginInValidPassword(){
        ExtentTest test = ExtendReport.createTest("Login Test", "Incorrect password login scenario");
        test.assignCategory("Authentication");
        test.assignAuthor("Rajneesh");

        try {
            ReportLogger.logInfo("Navigating to the login page.");
            loginPage = homePage.navigateToLoginPage();
            ReportLogger.logInfo("Entering wrong password.");
            loginPage.do_login(prop.getProperty("userEmail"), prop.getProperty("invalidUserPassword"));
            String actualMsg = loginPage.getInvalidUserNameOrPasswordWarningMsg();
            Assert.assertEquals(actualMsg, " Warning: No match for E-Mail Address and/or Password.");
            ReportLogger.logInfo("Test Passed");
        } catch (Exception e) {
            ReportLogger.logInfo("Test Failed : " +e.getMessage());
            throw new RuntimeException(e);
        }

    }



}
