package com.qa.opencart.tests;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtendReportListner.ExtendReport;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.util.ReportLogger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @DataProvider
    public Object [][] getProductData(){
        return  new Object[][] {
                {"macbook"},
                {"samsung"},
                {"hp"}
        };
    }

    @Test
    public void homePageTitleTest(){
        String actualTitle =homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }



    @Test
    public void homePageURLTest(){
        String actualURL = homePage.getHomePageUrl();
        Assert.assertEquals(actualURL, prop.getProperty("url"));
    }

    @Test(dataProvider = "getProductData")
    public void searchProductTest(String productName){
        String searchHeader = homePage.product_search(productName);
        Assert.assertEquals(searchHeader,"Search - "+productName);

    }

    @Test
    public void clearTheCart()  {
        ExtentTest test = ExtendReport.createTest("Home Page Test", "Clear all products from the cart");
        test.assignCategory("Cart");
        test.assignAuthor("Rajneesh");
        try {
            ReportLogger.logInfo("add products to the cart");
            homePage.addToCartProduct("iphone");
            homePage.addToCartProduct("htc");
            homePage.addToCartProduct("hp");
            ReportLogger.logInfo("Click on the cart icon");
            cartPage= homePage.clickOnTheCartIcon();
            ReportLogger.logInfo("Removing all the products from the cart.");
            cartPage.removeAllProducts();
            Thread.sleep(5000);
            Assert.assertEquals(cartPage.getEmptyCartMsg(),"Your shopping cart is empty!");
            ReportLogger.logInfo(" Test Passed. ");
        } catch (InterruptedException e) {
            ReportLogger.logInfo("Test Failed "+e.getMessage());
            throw new RuntimeException(e);
        }

    }



}
