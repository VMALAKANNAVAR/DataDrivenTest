package com.tester.stepdefs;

import com.tester.PageObjects.Logintest;
import com.tester.Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginpageSteps {

    Logintest test=new Logintest(Base.getWebDriver());
    @When("user should reach to {string}")
    public void ValidateLoginPageURL(String URL) throws InterruptedException {
        test.ValidateCurrentURL(URL);
    }

    @And("^User enter (.*) and (.*) and Click on loginButton$")
    public void AddLoginDetails(String USN,String PSW)
    {
       System.out.println("USN is"+USN+" and PSW is "+PSW);
       test.EnterLoginDetails(USN,PSW);
    }
}
