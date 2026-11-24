package com.tester;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"com.tester.stepdefs"},
        monochrome = true,
        plugin = {"pretty", "json:target/cucumberreort.json", "html:target/cucumberreport.html"},
        tags="@test1"
)

public class Runner extends AbstractTestNGCucumberTests {


}
