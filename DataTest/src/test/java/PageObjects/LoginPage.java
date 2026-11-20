package PageObjects;

import HelperGroup.CommandFunctions;
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

    CommandFunctions commandFunctions=new CommandFunctions();
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']") WebElement Username;
    @FindBy(xpath = "//input[@id='password']") WebElement Password;
    @FindBy(xpath = "//*[@id='submit']") WebElement SubmitButton;

    public void setUserName(String userName)
    {
        commandFunctions.setText(Username,wait,userName);

    }

    public void setPassword(String password)
    {
        commandFunctions.setText(Password,wait,password);
    }

    public void ClickSubmit()
    {
        commandFunctions.ClickButton(SubmitButton,wait);
    }


}
