package HelperGroup;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test Skipped");
    }

}
