package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.ExtendReportListner.ExtendReport;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.*;
import com.qa.util.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    Page page;
    PlaywrightFactory pf;
    protected HomePage homePage;
    protected Properties prop;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;


    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop= pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);

    }

    @AfterTest
    public  void tearDown(){
        page.context().close();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(page, result.getName());
            ExtendReport.getTest().addScreenCaptureFromPath(screenshotPath);
        }
    }

}
