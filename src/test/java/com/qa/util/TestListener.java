package com.qa.util;

import com.aventstack.extentreports.Status;
import com.qa.ExtendReportListner.ExtendReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtendReport.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendReport.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendReport.getTest().log(Status.FAIL, result.getThrowable());

        // Add screenshot for failed tests
        String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
        ExtendReport.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtendReport.flushReport();
    }

    private String takeScreenshot(String methodName) {
        // Implement your screenshot capture logic using Playwright
        // Return the path where screenshot is saved
        return "path/to/screenshot.png";
    }
}
