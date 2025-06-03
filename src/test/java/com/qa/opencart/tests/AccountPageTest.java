package com.qa.opencart.tests;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtendReportListner.ExtendReport;
import com.qa.opencart.base.BaseTest;
import com.qa.util.ReportLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {

    @Test
    public void editYourAccount(){
        ExtentTest test = ExtendReport.createTest("Account Page Test", "Edit account info");
        test.assignCategory("Account");
        test.assignAuthor("Rajneesh");

        try {
            ReportLogger.logInfo("Navigating to the login page.");
            loginPage = homePage.navigateToLoginPage();
            ReportLogger.logInfo("User is login with email and password.");
            accountPage = loginPage.do_login(prop.getProperty("userEmail"),prop.getProperty("userPassword"));
            ReportLogger.logInfo("Clicking on the Edit account button");
            accountPage.clickOnEditAccount();
            ReportLogger.logInfo("Edit user first name and last name.");

            accountPage.editUserAccountInfo();
            String actualMsg = accountPage.getSuccessMsg();
            Assert.assertEquals(actualMsg, " Success: Your account has been successfully updated.");
            ReportLogger.logInfo("Test passed");
        } catch (Exception e) {
            ReportLogger.logInfo("Test Failed : "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
