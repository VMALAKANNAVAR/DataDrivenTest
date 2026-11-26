package com.tester.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static com.tester.stepdefs.Hooks.scenarioThreadLocal;

public class Reports {

    public static final ThreadLocal<ExtentReports> reporter=new ThreadLocal<>();
    public static  final ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    public static  void initilizeReport(String FilePath)
    {
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(FilePath);
        ExtentReports reports=new ExtentReports();
        reports.attachReporter(sparkReporter);
        reporter.set(reports);
    }

    public static void createTest(String TestName)
    {
         test.set(reporter.get().createTest(TestName));
    }

    public static  void endTest()
    {
        reporter.get().flush();
    }

    public static void ReportPass(String Message)
    {
        test.get().log(Status.PASS,Message);
    }

    public static void ReportWarnings(String Message)
    {
        test.get().log(Status.WARNING ,Message);
    }

    public static  void ReportFail(String Message)
    {
        test.get().log(Status.FAIL,Message);
    }

    public static String CreateScreenshot(String FilePath) throws IOException {
        Random random=new Random();
        WebDriver driver=Base.getWebDriver();
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BASE64);

    }

    public static void ReportPassWithScreenshot(String Message) throws IOException {
        Random random=new Random();
        String ScreenShotFilePath="src/ExtentReports/Screenshots/Screenshot/"+scenarioThreadLocal.get()+"/"+random.nextLong()+".png";
        test.get().log(Status.PASS,Message, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenshot(ScreenShotFilePath)).build());
    }

    public static void ReportFailWithScreenshot(String Message) throws IOException {
        Random random=new Random();
        String ScreenShotFilePath="src/ExtentReports/Screenshots/Screenshot/"+scenarioThreadLocal.get()+"/"+random.nextLong()+".png";
        test.get().log(Status.FAIL,Message, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenshot(ScreenShotFilePath)).build());
    }

    public static void ReportWarningWithScreenshot(String Message) throws IOException {
        Random random=new Random();
        String ScreenShotFilePath="src/ExtentReports/Screenshots/Screenshot/"+scenarioThreadLocal.get()+"/"+random.nextLong()+".png";
        test.get().log(Status.WARNING,Message, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenshot(ScreenShotFilePath)).build());
    }

}
