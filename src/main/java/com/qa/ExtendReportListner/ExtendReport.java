package com.qa.ExtendReportListner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtendReport {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportName = "Test-Report-" + timeStamp + ".html";

            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
            htmlReporter.config().setDocumentTitle("Playwright Automation Report");
            htmlReporter.config().setReportName("Functional Testing");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "LocalHost");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", "Your Name");

            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("Playwright Automation Report");
            htmlReporter.config().setReportName("Regression Suite");
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
            htmlReporter.config().setCss(".badge-primary { background-color: #5c7cff; }");
            htmlReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Playwright Version", "1.42.0");
            extent.setSystemInfo("Test Environment", "Staging");
            htmlReporter.config().setTimelineEnabled(true);
            htmlReporter.config().thumbnailForBase64(true);
            htmlReporter.config().setEncoding("utf-8");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description) {
        ExtentTest extentTest = getInstance().createTest(testName, description);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
