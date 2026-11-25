package com.tester.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
}
