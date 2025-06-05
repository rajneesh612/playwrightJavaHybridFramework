package com.qa.opencart.tests;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtendReportListner.ExtendReport;
import com.qa.opencart.base.BaseTest;
import com.qa.util.ReportLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Test (priority = 0)
    public void placeOrder(){
        ExtentTest test = ExtendReport.createTest("Checkout page Test", "Place order");
        test.assignCategory("Account");
        test.assignAuthor("Rajneesh");

        try {
            ReportLogger.logInfo("Navigating to the login page.");
            loginPage = homePage.navigateToLoginPage();
            ReportLogger.logInfo("User is login with email and password.");
            accountPage = loginPage.do_login(prop.getProperty("userEmail"),prop.getProperty("userPassword"));
            homePage.addToCartProduct("hp");
            checkoutPage = homePage.clickOnTheCheckoutBtn();
            checkoutPage.clickOnContinueBtnForBillingDetails();

            //Assert.assertEquals(actualMsg, " Success: Your account has been successfully updated.");
            ReportLogger.logInfo("Test passed");
        } catch (Exception e) {
            ReportLogger.logInfo("Test Failed : "+e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
