package com.tester.stepdefs;

import com.tester.Utils.Base;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BackGroundSteps {

    WebDriver driver;


    @When("User launch WebSite")
    public void LaunchURL()
    {
       Base.initializeDriver();
       driver=Base.getWebDriver();
       driver.get("https://practicetestautomation.com/practice-test-login/");
    }
}
