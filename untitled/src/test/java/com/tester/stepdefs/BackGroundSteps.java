package com.tester.stepdefs;

import com.tester.Utils.Base;
import com.tester.Utils.Reports;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BackGroundSteps {

    WebDriver driver;


    @When("User launch WebSite")
    public void LaunchURL()
    {
       Reports.createTest("Website Launch");
       driver=Base.getWebDriver();
       driver.get("https://practicetestautomation.com/practice-test-login/");
       Reports.ReportPass("Launched Browser");
    }
}
