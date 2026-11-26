package PageObjects;

import HelperGroup.CommandFunctions;
import HelperGroup.Reporting;
import org.aspectj.weaver.bcel.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    public WebDriver driver=null;
    public WebDriverWait wait;

    private CommandFunctions commandFunctions=new CommandFunctions();
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
     WebElement Username;
    @FindBy(xpath = "//input[@id='password']")
     WebElement Password;
    @FindBy(xpath = "//*[@id='submit']")
     WebElement SubmitButton;


    public void userLogin(String userName,String password)
    {
        Reporting.Createtest("Login Validation");
        commandFunctions.setText(Username,wait,userName);
        commandFunctions.setText(Password,wait,password);
        Reporting.reportPassWithScreenShot("Login Details are added");
        commandFunctions.ClickButton(SubmitButton,wait);
        Reporting.reportPassWithScreenShot("Login Succesfull");

    }




}
