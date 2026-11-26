package com.tester;


import com.tester.Utils.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @AfterSuite
    public static void Reportings()
    {
        List<String> jsonFilePath=new ArrayList<>();
        File filePath=new File("target/cucumberreort.json");
        jsonFilePath.add(filePath.getAbsolutePath());
        Configuration configuration=new Configuration(new File("target/FinalReport/"),"Test");
        configuration.addClassifications("Environement","QA");
        configuration.setBuildNumber("Test");
        new ReportBuilder(jsonFilePath,configuration).generateReports();
    }

}
