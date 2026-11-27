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
import java.util.Hashtable;
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

    @FindBy(xpath = "//*[contains(text(),' Signup / Login')]") WebElement LoginHyperLink;
    @FindBy(xpath = "//*[@name='email' and @data-qa='login-email']")
     WebElement Username;
    @FindBy(xpath = "//*[@name='password' and @data-qa='login-password']")
     WebElement Password;
    @FindBy(xpath = "//*[@data-qa='login-button']")
     WebElement SubmitButton;
    @FindBy(xpath = "//*[contains(text(),' Logout')]") WebElement LogoutButton;
    String logoutButton="//*[contains(text(),'Logout')]";

    public void userLogin(Hashtable<String,String> data)
    {
        Reporting.Createtest("Login Validation");
        commandFunctions.ClickButton(LoginHyperLink,wait);
        commandFunctions.setText(Username,wait,data.get("EmailID"));
        commandFunctions.setText(Password,wait,data.get("Password"));
        Reporting.reportPassWithScreenShot("Login Details are added");
        commandFunctions.ClickButton(SubmitButton,wait);
        if(!commandFunctions.validatElementPresence(logoutButton))
        {
            SignInPage signInPage=new SignInPage(driver);
            signInPage.SIGNUP(data);
        }
        Reporting.reportPassWithScreenShot("Login Succesfull");
    }
}
