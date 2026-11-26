package HelperGroup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static HelperGroup.Base.getDriver;

public class Reporting {

    public static final ThreadLocal<ExtentReports> reports=new ThreadLocal<>();
    public static final ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    public static void InitiateReport(String FilePath)
    {
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(FilePath);
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        reports.set(extentReports);
    }

    public static void Createtest(String TestName)
    {
        test.set(reports.get().createTest(TestName));
    }

    public static void ReportPass(String step)
    {
        test.get().log(Status.PASS,step);
    }

    public static void ReportFail(String step)
    {
        test.get().log(Status.FAIL,step);
    }

    public static void ReportWarning(String step)
    {
        test.get().log(Status.WARNING,step);
    }

    public static String CreateScreenShot()
    {
        TakesScreenshot screenshot=(TakesScreenshot)Base.getDriver();
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void reportPassWithScreenShot(String Step)
    {
        test.get().log(Status.PASS,Step, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenShot()).build());
    }

    public static void reportFailWithScreenShot(String Step)
    {
        test.get().log(Status.FAIL,Step, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenShot()).build());
    }

    public static void reportWarningWithScreenShot(String Step)
    {
        test.get().log(Status.WARNING,Step, MediaEntityBuilder.createScreenCaptureFromBase64String(CreateScreenShot()).build());
    }

    public static void endtest()
    {
        reports.get().flush();
    }

}
