package com.automation.listeners;

import com.automation.dataProviders.ConfigFileReader;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class extentReportListener extends TestListenerAdapter {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver; // Ensure driver is correctly initialized in your framework.

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Automation Team");
        extent.setSystemInfo("Environment", ConfigFileReader.getPropertyEnvironment());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());

        // Attach screenshot to report
        try {
            test.get().fail("Test Failed")
                    .fail(result.getThrowable(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            e.printStackTrace();
            test.get().fail("Screenshot could not be attached due to an error: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    private String captureScreenshot(String testName) {
        if(driver==null){
            driver = new ChromeDriver();  // Initialize driver if not already done
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";
        try {
            Files.createDirectories(new File(screenshotPath).getParentFile().toPath());
            Files.copy(screenshot.toPath(), new File(screenshotPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
