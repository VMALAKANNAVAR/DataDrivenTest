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

import java.io.IOException;
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


    public void ValidateCurrentURL(String URL) throws InterruptedException, IOException {
        Reports.createTest("Validate Current URL");
        Thread.sleep(2000);
        String CurrentURL=driver.getCurrentUrl();
        if(URL.equalsIgnoreCase(CurrentURL)) {
            Reports.ReportPassWithScreenshot("URL Validated succesfully");
        }
        else
            Reports.ReportFailWithScreenshot("URL Validated Failed");
    }


    public void EnterLoginDetails(String USN,String PSW) throws IOException {
        Reports.createTest("login Details");
        commanFunctions.setText(Username,USN);
        commanFunctions.setText(Password,PSW);
        Reports.ReportPassWithScreenshot("Added Login Details succesfully");
        commanFunctions.ClickElement(SubmitButton);


    }

}
