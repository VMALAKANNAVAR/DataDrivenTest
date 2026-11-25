package com.tester;


import com.tester.Utils.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"com.tester.stepdefs"},
        monochrome = true,
        plugin = {"pretty", "json:target/cucumberreort.json", "html:target/cucumberreport.html"},
        tags="@test1"
)
public class Runner extends AbstractTestNGCucumberTests {


@DataProvider(parallel = true)
public Object[][] scenarios()
{
    return super.scenarios();
}

}
