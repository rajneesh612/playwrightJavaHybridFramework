package com.qa.util;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {
    public static String captureScreenshot(Page page, String testName) {
        String path = "test-output/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        return path;
    }
    public static void attachScreenshotToReport(ExtentTest test, Page page, String name) {
        String screenshotPath = captureScreenshot(page, name);
        test.addScreenCaptureFromPath(screenshotPath, name);
    }
}

