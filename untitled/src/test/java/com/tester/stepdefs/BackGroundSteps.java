package com.tester.stepdefs;

import com.tester.Utils.Base;
import com.tester.Utils.Reports;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BackGroundSteps {

    WebDriver driver;


    @When("User launch WebSite")
    public void LaunchURL() throws IOException {
       Reports.createTest("Website Launch");
       driver=Base.getWebDriver();
       driver.get("https://practicetestautomation.com/practice-test-login/");
       Reports.ReportPassWithScreenshot("Launched Browser");
    }
}
