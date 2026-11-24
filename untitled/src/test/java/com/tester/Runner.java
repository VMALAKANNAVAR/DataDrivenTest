package com.tester;


import com.tester.Utils.Base;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"com.tester.stepdefs"},
        monochrome = true,
        plugin = {"pretty", "json:target/cucumberreort.json", "html:target/cucumberreport.html"},
        tags="@test1"
)
public class Runner extends AbstractTestNGCucumberTests {

@DataProvider(parallel = true)
public Object[][] DataProviderMethod()
{
    return super.scenarios();
}

@AfterMethod
public void closeBrowser()
{
    Base.closeWebSite();
}
}
