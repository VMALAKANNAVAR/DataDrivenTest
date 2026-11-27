package PageObjects;

import HelperGroup.CommandFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.Hashtable;

public class SignInPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }

    CommandFunctions commandFunctions = new CommandFunctions();
    @FindBy(id = "id_gender1")
    WebElement RadioButton;
    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement Name;
    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement emailId;
    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement Password;
    @FindBy(xpath = "//select[@data-qa='days']")
    WebElement DaysDD;
    @FindBy(xpath = "//select[@data-qa='months']")
    WebElement MonthsDD;
    @FindBy(xpath = "//select[@data-qa='years']")
    WebElement YearsDD;
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsLetterCheckbox;
    @FindBy(xpath = "//input[@id='optin']")
    WebElement EnableNotificationCheckBox;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement FirstNameInputBOX;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement LastNameInputBox;
    @FindBy(xpath = "//input[@id='company']")
    WebElement CompanayInputBox;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement Address1inputBox;
    @FindBy(xpath = "//input[@id='state']")
    WebElement stateInputBox;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityinputBox;
    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcodeInputBox;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileNumberInputBox;
    @FindBy(xpath = "//select[@id='country']")
    WebElement CountryDD;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement CreateAccountButton;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signUpName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpemailID;
    @FindBy(xpath = "//button[@type='submit' and @data-qa='signup-button']")
    WebElement signUpButton;
    @FindBy(xpath = "(//*[contains(text(),' Signup / Login')])[last()]")
    WebElement LoginHyperLink;

    public void SIGNUP(Hashtable<String, String> Data) {
        commandFunctions.ClickButton(LoginHyperLink, wait);
        commandFunctions.setText(signUpName, wait, Data.get("UserName"));
        commandFunctions.setText(signUpemailID, wait, Data.get("EmailID"));
        commandFunctions.ClickButton(signUpButton, wait);
        commandFunctions.ClickButton(RadioButton, wait);
        commandFunctions.setText(Name, wait, Data.get("UserName"));
        commandFunctions.setText(Password, wait, Data.get("Password"));
        commandFunctions.selectDropDownValue(DaysDD, wait, "1");
        commandFunctions.selectDropDownValue(MonthsDD, wait, "1");
        commandFunctions.selectDropDownValue(YearsDD, wait, "2020");
        commandFunctions.ClickButton(newsLetterCheckbox, wait);
        commandFunctions.ClickButton(EnableNotificationCheckBox, wait);
        commandFunctions.setText(FirstNameInputBOX, wait, Data.get("FirstName"));
        commandFunctions.setText(LastNameInputBox, wait, Data.get("lastName"));
        commandFunctions.setText(CompanayInputBox, wait, "VSCO");
        commandFunctions.setText(Address1inputBox, wait, Data.get("Address"));
        commandFunctions.selectDropDownValue(CountryDD, wait, Data.get("Country"));
        commandFunctions.setText(stateInputBox, wait, Data.get("State"));
        commandFunctions.setText(cityinputBox, wait, Data.get("City"));
        commandFunctions.setText(zipcodeInputBox, wait, Data.get("ZipCode"));
        commandFunctions.setText(mobileNumberInputBox, wait, Data.get("PhoneNumber"));
        commandFunctions.ClickButton(CreateAccountButton, wait);
    }

}
