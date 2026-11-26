package HelperGroup;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    public  int counter=0;
    @Override
    public boolean retry(ITestResult result) {

        if(counter<1)
        {
            counter++;
            return true;
        }
        return false;
    }
}
