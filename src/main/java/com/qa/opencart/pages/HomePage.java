package com.qa.opencart.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

public class HomePage {
    private Page page;
    // String locator or object repository
    private String search = "//input[@placeholder='Search']";
    private String serachIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String myAccountBtn = "(//span[normalize-space()='My Account'])[1]";
    private String loginLink = "(//a[text()='Login'])[1]";
    private String addToCart = "//span[normalize-space()='Add to Cart']";
    private String checkoutBtn = "//a[@title='Checkout']";
    private String secondAddToCartBtn = "#button-cart";
    private String cartIcon = "//a[@title='Shopping Cart']";

    // Page constructor
    public HomePage(Page page){
        this.page = page;
    }

    // Page action / methods
    public String getHomePageTitle()
    {
        System.out.println(" Home page title is : "+page.title());
        return page.title();
    }

    public String getHomePageUrl(){
        System.out.println("Home page url is : "+page.url());
        return page.url();
    }

    public String product_search(String productName){
        page.fill(search,productName);
        page.click(serachIcon);
        return page.textContent(searchPageHeader);
    }



    public LoginPage navigateToLoginPage(){
        page.click(myAccountBtn);
        page.click(loginLink);
        return  new LoginPage(this.page);
    }

    public HomePage clickAddToCartAProduct(){
        this.page.click(addToCart);
        return this;
    }

    public void addToCartProduct(String productName){
        page.fill(search,productName);
        page.click(serachIcon);
        page.click(addToCart);
        try {
            page.waitForSelector(secondAddToCartBtn, new Page.WaitForSelectorOptions().setTimeout(5000)); // Max 5 sec wait
            page.locator(secondAddToCartBtn).click();
            System.out.println("Button clicked!");
        } catch (PlaywrightException e) {
            System.out.println("Button did not appear within timeout, skipping.");
        }

            }

    public CheckoutPage clickOnTheCheckoutBtn(){
        page.click(checkoutBtn);
        return new CheckoutPage(this.page);
    }

    public CartPage clickOnTheCartIcon(){
        page.click(cartIcon);
        return new CartPage(this.page);
    }



}
