package com.tester.stepdefs;

import com.tester.Utils.Base;
import com.tester.Utils.Reports;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Hooks {

    public static final ThreadLocal<Scenario> scenarioThreadLocal=new ThreadLocal<>();
    WebDriver driver;
    @After(value="@test1 or @test2")
    public void closeBrowser()
    {
        Reports.endTest();
        Base.closeWebSite();

    }

    @Before(order=1,value="@test1")
    public void launchBrowser(Scenario scenario)
    {
        scenarioThreadLocal.set(scenario);
        Random random=new Random();
        String FileName= "Reports"+random.nextLong()+".html";
        Reports.initilizeReport("src/ExtentReports/"+scenario.getName()+FileName);
        Base.initializeDriver();
        driver=Base.getWebDriver();
        driver.manage().window().maximize();
    }

    @BeforeStep
    public void PrinterBefore()
    {
        System.out.println("Loading...");
    }

    @AfterStep
    public void Printer()
    {
        System.out.println("Loaded Method");
    }
}
