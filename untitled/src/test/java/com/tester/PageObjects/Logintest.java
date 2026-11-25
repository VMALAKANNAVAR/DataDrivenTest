package com.tester.PageObjects;

import com.tester.Utils.Base;
import com.tester.Utils.CommanFunctions;
import com.tester.Utils.Reports;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Logintest {

    private WebDriver driver;
    private WebDriverWait wait;
    CommanFunctions commanFunctions =new CommanFunctions();
    public Logintest(WebDriver driver)
    {
        this.driver= driver;
        this.driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        this.wait=new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(20));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']") WebElement Username;
    @FindBy(xpath = "//input[@id='password']") WebElement Password;
    @FindBy(xpath = "//*[@id='submit']") WebElement SubmitButton;


    public void ValidateCurrentURL(String URL) throws InterruptedException {
        Reports.createTest("Validate Current URL");
        Thread.sleep(2000);
        String CurrentURL=driver.getCurrentUrl();
        Assert.assertEquals("User is on LoginPage",CurrentURL,URL);
        Reports.ReportPass("URL Validated succesfully");

    }


    public void EnterLoginDetails(String USN,String PSW)
    {
        Reports.createTest("Validated login Fucntion");
        commanFunctions.setText(Username,USN);
        commanFunctions.setText(Password,PSW);
        commanFunctions.ClickElement(SubmitButton);
        Reports.ReportPass("Added Login Details succesfully");

    }

}
