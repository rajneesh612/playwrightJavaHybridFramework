package com.qa.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.qa.ExtendReportListner.ExtendReport;

public class ReportLogger {
    public static void logPass(String message) {
        ExtendReport.getTest().log(Status.PASS, message);
    }

    public static void logFail(String message, Page page) {
        ExtentTest test = ExtendReport.getTest();
        test.log(Status.FAIL, message);
        ScreenshotUtil.attachScreenshotToReport(test, page, "FailureScreenshot");
    }

    public static void logInfo(String message) {
        ExtendReport.getTest().log(Status.INFO, message);
    }

    public static void logWarning(String message) {
        ExtendReport.getTest().log(Status.WARNING, message);
    }
}
