package com.qa.opencart.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CartPage {
    private Page page;

    // String locator or object repository
    private String cancleBtn = "//button[@data-original-title='Remove']";
    private String emptyCartMsg = "//div[@id ='content']//p";

    // Page constructor
    public CartPage(Page page){
        this.page = page;
    }

    // Page action / methods

    public void removeAllProducts() {
        // Multiple elements के लिए locator set करें
        Locator cancelButtons = page.locator(cancleBtn);
        for (int i = cancelButtons.count(); i > 0; i--) {
            cancelButtons.nth(i-1).click(); // this will click all close button
        }
    }

    public String getEmptyCartMsg(){
            return page.textContent(emptyCartMsg);
        }


}
