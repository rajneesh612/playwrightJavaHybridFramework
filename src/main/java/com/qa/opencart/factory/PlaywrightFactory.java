package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();
        String url = prop.getProperty("url");
        System.out.println("browser is : "+browserName);
        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase());
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
        return page;

    }

    /**
     * this method used to initialize properties from config file.
     */
    public Properties init_prop(){
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
