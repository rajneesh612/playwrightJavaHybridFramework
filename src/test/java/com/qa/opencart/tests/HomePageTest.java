package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
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




}
