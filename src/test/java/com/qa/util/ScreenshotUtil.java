package com.qa.util;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {
    public static String captureScreenshot(Page page, String screenshotName) {
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }
}
